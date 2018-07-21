package com.example.gottgried.rxdagger2_maps.di.map;

import com.example.gottgried.rxdagger2_maps.api.MapApiService;
import com.example.gottgried.rxdagger2_maps.base.mvp.IBaseView;
import com.example.gottgried.rxdagger2_maps.di.scope.PerActivity;
import com.example.gottgried.rxdagger2_maps.modules.home.IMapContract;
import com.example.gottgried.rxdagger2_maps.modules.home.MapPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Gottgried on 26.06.2018.
 */

@PerActivity
@Module
public class MapModule {

    public IMapContract.IView mView;

    public MapModule(IMapContract.IView mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    MapApiService provideMapApiService(Retrofit retrofit) {
        return retrofit.create(MapApiService.class);
    }


    @PerActivity
    @Provides
    IMapContract.IView provideIBaseView() {
        return mView;
    }

    @PerActivity
    @Provides
    MapPresenter provideMapPresenter(){
        return  new MapPresenter();
    }
}