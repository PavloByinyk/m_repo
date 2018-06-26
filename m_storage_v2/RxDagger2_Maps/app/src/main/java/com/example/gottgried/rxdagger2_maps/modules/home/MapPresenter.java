package com.example.gottgried.rxdagger2_maps.modules.home;

import com.example.gottgried.rxdagger2_maps.base.mvp.BasePresenter;
import com.example.gottgried.rxdagger2_maps.base.mvp.IBaseView;

import javax.inject.Inject;

/**
 * Created by Gottgried on 26.06.2018.
 */

public class MapPresenter extends BasePresenter<IMapContract.IView> {

    @Inject
    public MapPresenter() {
    }

    public void getMaps() {
    }
}
