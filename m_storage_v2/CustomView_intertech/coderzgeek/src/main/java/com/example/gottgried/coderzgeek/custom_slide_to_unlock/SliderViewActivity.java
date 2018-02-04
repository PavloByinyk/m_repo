package com.example.gottgried.coderzgeek.custom_slide_to_unlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gottgried.coderzgeek.R;

public class SliderViewActivity extends AppCompatActivity {

    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_view);

        sliderView = findViewById(R.id.slider_view);
        sliderView.setSliderListener(new SliderView.SliderListener() {
            @Override
            public void onSlide(float progress, SliderState state) {
                Toast.makeText(SliderViewActivity.this, state.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
