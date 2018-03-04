
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Defaults implements Parcelable
{

    @SerializedName("privacy")
    @Expose
    private String privacy;
    public final static Creator<Defaults> CREATOR = new Creator<Defaults>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Defaults createFromParcel(Parcel in) {
            return new Defaults(in);
        }

        public Defaults[] newArray(int size) {
            return (new Defaults[size]);
        }

    }
    ;

    protected Defaults(Parcel in) {
        this.privacy = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Defaults() {
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("privacy", privacy).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(privacy);
    }

    public int describeContents() {
        return  0;
    }

}
