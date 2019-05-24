package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {
    
    @SerializedName("name")
    @Expose
    private String locationName;
    
    protected Location(Parcel in) {
        locationName = in.readString();
    }
    
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }
        
        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    
    public String getLocationName() {
        return locationName;
    }
    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(locationName);
    }
}
