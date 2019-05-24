package com.gulshankumar.go_weather.networking;

import android.support.annotation.NonNull;

import com.gulshankumar.go_weather.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    
    private static Retrofit retrofit;
    
    public static ApiInterface makeRequest(){
        if (retrofit==null){
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(headers())
                .build();
        }
        return retrofit.create(ApiInterface.class);
    }
    
    private static OkHttpClient headers(){
        HttpLoggingInterceptor interceptor =new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder clientBuilder =new OkHttpClient.Builder();
        clientBuilder.addInterceptor(interceptor);
        clientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Content-Type","application/json").build();
                return chain.proceed(request);
            }
        });
    
        return clientBuilder.build();
    }
    
}
