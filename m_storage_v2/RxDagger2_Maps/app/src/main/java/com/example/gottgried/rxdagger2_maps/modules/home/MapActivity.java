package com.example.gottgried.rxdagger2_maps.modules.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gottgried.rxdagger2_maps.R;
import com.example.gottgried.rxdagger2_maps.base.ui.BaseActivity;
import com.example.gottgried.rxdagger2_maps.di.map.MapComponent;

import javax.inject.Inject;

public class MapActivity extends BaseActivity implements IMapContract.IView {

    @Inject protected MapPresenter mPresenter;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        mPresenter.getMaps();
        }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMapComponent.builder().build();
    }
}
