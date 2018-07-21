package com.example.gottgried.rxdagger2_maps.application;

import android.app.Application;

import com.example.gottgried.rxdagger2_maps.di.application.ApplicationComponent;
import com.example.gottgried.rxdagger2_maps.di.application.ApplicationModule;
import com.example.gottgried.rxdagger2_maps.di.application.DaggerApplicationComponent;


/**
 * Created by Gottgried on 26.06.2018.
 */

public class MapApplication extends Application {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
