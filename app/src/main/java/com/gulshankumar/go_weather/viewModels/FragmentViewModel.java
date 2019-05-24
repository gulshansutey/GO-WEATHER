package com.gulshankumar.go_weather.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.gulshankumar.go_weather.adapters.ForecastRecyclerAdapter;
import com.gulshankumar.go_weather.models.Day;
import com.gulshankumar.go_weather.models.ForecastDay;
import com.gulshankumar.go_weather.utills.DateUtill;

import java.util.List;


public class FragmentViewModel extends ViewModel {
    
    public MutableLiveData<String> currentLocation = new MutableLiveData<>();
    public MutableLiveData<String> currentTemp = new MutableLiveData<>();
    
    
    public void setErrorMesg(String errorMesg) {
        this.errorMesg.setValue(errorMesg);
    }
    
    public MutableLiveData<String> errorMesg = new MutableLiveData<>();
    private ForecastRecyclerAdapter recyclerAdapter;
    private List<ForecastDay> forecastDays;
    
    public void setForecastAdapter(List<ForecastDay> forecastdays) {
        this.forecastDays = forecastdays;
        recyclerAdapter = new ForecastRecyclerAdapter(this, forecastdays.size());
    }
    
    public Day getForecastDay(int position) {
        return forecastDays.get(position).getDay();
    }
    
    public void notifyAdapter() {
        recyclerAdapter.setSize(forecastDays.size());
    }
    
    public String getForecastDayName(int position) {
        return DateUtill.convertMilliToDate(forecastDays.get(position).getDateMilli());
    }
    
    public String getForecastDayTemp(int position) {
        return String.format("%s %s", forecastDays.get(position).getDay().getAverageTemp(), "C");
    }
    
    public ForecastRecyclerAdapter getAdapter() {
        return recyclerAdapter;
    }
    
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation.setValue(currentLocation);
    }
    
    public void setCurrentTemp(String currentTemp) {
        this.currentTemp.setValue(currentTemp);
    }
    
    public void onErrorClick(FragmentClickCallbacks clickCallbacks){
        clickCallbacks.onRetry();
    }
    
    public interface FragmentClickCallbacks{
        void onRetry();
    }
    
    
}
