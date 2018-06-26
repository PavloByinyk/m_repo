package com.example.gottgried.rxdagger2.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gottgried.rxdagger2.R;
import com.example.gottgried.rxdagger2.adapter.FlowerAdapter;
import com.example.gottgried.rxdagger2.application.FlowerApplication;
import com.example.gottgried.rxdagger2.model.FlowerResponse;
import com.example.gottgried.rxdagger2.service.FlowerService;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

public class FlowerActivity extends AppCompatActivity implements IFlowerView, FlowerAdapter.FlowerClickListener {

    @Inject
    FlowerService flowerService;

    private FlowerPresenter flowerPresenter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private FlowerAdapter mAdapter;

    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((FlowerApplication) getApplication())
                .getApiComponent()
                .inject(FlowerActivity.this);

        ButterKnife.bind(FlowerActivity.this);

        configViews();


        flowerPresenter = new FlowerPresenter(this);
        flowerPresenter.onCreate();


    }

    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(this, getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        flowerPresenter.onResume();
        flowerPresenter.fetchFlowers();


        mDialog = new ProgressDialog(this);
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading List");
        mDialog.setMessage("Please wait...");
        mDialog.show();
    }

    @Override
    public void onComplete() {
        mDialog.dismiss();
    }

    @Override
    public void onError(Throwable e) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void flowers(List<FlowerResponse> floverResponses) {
        mAdapter.addFlowers(floverResponses);
    }

    @Override
    public Observable<List<FlowerResponse>> getFlowers() {
        return flowerService.getFlowers();
    }

    @Override
    public void onClick(int position, String name) {
        Toast.makeText(getApplicationContext(), "You clicked on " + name, Toast.LENGTH_SHORT).show();
    }
}
