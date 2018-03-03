
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Integrations implements Parcelable {

    @SerializedName("microsoftConnectors")
    @Expose
    public MicrosoftConnectors microsoftConnectors;
    @SerializedName("onedrivebusiness")
    @Expose
    public Onedrivebusiness onedrivebusiness;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.microsoftConnectors, flags);
        dest.writeParcelable(this.onedrivebusiness, flags);
    }

    public Integrations() {
    }

    protected Integrations(Parcel in) {
        this.microsoftConnectors = in.readParcelable(MicrosoftConnectors.class.getClassLoader());
        this.onedrivebusiness = in.readParcelable(Onedrivebusiness.class.getClassLoader());
    }

    public static final Parcelable.Creator<Integrations> CREATOR = new Parcelable.Creator<Integrations>() {
        @Override
        public Integrations createFromParcel(Parcel source) {
            return new Integrations(source);
        }

        @Override
        public Integrations[] newArray(int size) {
            return new Integrations[size];
        }
    };
}
