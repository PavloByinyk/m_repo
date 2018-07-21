package com.example.gottgried.rxdagger2_maps.base.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.gottgried.rxdagger2_maps.application.MapApplication;
import com.example.gottgried.rxdagger2_maps.di.application.ApplicationComponent;

import butterknife.ButterKnife;

/**
 * Created by Gottgried on 26.06.2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());
    }


    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
        //To be used by child activities
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    protected void resolveDaggerDependency() {}

    protected void showDialog(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(BaseActivity.this);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MapApplication) getApplication()).getApplicationComponent();
    }

    protected abstract int getContentView();


}
