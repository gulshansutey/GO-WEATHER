package com.gulshankumar.go_weather.networking;

import io.reactivex.disposables.Disposable;

public class MyApiObserver<T> implements io.reactivex.Observer<T> {
    
    
    
    private ApiCallbacks callbacks;
    private int requestCode;
    
    public MyApiObserver(ApiCallbacks callbacks, int requestCode){
        this.callbacks=callbacks;
        this.requestCode=requestCode;
    }
    
    @Override
    public void onSubscribe(Disposable d) {
        callbacks.onSubscribe(d,requestCode );
    }
    
    @Override
    public void onNext(T t) {
        callbacks.onNext(t,requestCode);
    }
    
    @Override
    public void onError(Throwable e) {
        callbacks.onError(e,requestCode);
    }
    
    @Override
    public void onComplete() {
    }
    
    public interface ApiCallbacks {
        void onNext(Object dataModel, int requestCode);
        
        void onError(Throwable throwable, int requestCode);
        
        void onSubscribe(Disposable d, int requestCode);
    }
}
