
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Onedrivebusiness implements Parcelable
{

    @SerializedName("enabled")
    @Expose
    private boolean enabled;
    @SerializedName("folder")
    @Expose
    private String folder;
    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("foldername")
    @Expose
    private String foldername;
    public final static Creator<Onedrivebusiness> CREATOR = new Creator<Onedrivebusiness>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Onedrivebusiness createFromParcel(Parcel in) {
            return new Onedrivebusiness(in);
        }

        public Onedrivebusiness[] newArray(int size) {
            return (new Onedrivebusiness[size]);
        }

    }
    ;

    protected Onedrivebusiness(Parcel in) {
        this.enabled = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.folder = ((String) in.readValue((String.class.getClassLoader())));
        this.account = ((String) in.readValue((String.class.getClassLoader())));
        this.foldername = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Onedrivebusiness() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enabled", enabled).append("folder", folder).append("account", account).append("foldername", foldername).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(enabled);
        dest.writeValue(folder);
        dest.writeValue(account);
        dest.writeValue(foldername);
    }

    public int describeContents() {
        return  0;
    }

}
