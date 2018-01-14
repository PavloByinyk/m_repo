package com.example.gottgried.coderzgeek.custom_shapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gottgried.coderzgeek.R;

public class ShapesActivity extends AppCompatActivity {

    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        customView = (CustomView) findViewById(R.id.m_custom_view);

        findViewById(R.id.btn_change_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.swapColor();
            }
        });
    }
}
