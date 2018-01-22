package com.example.gottgried.clientuser_animation.cunvas_and_views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pbyin on 22.01.2018.
 */

public class AnimationActivity2  extends AppCompatActivity{

    MyLayout2 myLayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myLayout2 = new MyLayout2(this);

        setContentView(myLayout2);
    }


    @Override
    protected void onResume() {
        super.onResume();
        myLayout2.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        myLayout2.pause();
    }
}
