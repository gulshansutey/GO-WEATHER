package com.gulshankumar.go_weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherForecastModel implements Parcelable {
    
    @SerializedName("location")
    @Expose
    private Location location;
    
    @SerializedName("current")
    @Expose
    private Current current;
    
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;
    
    
    protected WeatherForecastModel(Parcel in) {
        location = in.readParcelable(Location.class.getClassLoader());
        current = in.readParcelable(Current.class.getClassLoader());
        forecast = in.readParcelable(Forecast.class.getClassLoader());
    }
    
    public static final Creator<WeatherForecastModel> CREATOR = new Creator<WeatherForecastModel>() {
        @Override
        public WeatherForecastModel createFromParcel(Parcel in) {
            return new WeatherForecastModel(in);
        }
        
        @Override
        public WeatherForecastModel[] newArray(int size) {
            return new WeatherForecastModel[size];
        }
    };
    
    public Location getLocation() {
        return location;
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Current getCurrent() {
        return current;
    }
    
    public void setCurrent(Current current) {
        this.current = current;
    }
    
    
    public Forecast getForecast() {
        return forecast;
    }
    
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    
        dest.writeParcelable(location, flags);
        dest.writeParcelable(current, flags);
        dest.writeParcelable(forecast, flags);
    }
}
