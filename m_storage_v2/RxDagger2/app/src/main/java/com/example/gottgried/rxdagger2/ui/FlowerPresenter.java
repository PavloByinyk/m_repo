package com.example.gottgried.rxdagger2.ui;

import com.example.gottgried.rxdagger2.base.mvp.BasePresenter;
import com.example.gottgried.rxdagger2.model.FlowerResponse;

import java.util.List;

import rx.Observer;

/**
 * Created by Gottgried on 26.06.2018.
 */

public class FlowerPresenter extends BasePresenter implements Observer<List<FlowerResponse>> {

    IFlowerView iFlowerView;

    public FlowerPresenter(IFlowerView iFlowerView) {
        this.iFlowerView = iFlowerView;
    }

    @Override
    public void onCompleted() {
        iFlowerView.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        iFlowerView.onError(e);
    }

    @Override
    public void onNext(List<FlowerResponse> floverResponses) {
        iFlowerView.flowers(floverResponses);
    }

    public void fetchFlowers() {
        unSubscribeAll();
        subscribe(iFlowerView.getFlowers(), FlowerPresenter.this);
    }
}
