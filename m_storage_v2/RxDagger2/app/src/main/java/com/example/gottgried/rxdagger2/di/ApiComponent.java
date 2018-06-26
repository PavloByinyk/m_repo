package com.example.gottgried.rxdagger2.di;

import com.example.gottgried.rxdagger2.ui.FlowerActivity;
import com.example.gottgried.rxdagger2.di.network_component.NetworkComponent;

import dagger.Component;

/**
 * Created by Gottgried on 10.06.2018.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(FlowerActivity activity);
}
