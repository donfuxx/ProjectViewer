
package com.appham.projectviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BoardData implements Parcelable
{

    public final static Creator<BoardData> CREATOR = new Creator<BoardData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BoardData createFromParcel(Parcel in) {
            return new BoardData(in);
        }

        public BoardData[] newArray(int size) {
            return (new BoardData[size]);
        }

    }
    ;

    protected BoardData(Parcel in) {
    }

    public BoardData() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
