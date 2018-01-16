package com.example.gottgried.clientuser_animation.cunvas_and_views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Gottgried on 16.01.2018.
 */

public class AnimationActivity extends AppCompatActivity{

    private MyLayout myLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myLayout = new MyLayout(this);

        setContentView(myLayout);
    }
}
