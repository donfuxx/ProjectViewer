
package com.appham.projectviewer.model;


import android.os.Parcel;
import android.os.Parcelable;

public class BoardData implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public BoardData() {
    }

    protected BoardData(Parcel in) {
    }

    public static final Parcelable.Creator<BoardData> CREATOR = new Parcelable.Creator<BoardData>() {
        @Override
        public BoardData createFromParcel(Parcel source) {
            return new BoardData(source);
        }

        @Override
        public BoardData[] newArray(int size) {
            return new BoardData[size];
        }
    };
}
