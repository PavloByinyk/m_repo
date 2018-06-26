package com.example.gottgried.rxdagger2.di.network_component;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gottgried on 17.06.2018.
 */

@Module
public class NetworkModule {

    public String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }


    @Provides
    @Singleton
    public RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }
}
