
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Defaults implements Parcelable {

    @SerializedName("privacy")
    @Expose
    public String privacy;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.privacy);
    }

    public Defaults() {
    }

    protected Defaults(Parcel in) {
        this.privacy = in.readString();
    }

    public static final Parcelable.Creator<Defaults> CREATOR = new Parcelable.Creator<Defaults>() {
        @Override
        public Defaults createFromParcel(Parcel source) {
            return new Defaults(source);
        }

        @Override
        public Defaults[] newArray(int size) {
            return new Defaults[size];
        }
    };
}
