package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current implements Parcelable{
    
    @SerializedName("temp_c")
    @Expose
    private Double temp;
    
    public final static Parcelable.Creator<Current> CREATOR = new Parcelable.Creator<Current>() {
        @Override
        public Current createFromParcel(Parcel source) {
            return new Current(source);
        }
    
        @Override
        public Current[] newArray(int size) {
            return new Current[size];
        }
    };
    
    protected Current(Parcel source) {
        this.temp = source.readDouble();
    }
    
    
    public Double getTemp() {
        return temp;
    }
    
    public void setTemp(Double temp) {
        this.temp = temp;
    }
    
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(temp);
    }
}
