package com.example.gottgried.coderzgeek.custom_shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.gottgried.coderzgeek.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Gottgried on 14.01.2018.
 */

public class CustomView extends View {

    private static final int SQUER_SIZE_DEFAULT = 100;

    private Rect mRectSqusr;
    private Paint mPaintSquare;


    private Paint mPaintCircle;
    private float mCircleX, mCircleY;
    private float mCircleRadius = 100f;


    private int squareColor;
    private int squareSize;

    private Bitmap bitmap;


    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }


    public void init(@Nullable AttributeSet attrs){
        mRectSqusr = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);


        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.BLUE);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.m_image);


        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int padding = 50;

                bitmap = getResizedBitmap(bitmap, getWidth() - padding, getHeight() - padding);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        int newWidth = bitmap.getWidth() - 50;
                        int newHeight = bitmap.getHeight() - 50;

                        if(newHeight <=0 || newWidth <= 0){
                            cancel();
                            return;
                        }

                        bitmap = getResizedBitmap(bitmap, newWidth, newHeight);
                        postInvalidate();
                    }
                }, 2000, 500);
            }
        });

        if(attrs == null){
            return;
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomView);
        squareColor = typedArray.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        squareSize = typedArray.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUER_SIZE_DEFAULT);

        mPaintSquare.setColor(squareColor);

        typedArray.recycle();
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int width, int height) {

        Matrix matrix = new Matrix();

        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dest = new RectF(0, 0, width, height);

        matrix.setRectToRect(src, dest, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(Color.RED);

        //draw rectangle
        mRectSqusr.top = 10;
        mRectSqusr.left = 10;
        mRectSqusr.right = mRectSqusr.left + squareSize;
        mRectSqusr.bottom = mRectSqusr.top + squareSize;

        canvas.drawRect(mRectSqusr, mPaintSquare);


        //draw circle
//        float cx, cy;
//        float radius = 100f;
//        cx = getWidth() - radius - 50f;
//        cy = mRectSqusr.top + (mRectSqusr.height() / 2) ;

        if(mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth() / 2;
            mCircleY = getHeight() / 2;
        }

        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mPaintCircle);

        canvas.drawBitmap(bitmap, 0, 0, null);

    }

    public void swapColor() {
        mPaintSquare.setColor(mPaintSquare.getColor() == Color.GREEN ? Color.RED : squareColor);
        postInvalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean mEvent =  super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                float xx = event.getX();
                float yx = event.getY();

                if (mRectSqusr.left < xx && mRectSqusr.right > xx) {
                    if (mRectSqusr.top < yx && mRectSqusr.bottom > yx) {
                        mCircleRadius += 10f;
                        postInvalidate();
                    }
                }

                return true;
            }

            case MotionEvent.ACTION_MOVE: {

                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if (dx + dy < Math.pow(mCircleRadius, 2)) {
                    //the circle was touched
                    mCircleX = x;
                    mCircleY = y;
                    postInvalidate();

                    return true;

                }
                return mEvent;
            }
        }

        return mEvent;
    }
}
