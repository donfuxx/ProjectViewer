
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Project implements Parcelable
{

    @SerializedName("replyByEmailEnabled")
    @Expose
    private boolean replyByEmailEnabled;
    @SerializedName("starred")
    @Expose
    private boolean starred;
    @SerializedName("show-announcement")
    @Expose
    private boolean showAnnouncement;
    @SerializedName("harvest-timers-enabled")
    @Expose
    private boolean harvestTimersEnabled;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("subStatus")
    @Expose
    private String subStatus;
    @SerializedName("defaultPrivacy")
    @Expose
    private String defaultPrivacy;
    @SerializedName("integrations")
    @Expose
    private Integrations integrations;
    @SerializedName("created-on")
    @Expose
    private String createdOn;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("filesAutoNewVersion")
    @Expose
    private boolean filesAutoNewVersion;
    @SerializedName("overview-start-page")
    @Expose
    private String overviewStartPage;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("last-changed-on")
    @Expose
    private String lastChangedOn;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("defaults")
    @Expose
    private Defaults defaults;
    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("tasks-start-page")
    @Expose
    private String tasksStartPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("privacyEnabled")
    @Expose
    private boolean privacyEnabled;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("announcement")
    @Expose
    private String announcement;
    @SerializedName("isProjectAdmin")
    @Expose
    private boolean isProjectAdmin;
    @SerializedName("start-page")
    @Expose
    private String startPage;
    @SerializedName("notifyeveryone")
    @Expose
    private boolean notifyeveryone;
    @SerializedName("boardData")
    @Expose
    private BoardData boardData;
    @SerializedName("announcementHTML")
    @Expose
    private String announcementHTML;
    public final static Creator<Project> CREATOR = new Creator<Project>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        public Project[] newArray(int size) {
            return (new Project[size]);
        }

    }
    ;

    protected Project(Parcel in) {
        this.replyByEmailEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.starred = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.showAnnouncement = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.harvestTimersEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.subStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.defaultPrivacy = ((String) in.readValue((String.class.getClassLoader())));
        this.integrations = ((Integrations) in.readValue((Integrations.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((Category) in.readValue((Category.class.getClassLoader())));
        this.filesAutoNewVersion = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.overviewStartPage = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.tags, (Tag.class.getClassLoader()));
        this.logo = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.lastChangedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.defaults = ((Defaults) in.readValue((Defaults.class.getClassLoader())));
        this.company = ((Company) in.readValue((Company.class.getClassLoader())));
        this.tasksStartPage = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.privacyEnabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.announcement = ((String) in.readValue((String.class.getClassLoader())));
        this.isProjectAdmin = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.startPage = ((String) in.readValue((String.class.getClassLoader())));
        this.notifyeveryone = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.boardData = ((BoardData) in.readValue((BoardData.class.getClassLoader())));
        this.announcementHTML = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Project() {
    }

    public boolean isReplyByEmailEnabled() {
        return replyByEmailEnabled;
    }

    public void setReplyByEmailEnabled(boolean replyByEmailEnabled) {
        this.replyByEmailEnabled = replyByEmailEnabled;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public boolean isHarvestTimersEnabled() {
        return harvestTimersEnabled;
    }

    public void setHarvestTimersEnabled(boolean harvestTimersEnabled) {
        this.harvestTimersEnabled = harvestTimersEnabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getDefaultPrivacy() {
        return defaultPrivacy;
    }

    public void setDefaultPrivacy(String defaultPrivacy) {
        this.defaultPrivacy = defaultPrivacy;
    }

    public Integrations getIntegrations() {
        return integrations;
    }

    public void setIntegrations(Integrations integrations) {
        this.integrations = integrations;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFilesAutoNewVersion() {
        return filesAutoNewVersion;
    }

    public void setFilesAutoNewVersion(boolean filesAutoNewVersion) {
        this.filesAutoNewVersion = filesAutoNewVersion;
    }

    public String getOverviewStartPage() {
        return overviewStartPage;
    }

    public void setOverviewStartPage(String overviewStartPage) {
        this.overviewStartPage = overviewStartPage;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Defaults getDefaults() {
        return defaults;
    }

    public void setDefaults(Defaults defaults) {
        this.defaults = defaults;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTasksStartPage() {
        return tasksStartPage;
    }

    public void setTasksStartPage(String tasksStartPage) {
        this.tasksStartPage = tasksStartPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivacyEnabled() {
        return privacyEnabled;
    }

    public void setPrivacyEnabled(boolean privacyEnabled) {
        this.privacyEnabled = privacyEnabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isIsProjectAdmin() {
        return isProjectAdmin;
    }

    public void setIsProjectAdmin(boolean isProjectAdmin) {
        this.isProjectAdmin = isProjectAdmin;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public boolean isNotifyeveryone() {
        return notifyeveryone;
    }

    public void setNotifyeveryone(boolean notifyeveryone) {
        this.notifyeveryone = notifyeveryone;
    }

    public BoardData getBoardData() {
        return boardData;
    }

    public void setBoardData(BoardData boardData) {
        this.boardData = boardData;
    }

    public String getAnnouncementHTML() {
        return announcementHTML;
    }

    public void setAnnouncementHTML(String announcementHTML) {
        this.announcementHTML = announcementHTML;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("replyByEmailEnabled", replyByEmailEnabled).append("starred", starred).append("showAnnouncement", showAnnouncement).append("harvestTimersEnabled", harvestTimersEnabled).append("status", status).append("subStatus", subStatus).append("defaultPrivacy", defaultPrivacy).append("integrations", integrations).append("createdOn", createdOn).append("category", category).append("filesAutoNewVersion", filesAutoNewVersion).append("overviewStartPage", overviewStartPage).append("tags", tags).append("logo", logo).append("startDate", startDate).append("id", id).append("lastChangedOn", lastChangedOn).append("endDate", endDate).append("defaults", defaults).append("company", company).append("tasksStartPage", tasksStartPage).append("name", name).append("privacyEnabled", privacyEnabled).append("description", description).append("announcement", announcement).append("isProjectAdmin", isProjectAdmin).append("startPage", startPage).append("notifyeveryone", notifyeveryone).append("boardData", boardData).append("announcementHTML", announcementHTML).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(replyByEmailEnabled);
        dest.writeValue(starred);
        dest.writeValue(showAnnouncement);
        dest.writeValue(harvestTimersEnabled);
        dest.writeValue(status);
        dest.writeValue(subStatus);
        dest.writeValue(defaultPrivacy);
        dest.writeValue(integrations);
        dest.writeValue(createdOn);
        dest.writeValue(category);
        dest.writeValue(filesAutoNewVersion);
        dest.writeValue(overviewStartPage);
        dest.writeList(tags);
        dest.writeValue(logo);
        dest.writeValue(startDate);
        dest.writeValue(id);
        dest.writeValue(lastChangedOn);
        dest.writeValue(endDate);
        dest.writeValue(defaults);
        dest.writeValue(company);
        dest.writeValue(tasksStartPage);
        dest.writeValue(name);
        dest.writeValue(privacyEnabled);
        dest.writeValue(description);
        dest.writeValue(announcement);
        dest.writeValue(isProjectAdmin);
        dest.writeValue(startPage);
        dest.writeValue(notifyeveryone);
        dest.writeValue(boardData);
        dest.writeValue(announcementHTML);
    }

    public int describeContents() {
        return  0;
    }

}
