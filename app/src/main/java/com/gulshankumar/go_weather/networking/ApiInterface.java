package com.gulshankumar.go_weather.networking;

import com.gulshankumar.go_weather.models.WeatherForecastModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    
    
    @POST("forecast.json")
    Observable<WeatherForecastModel> getWeatherForecast(@QueryMap Map<String,String> parameters);
    
}
