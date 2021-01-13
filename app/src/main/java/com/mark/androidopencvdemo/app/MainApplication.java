package com.mark.androidopencvdemo.app;

import android.app.Application;

public class MainApplication extends Application {

    private static MainApplication instance;

    public static Application getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initSDK();
    }

    private void initSDK(){

    }
}
