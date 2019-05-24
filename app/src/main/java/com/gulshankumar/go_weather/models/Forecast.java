package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast implements Parcelable {
    
    @SerializedName("forecastday")
    @Expose
    private List<ForecastDay> forecastdayList;
    
    protected Forecast(Parcel in) {
        in.readList(this.forecastdayList, ForecastDay.class.getClassLoader());
    }
    
    public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }
        
        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
    
    public List<ForecastDay> getForecastdayList() {
        return forecastdayList;
    }
    
    public void setForecastdayList(List<ForecastDay> forecastdayList) {
        this.forecastdayList = forecastdayList;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(forecastdayList);
    }
    
}
