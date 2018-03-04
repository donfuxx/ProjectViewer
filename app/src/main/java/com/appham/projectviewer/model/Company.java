
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Company implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is-owner")
    @Expose
    private String isOwner;
    @SerializedName("id")
    @Expose
    private String id;
    public final static Creator<Company> CREATOR = new Creator<Company>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        public Company[] newArray(int size) {
            return (new Company[size]);
        }

    }
    ;

    protected Company(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.isOwner = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("isOwner", isOwner).append("id", id).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(isOwner);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
