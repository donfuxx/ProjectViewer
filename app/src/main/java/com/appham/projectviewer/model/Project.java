
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project implements Parcelable {

    @SerializedName("replyByEmailEnabled")
    @Expose
    public Boolean replyByEmailEnabled;
    @SerializedName("starred")
    @Expose
    public Boolean starred;
    @SerializedName("show-announcement")
    @Expose
    public Boolean showAnnouncement;
    @SerializedName("harvest-timers-enabled")
    @Expose
    public Boolean harvestTimersEnabled;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("subStatus")
    @Expose
    public String subStatus;
    @SerializedName("defaultPrivacy")
    @Expose
    public String defaultPrivacy;
    @SerializedName("integrations")
    @Expose
    public Integrations integrations;
    @SerializedName("created-on")
    @Expose
    public String createdOn;
    @SerializedName("category")
    @Expose
    public Category category;
    @SerializedName("filesAutoNewVersion")
    @Expose
    public Boolean filesAutoNewVersion;
    @SerializedName("overview-start-page")
    @Expose
    public String overviewStartPage;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("last-changed-on")
    @Expose
    public String lastChangedOn;
    @SerializedName("endDate")
    @Expose
    public String endDate;
    @SerializedName("defaults")
    @Expose
    public Defaults defaults;
    @SerializedName("company")
    @Expose
    public Company company;
    @SerializedName("tasks-start-page")
    @Expose
    public String tasksStartPage;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("privacyEnabled")
    @Expose
    public Boolean privacyEnabled;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("announcement")
    @Expose
    public String announcement;
    @SerializedName("isProjectAdmin")
    @Expose
    public Boolean isProjectAdmin;
    @SerializedName("start-page")
    @Expose
    public String startPage;
    @SerializedName("notifyeveryone")
    @Expose
    public Boolean notifyeveryone;
    @SerializedName("boardData")
    @Expose
    public BoardData boardData;
    @SerializedName("announcementHTML")
    @Expose
    public String announcementHTML;

    public Project() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.replyByEmailEnabled);
        dest.writeValue(this.starred);
        dest.writeValue(this.showAnnouncement);
        dest.writeValue(this.harvestTimersEnabled);
        dest.writeString(this.status);
        dest.writeString(this.subStatus);
        dest.writeString(this.defaultPrivacy);
        dest.writeParcelable(this.integrations, flags);
        dest.writeString(this.createdOn);
        dest.writeParcelable(this.category, flags);
        dest.writeValue(this.filesAutoNewVersion);
        dest.writeString(this.overviewStartPage);
        dest.writeList(this.tags);
        dest.writeString(this.logo);
        dest.writeString(this.startDate);
        dest.writeString(this.id);
        dest.writeString(this.lastChangedOn);
        dest.writeString(this.endDate);
        dest.writeParcelable(this.defaults, flags);
        dest.writeParcelable(this.company, flags);
        dest.writeString(this.tasksStartPage);
        dest.writeString(this.name);
        dest.writeValue(this.privacyEnabled);
        dest.writeString(this.description);
        dest.writeString(this.announcement);
        dest.writeValue(this.isProjectAdmin);
        dest.writeString(this.startPage);
        dest.writeValue(this.notifyeveryone);
        dest.writeParcelable(this.boardData, flags);
        dest.writeString(this.announcementHTML);
    }

    protected Project(Parcel in) {
        this.replyByEmailEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.starred = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.showAnnouncement = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.harvestTimersEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.status = in.readString();
        this.subStatus = in.readString();
        this.defaultPrivacy = in.readString();
        this.integrations = in.readParcelable(Integrations.class.getClassLoader());
        this.createdOn = in.readString();
        this.category = in.readParcelable(Category.class.getClassLoader());
        this.filesAutoNewVersion = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.overviewStartPage = in.readString();
        this.tags = new ArrayList<Tag>();
        in.readList(this.tags, Tag.class.getClassLoader());
        this.logo = in.readString();
        this.startDate = in.readString();
        this.id = in.readString();
        this.lastChangedOn = in.readString();
        this.endDate = in.readString();
        this.defaults = in.readParcelable(Defaults.class.getClassLoader());
        this.company = in.readParcelable(Company.class.getClassLoader());
        this.tasksStartPage = in.readString();
        this.name = in.readString();
        this.privacyEnabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.description = in.readString();
        this.announcement = in.readString();
        this.isProjectAdmin = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.startPage = in.readString();
        this.notifyeveryone = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.boardData = in.readParcelable(BoardData.class.getClassLoader());
        this.announcementHTML = in.readString();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
