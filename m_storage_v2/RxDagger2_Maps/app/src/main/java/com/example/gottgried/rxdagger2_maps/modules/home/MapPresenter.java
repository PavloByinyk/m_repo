package com.example.gottgried.rxdagger2_maps.modules.home;

import com.example.gottgried.rxdagger2_maps.api.MapApiService;
import com.example.gottgried.rxdagger2_maps.base.mvp.BasePresenter;
import com.example.gottgried.rxdagger2_maps.base.mvp.IBaseView;
import com.example.gottgried.rxdagger2_maps.mapper.MapsMapper;
import com.example.gottgried.rxdagger2_maps.pojo.MapsResponse;
import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * Created by Gottgried on 26.06.2018.
 */

public class MapPresenter extends BasePresenter<IMapContract.IView> implements Observer<MapsResponse> {

    @Inject
    MapApiService mapApiService;

    @Inject
    MapsMapper mapsMapper;

    public MapPresenter() {
    }


    public void getMaps() {
        Observable<MapsResponse> mapsResponseObservable = mapApiService.getMaps();
        subscribe(mapsResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getmView().onHideDialog();
    }

    @Override
    public void onError(Throwable e) {
        getmView().onHideDialog();
        getmView().onShowToast("Error");
    }

    @Override
    public void onNext(MapsResponse mapsResponse) {
        getmView().onShowDialog("Downloading in progress");
        List<Result> maps = mapsMapper.mapMaps(mapsResponse);
        getmView().onMapLoaded(maps);
    }
}
