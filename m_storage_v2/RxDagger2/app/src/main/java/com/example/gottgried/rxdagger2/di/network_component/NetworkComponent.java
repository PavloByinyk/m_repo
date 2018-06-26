package com.example.gottgried.rxdagger2.di.network_component;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Gottgried on 10.06.2018.
 */


@Component(modules = NetworkModule.class)
@Singleton
public interface NetworkComponent {

    Retrofit retrofit();
}
