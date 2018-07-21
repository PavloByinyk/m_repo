package com.example.gottgried.rxdagger2_maps.modules.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gottgried.rxdagger2_maps.R;
import com.example.gottgried.rxdagger2_maps.base.ui.BaseActivity;
import com.example.gottgried.rxdagger2_maps.di.map.DaggerMapComponent;
import com.example.gottgried.rxdagger2_maps.di.map.MapModule;
import com.example.gottgried.rxdagger2_maps.modules.home.adapter.MapAdapter;
import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MapActivity extends BaseActivity implements IMapContract.IView {


    @Bind(R.id.recyvlerView)
    RecyclerView mRecyclerView;

    private MapAdapter mMapAdapter;

    @Inject
    protected MapPresenter mPresenter;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getMaps();
        }

    @Override
    protected void resolveDaggerDependency() {
        DaggerMapComponent.builder()
        .applicationComponent(getApplicationComponent())
        .mapModule(new MapModule(this))
                .build().inject(this);
    }

    @Override
    public void onMapLoaded(List<Result> maps) {
        mMapAdapter.addPlaces(maps);
    }

    @Override
    public void onShowDialog(String s) {
        showDialog(s);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void initializeList(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mMapAdapter = new MapAdapter(getLayoutInflater());

        mRecyclerView.setAdapter(mMapAdapter);
    }
}
