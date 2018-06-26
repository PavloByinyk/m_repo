package com.example.gottgried.rxdagger2_maps.di.map;

import com.example.gottgried.rxdagger2_maps.di.application.ApplicationComponent;
import com.example.gottgried.rxdagger2_maps.di.scope.PerActivity;
import com.example.gottgried.rxdagger2_maps.modules.home.MapActivity;

import dagger.Component;
import dagger.Provides;

/**
 * Created by Gottgried on 26.06.2018.
 */

@PerActivity
@Component(modules = MapModule.class, dependencies = ApplicationComponent.class)
public interface MapComponent {

    void inject(MapActivity activity);
}
