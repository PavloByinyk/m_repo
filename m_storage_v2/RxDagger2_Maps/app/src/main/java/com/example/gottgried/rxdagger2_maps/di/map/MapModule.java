package com.example.gottgried.rxdagger2_maps.di.map;

import com.example.gottgried.rxdagger2_maps.api.MapApiService;
import com.example.gottgried.rxdagger2_maps.base.mvp.IBaseView;
import com.example.gottgried.rxdagger2_maps.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Gottgried on 26.06.2018.
 */

@PerActivity
@Module
public class MapModule {

    private IBaseView mView;

    public MapModule(IBaseView mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    MapApiService provideMapApiService(Retrofit retrofit) {
        return retrofit.create(MapApiService.class);
    }


    @PerActivity
    @Provides
    IBaseView provideIBaseView() {
        return mView;
    }
}