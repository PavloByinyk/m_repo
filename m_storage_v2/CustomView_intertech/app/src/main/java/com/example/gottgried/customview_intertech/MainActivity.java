package com.example.gottgried.customview_intertech;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.gottgried.clientuser_animation.cunvas_and_views.AnimationActivity;
import com.example.gottgried.clientuser_animation.cunvas_and_views.AnimationActivity2;
import com.example.gottgried.coderzgeek.custom_shapes.ShapesActivity;
import com.example.gottgried.customview_intertech.custom_counter.CounterActivity;
import com.example.gottgried.customview_intertech.custom_progresbar.ProgresBarActivity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawButtons(initActivitiesList());

    }

    private void drawButtons(List<Class<? extends Activity>> listActivities){

        Random rnd = new Random();

        LinearLayout llContainew = (LinearLayout) findViewById(R.id.ll_btns_container);

        for (Class clazz : listActivities) {
            Button newBtn = new Button(this);
            newBtn.setText(clazz.getSimpleName());
            newBtn.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            newBtn.setHint(clazz.getName());
            Log.d("btn_log", clazz.getName());
            newBtn.setOnClickListener(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llContainew.addView(newBtn, params);
        }


    }


    private List<Class<? extends Activity>> initActivitiesList(){
        List<Class<? extends Activity>> listActivity = new LinkedList<>();

        listActivity.add(CounterActivity.class);
        listActivity.add(ProgresBarActivity.class);
        listActivity.add(ShapesActivity.class);
        listActivity.add(AnimationActivity.class);
        listActivity.add(AnimationActivity2.class);

        return listActivity;
    }

    private void startNextActivity(String activityName){
        try {
            startActivity(new Intent(MainActivity.this,  Class.forName(activityName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Button){
            Log.d("btn_log", ((Button) view).getHint().toString());
            startNextActivity(((Button) view).getHint().toString());
        }

    }
}
