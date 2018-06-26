package com.example.gottgried.rxdagger2_maps.base.mvp;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Gottgried on 26.06.2018.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    @Inject protected V mView;

    protected V getmView(){
        return mView;
    }


    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
