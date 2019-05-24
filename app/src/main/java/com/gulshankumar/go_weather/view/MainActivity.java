package com.gulshankumar.go_weather.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gulshankumar.go_weather.R;
import com.gulshankumar.go_weather.databinding.ActivityMainBinding;
import com.gulshankumar.go_weather.models.WeatherForecastModel;
import com.gulshankumar.go_weather.networking.MyApiObserver;
import com.gulshankumar.go_weather.networking.RetrofitBuilder;
import com.gulshankumar.go_weather.view.fragments.ErrorFragment;
import com.gulshankumar.go_weather.view.fragments.ForecastFragment;
import com.gulshankumar.go_weather.view.fragments.ProgressFragment;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MyApiObserver.ApiCallbacks, ErrorFragment.FragmentInteractionListener {
    private int container_id;
    private final int API_REQ_CODE = 10;
    private static final String FORECAST_FOR_DAYS = "4";
    private static final String FORECAST_LATLNG_FOR_LOCATION = "12.9716,77.5946";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        container_id = binding.fragmentContainer.getId();
        getWeatherDataAPI();
    }
    
    private void getWeatherDataAPI(){
        Map<String,String> requestParams =new HashMap<>();
        requestParams.put("key","your key here");
        requestParams.put("q",FORECAST_LATLNG_FOR_LOCATION);
        requestParams.put("days",FORECAST_FOR_DAYS);
       RetrofitBuilder.makeRequest().getWeatherForecast(requestParams).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new MyApiObserver<WeatherForecastModel>(MainActivity.this,API_REQ_CODE));
    }
    
    @Override
    public void onNext(Object dataModel, int requestCode) {
        System.out.println("dataModel = " + dataModel);
            if (API_REQ_CODE == requestCode){
                WeatherForecastModel forecastModel = (WeatherForecastModel)dataModel;
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(container_id, ForecastFragment.newInstance(forecastModel))
                        .commit();
            }
    }
    
    @Override
    public void onError(Throwable throwable, int requestCode) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(container_id, ErrorFragment.newInstance(getString(R.string.error_mesg_txt),this))
                .commit();
    }
    
    @Override
    public void onSubscribe(Disposable d, int requestCode) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(container_id, ProgressFragment.newInstance())
                .commit();
    }
    
    @Override
    public void onRetry() {
        getWeatherDataAPI();
    }
}
