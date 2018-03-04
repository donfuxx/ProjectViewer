package com.appham.projectviewer.utils;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author thomas
 */

public abstract class Spanificator {

    /**
     * Gets all the fields of the provided object and will append the field names and values
     * in the specified Styles to the provided SpannableStringBuilder.
     * Useful for displaying any pojo in a structured way without the need to get each field
     * one-by-one.
     *
     * @param spanBuilder the SpannableStringBuilder where the field names and values get appended to
     * @param pojo the object to "spanify"
     * @param nameSeparator the String to separate name from value
     * @param valueSeparator the String to put after the value
     * @return the spanBuilder with styled field names and values
     */
    @NonNull
    public static SpannableStringBuilder appendObjectFields(
            @NonNull SpannableStringBuilder spanBuilder, @NonNull Object pojo,
            @NonNull String nameSeparator, @NonNull String valueSeparator) {

        // get all fields and loop through them to display each
        List<Field> fields = Arrays.asList(pojo.getClass().getDeclaredFields());
        String name;
        Object value;

        for (Field field : fields) {
            try {
                name = field.getName();
                field.setAccessible(true);
                value = field.get(pojo);
                Log.i("fields", "name: " + name + " - value: " + value + " type: " + field.getType());

                int startIndex = spanBuilder.length();

                // don't display "CREATOR" or empty fields
                if ("CREATOR".equals(name) || StringUtils.isAllBlank(String.valueOf(value))) continue;

                if (isDisplayable(value)) { // String or other displayable value
                    spanBuilder.append(name)
                            .append(nameSeparator)
                            .append(String.valueOf(value))
                            .append(valueSeparator);
                } else if (value instanceof Collection) { // value is a Collection of other objects
                    Collection values = (Collection) value;
                    spanBuilder.append(name)
                            .append(nameSeparator);
                    for (Object obj : values) {
                        spanBuilder.append(obj.getClass().getSimpleName())
                                .append(": ")
                                .append(appendObjectFields(new SpannableStringBuilder(), obj, ": ", ", "))
                                .append("\n");
                    }
                    spanBuilder.append(valueSeparator);
                } else { // value is another pojo
                    spanBuilder.append(name)
                            .append(nameSeparator)
                            .append(appendObjectFields(new SpannableStringBuilder(), value, ": ", "; "))
                            .append(valueSeparator);
                }

                spanBuilder.setSpan(new StyleSpan(Typeface.BOLD), startIndex, startIndex + name.length(), 0);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return spanBuilder;
    }

    private static boolean isDisplayable(@Nullable Object value) {
        return value instanceof String ||
                value instanceof Boolean ||
                value instanceof Integer ||
                value instanceof Long;
    }

}
