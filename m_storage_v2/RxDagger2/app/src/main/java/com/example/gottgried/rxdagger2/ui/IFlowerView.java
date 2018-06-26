package com.example.gottgried.rxdagger2.ui;

import com.example.gottgried.rxdagger2.model.FlowerResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by Gottgried on 26.06.2018.
 */

public interface IFlowerView {
    void onComplete();

    void onError(Throwable e);

    void flowers(List<FlowerResponse> floverResponses);

    Observable<List<FlowerResponse>> getFlowers();
}
