package com.example.gottgried.rxdagger2.di;

import com.example.gottgried.rxdagger2.service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Gottgried on 10.06.2018.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    FlowerService provideFlowerService(Retrofit retrofit){
        return retrofit.create(FlowerService.class);
    }
}
