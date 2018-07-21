package com.example.gottgried.rxdagger2_maps.di.application;



import android.content.Context;

import com.example.gottgried.rxdagger2_maps.di.scope.PerApplication;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Gottgried on 26.06.2018.
 */

@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

        Retrofit exposeRetrofir();

        Context exposeContext();
}
