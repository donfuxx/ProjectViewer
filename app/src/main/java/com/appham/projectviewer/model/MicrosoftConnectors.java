
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MicrosoftConnectors implements Parcelable {

    @SerializedName("enabled")
    @Expose
    public Boolean enabled;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.enabled);
    }

    public MicrosoftConnectors() {
    }

    protected MicrosoftConnectors(Parcel in) {
        this.enabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<MicrosoftConnectors> CREATOR = new Parcelable.Creator<MicrosoftConnectors>() {
        @Override
        public MicrosoftConnectors createFromParcel(Parcel source) {
            return new MicrosoftConnectors(source);
        }

        @Override
        public MicrosoftConnectors[] newArray(int size) {
            return new MicrosoftConnectors[size];
        }
    };
}
