package com.example.gottgried.rxdagger2.base.mvp;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Gottgried on 17.06.2018.
 */

public abstract class BasePresenter implements Presenter{

    private CompositeSubscription compositeSubscription;


    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        configureSubscription();
    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected CompositeSubscription configureSubscription(){
        if(compositeSubscription == null || compositeSubscription.isUnsubscribed()){
            compositeSubscription = new CompositeSubscription();
        }
        return compositeSubscription;
    }

    protected void unSubscribeAll() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
//            mCompositeSubscription = null;
        }
    }

    protected <F> void subscribe(Observable<F> observable, Observer<F> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscription().add(subscription);
    }
}
