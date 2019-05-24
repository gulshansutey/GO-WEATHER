package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day implements Parcelable {
    @SerializedName("avgtemp_c")
    @Expose
    private Double averageTemp;
    
    protected Day(Parcel in) {
        if (in.readByte() == 0) {
            averageTemp = 0.0;
        } else {
            averageTemp = in.readDouble();
        }
    }
    
    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }
        
        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
    
    public Double getAverageTemp() {
        return averageTemp;
    }
    
    public void setAverageTemp(Double averageTemp) {
        this.averageTemp = averageTemp;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        if (averageTemp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(averageTemp);
        }
    }
}
