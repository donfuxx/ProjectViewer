
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectsList implements Parcelable {

    @SerializedName("STATUS")
    @Expose
    public String sTATUS;
    @SerializedName("projects")
    @Expose
    public List<Project> projects = null;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sTATUS);
        dest.writeTypedList(this.projects);
    }

    public ProjectsList() {
    }

    protected ProjectsList(Parcel in) {
        this.sTATUS = in.readString();
        this.projects = in.createTypedArrayList(Project.CREATOR);
    }

    public static final Parcelable.Creator<ProjectsList> CREATOR = new Parcelable.Creator<ProjectsList>() {
        @Override
        public ProjectsList createFromParcel(Parcel source) {
            return new ProjectsList(source);
        }

        @Override
        public ProjectsList[] newArray(int size) {
            return new ProjectsList[size];
        }
    };
}
