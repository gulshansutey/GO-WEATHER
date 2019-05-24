package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastDay implements Parcelable {
    
    @SerializedName("date")
    @Expose
    private String date;
    
    @SerializedName("day")
    @Expose
    private Day day;
    
    protected ForecastDay(Parcel in) {
        this.date = in.readString();
        this.day =((Day) in.readValue((Day.class.getClassLoader())));
    }
    
    public static final Creator<ForecastDay> CREATOR = new Creator<ForecastDay>() {
        @Override
        public ForecastDay createFromParcel(Parcel in) {
            return new ForecastDay(in);
        }
        
        @Override
        public ForecastDay[] newArray(int size) {
            return new ForecastDay[size];
        }
    };
    
    public Day getDay() {
        return day;
    }
    
    public void setDay(Day day) {
        this.day = day;
    }
    
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeValue(day);
    }
    
    
    public String getDateMilli() {
        return date;
    }
    
    public void setDateMilli(long dateMili) {
        this.date = date;
    }
}
