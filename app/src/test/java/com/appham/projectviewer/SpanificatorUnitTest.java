package com.appham.projectviewer;

import android.text.SpannableStringBuilder;

import com.appham.projectviewer.model.Company;
import com.appham.projectviewer.model.Tag;
import com.appham.projectviewer.utils.Spanificator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class SpanificatorUnitTest {

    @Test
    public void testEmptyObjectLeadsToEmptySpanBuilder() throws Exception {

        SpannableStringBuilder spanBuilder = Spanificator.appendObjectFields(
                new SpannableStringBuilder(), new Object(), "", "", 1f);

        assertEquals(0, spanBuilder.length());
    }

    @Test
    public void testValidObjectLeadsToNonEmptySpanBuilder() throws Exception {

        Company company = new Company();
        company.setId("123id");
        company.setIsOwner("yeah");
        company.setName("Super Test Corp.");

        SpannableStringBuilder spanBuilder = Spanificator.appendObjectFields(
                new SpannableStringBuilder(), company, ": ", "\n", 1f);

        assertEquals("spanBuilder has incorrect length: \n" + spanBuilder, 47, spanBuilder.length());
    }

    @Test
    public void testFieldValuesAreContainedInSpanBuilder() throws Exception {

        Tag tag = new Tag();
        tag.setName("cool");
        tag.setColor("#ffffff");
        tag.setId("123id");

        SpannableStringBuilder spanBuilder = Spanificator.appendObjectFields(
                new SpannableStringBuilder(), tag, ": ", "\n", 1f);

        assertTrue("spanBuilder did not contain the tag name: \n" + spanBuilder,
                spanBuilder.toString().contains("name: cool\n"));
    }
}