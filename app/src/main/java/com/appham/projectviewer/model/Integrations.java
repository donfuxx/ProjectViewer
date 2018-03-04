
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Integrations implements Parcelable
{

    @SerializedName("microsoftConnectors")
    @Expose
    private MicrosoftConnectors microsoftConnectors;
    @SerializedName("onedrivebusiness")
    @Expose
    private Onedrivebusiness onedrivebusiness;
    public final static Creator<Integrations> CREATOR = new Creator<Integrations>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Integrations createFromParcel(Parcel in) {
            return new Integrations(in);
        }

        public Integrations[] newArray(int size) {
            return (new Integrations[size]);
        }

    }
    ;

    protected Integrations(Parcel in) {
        this.microsoftConnectors = ((MicrosoftConnectors) in.readValue((MicrosoftConnectors.class.getClassLoader())));
        this.onedrivebusiness = ((Onedrivebusiness) in.readValue((Onedrivebusiness.class.getClassLoader())));
    }

    public Integrations() {
    }

    public MicrosoftConnectors getMicrosoftConnectors() {
        return microsoftConnectors;
    }

    public void setMicrosoftConnectors(MicrosoftConnectors microsoftConnectors) {
        this.microsoftConnectors = microsoftConnectors;
    }

    public Onedrivebusiness getOnedrivebusiness() {
        return onedrivebusiness;
    }

    public void setOnedrivebusiness(Onedrivebusiness onedrivebusiness) {
        this.onedrivebusiness = onedrivebusiness;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("microsoftConnectors", microsoftConnectors).append("onedrivebusiness", onedrivebusiness).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(microsoftConnectors);
        dest.writeValue(onedrivebusiness);
    }

    public int describeContents() {
        return  0;
    }

}
