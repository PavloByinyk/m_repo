package com.example.gottgried.coderzgeek.custom_imageview_animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.gottgried.coderzgeek.R;

/**
 * Created by pbyin on 23.01.2018.
 * https://pspdfkit.com/blog/2017/50-shaders-of-android-drawing-on-canvas/
 */

public class AnimationImageView extends android.support.v7.widget.AppCompatImageView{

    // Initial position.
    private int rotationDegrees = 0;

    private float scale;
    private int directionScale;


    public AnimationImageView(Context context) {
        super(context);
        init();
    }

    public AnimationImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimationImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.m_image);
        setImageBitmap(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Translate rotation axe to the center.
        canvas.translate(canvas.getWidth()/2, canvas.getHeight()/2);
        // Rotate!
        canvas.rotate(rotation(1));

        float scaleFactor = scale(0.01f);
        canvas.scale(scaleFactor, scaleFactor);

        // Put back to its original place.
        canvas.translate(-canvas.getWidth()/2, -canvas.getHeight()/2);



        // Invalidate the view.
        postInvalidateOnAnimation();
        super.onDraw(canvas);
    }

    private int rotation(int delta) {
        rotationDegrees = (rotationDegrees + delta) % 360;
        return rotationDegrees;
    }

    private float scale(float delta) {
        scale = (scale + delta * directionScale);
        if (scale <= 0) {
            directionScale = 1;
            scale = 0;
        } else if (scale >= 1) {
            directionScale = -1;
            scale = 1;
        }
        return scale;
    }

}
