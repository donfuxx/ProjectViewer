
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class ProjectsList implements Parcelable
{

    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("projects")
    @Expose
    private List<Project> projects = new ArrayList<Project>();
    public final static Creator<ProjectsList> CREATOR = new Creator<ProjectsList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProjectsList createFromParcel(Parcel in) {
            return new ProjectsList(in);
        }

        public ProjectsList[] newArray(int size) {
            return (new ProjectsList[size]);
        }

    }
    ;

    protected ProjectsList(Parcel in) {
        this.sTATUS = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.projects, (Project.class.getClassLoader()));
    }

    public ProjectsList() {
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sTATUS", sTATUS).append("projects", projects).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sTATUS);
        dest.writeList(projects);
    }

    public int describeContents() {
        return  0;
    }

}
