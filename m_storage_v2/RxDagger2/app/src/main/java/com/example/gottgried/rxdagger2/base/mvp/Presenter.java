package com.example.gottgried.rxdagger2.base.mvp;

/**
 * Created by Gottgried on 17.06.2018.
 */

public interface Presenter {

    void onCreate();
    void onResume();
    void onPause();
    void onDestroy();
}
