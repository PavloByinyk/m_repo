package com.example.gottgried.coderzgeek.custom_slide_to_unlock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.gottgried.coderzgeek.R;

/**
 * Created by Gottgried on 04.02.2018.
 */

public class SliderView extends View {

    private int sliderColor;
    private int sliderBackground;
    private Slider slider;
    private float mDx;
    private boolean inDragMode;
    private SliderListener sliderListener;

    public SliderView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public SliderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SliderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SliderView, defStyleAttr, 0);
        try {
            sliderColor = ta.getColor(R.styleable.SliderView_sliderColor, 0);
            sliderBackground = ta.getColor(R.styleable.SliderView_sliderBackground, 0);
            setBackgroundColor(sliderBackground);
        }catch (Exception e){

        }finally {
            ta.recycle();
        }

        slider = new Slider(0, 0);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        slider.setHeight(getResources().getDimensionPixelOffset(R.dimen.slider_view_heght));
        slider.setWidth(getMeasuredWidth() / 6);

        setMeasuredDimension(getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.slider_view_heght));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if(slider.isSlider((int) event.getX(),(int) event.getY(), 3, 3)){
                    setInDragMode(true);
                }

                mDx = event.getX() - slider.getxSlider();
                break;
            case MotionEvent.ACTION_MOVE:
                slider.setxSlider(event.getX() - mDx);
                if(sliderListener != null){
                    sliderListener.onSlide(slider.getxSlider(), SliderListener.SliderState.CLOSED);
                }
                if(inDragMode) {

                }
                break;
            case MotionEvent.ACTION_UP:

                sliderListener.onSlide(slider.getxSlider(), SliderListener.SliderState.CLOSED);

                //Animation
                if (isHalfWayPassed()) {

                }else {

                }

                setInDragMode(false);
                break;
        }

        return true;
    }

    public void setSliderListener(SliderListener sliderListener) {
        this.sliderListener = sliderListener;
    }

    public void setSliderBackground(int sliderBackground) {
        this.sliderBackground = sliderBackground;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isInEditMode()){
            return;
        }
        slider.drawSlider(canvas);
    }

    public boolean isHalfWayPassed() {
        return false;
    }

    public void setInDragMode(boolean inDragMode) {
        this.inDragMode = inDragMode;
    }

    private class Slider{

        private Paint paintSlider;
        float xSlider, ySlider;
        private int height, width;

        public Slider(float xSlider, float ySlider) {
            this.xSlider = xSlider;
            this.ySlider = ySlider;

            paintSlider = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintSlider.setStyle(Paint.Style.FILL);
            paintSlider.setColor(Color.RED);
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public float getxSlider() {
            return xSlider;
        }

        public void setxSlider(float xSlider) {
            this.xSlider = xSlider;
            invalidate();
        }

        public float getySlider() {
            return ySlider;
        }

        public void setySlider(float ySlider) {
            this.ySlider = ySlider;
            invalidate();
        }

        public void drawSlider(Canvas canvas){
            canvas.drawRect(xSlider, ySlider, width, height, paintSlider);
        }

        public boolean isSlider(int xTop, int yTop, int xBottom, int yBottom){
            Rect rect = new Rect((int) xSlider,(int) ySlider,(int) width,(int) height);
            return rect.intersect(xTop, yTop, xBottom, yBottom);
        }
    }

    public interface SliderListener{

        enum SliderState{
            OPENED,CLOSED
        }

        void onSlide(float progress, SliderState state);
    }
}
