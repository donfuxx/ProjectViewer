
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MicrosoftConnectors implements Parcelable
{

    @SerializedName("enabled")
    @Expose
    private boolean enabled;
    public final static Creator<MicrosoftConnectors> CREATOR = new Creator<MicrosoftConnectors>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MicrosoftConnectors createFromParcel(Parcel in) {
            return new MicrosoftConnectors(in);
        }

        public MicrosoftConnectors[] newArray(int size) {
            return (new MicrosoftConnectors[size]);
        }

    }
    ;

    protected MicrosoftConnectors(Parcel in) {
        this.enabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public MicrosoftConnectors() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enabled", enabled).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(enabled);
    }

    public int describeContents() {
        return  0;
    }

}
