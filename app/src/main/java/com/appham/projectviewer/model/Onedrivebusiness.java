
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Onedrivebusiness implements Parcelable {

    @SerializedName("enabled")
    @Expose
    public Boolean enabled;
    @SerializedName("folder")
    @Expose
    public String folder;
    @SerializedName("account")
    @Expose
    public String account;
    @SerializedName("foldername")
    @Expose
    public String foldername;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.enabled);
        dest.writeString(this.folder);
        dest.writeString(this.account);
        dest.writeString(this.foldername);
    }

    public Onedrivebusiness() {
    }

    protected Onedrivebusiness(Parcel in) {
        this.enabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.folder = in.readString();
        this.account = in.readString();
        this.foldername = in.readString();
    }

    public static final Parcelable.Creator<Onedrivebusiness> CREATOR = new Parcelable.Creator<Onedrivebusiness>() {
        @Override
        public Onedrivebusiness createFromParcel(Parcel source) {
            return new Onedrivebusiness(source);
        }

        @Override
        public Onedrivebusiness[] newArray(int size) {
            return new Onedrivebusiness[size];
        }
    };
}
