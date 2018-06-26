package com.example.gottgried.rxdagger2_maps.application;

import android.app.Application;

import com.example.gottgried.rxdagger2_maps.di.application.DaggerApplicationComponent;


/**
 * Created by Gottgried on 26.06.2018.
 */

public class MapApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeAppComponent();
    }

    private void initializeAppComponent() {
        DaggerApplicationComponent.builder().build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
