package com.example.gottgried.rxdagger2.application;

import android.app.Application;

import com.example.gottgried.rxdagger2.di.ApiComponent;
import com.example.gottgried.rxdagger2.di.DaggerApiComponent;
import com.example.gottgried.rxdagger2.di.network_component.DaggerNetworkComponent;
import com.example.gottgried.rxdagger2.di.network_component.NetworkComponent;
import com.example.gottgried.rxdagger2.di.network_component.NetworkModule;

/**
 * Created by Gottgried on 17.06.2018.
 */

public class FlowerApplication extends Application {

    private ApiComponent apiComponent;


    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        apiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule("http://services.hanselandpetal.com"))
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
