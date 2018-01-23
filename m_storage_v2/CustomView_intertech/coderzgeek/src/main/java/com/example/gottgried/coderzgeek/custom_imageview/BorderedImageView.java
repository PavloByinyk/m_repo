package com.example.gottgried.coderzgeek.custom_imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.gottgried.coderzgeek.R;

/**
 * Created by pbyin on 23.01.2018.
 */

public class BorderedImageView extends android.support.v7.widget.AppCompatImageView {

    private static final int STROKE_WIDTH_DP = 6;
    private Paint paintBorder;
    private Bitmap bitmap;
    private int strokeWidthPx;
    private RectF rectF;

    public BorderedImageView(Context context) {
        super(context);
        init();
    }

    public BorderedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BorderedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /** Simple constructor. */
    private void init() {

        // The resource is embedded, but it can be easily moved in the constructor.
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.m_image);


        // The same goes for the stroke width in dp.
        strokeWidthPx = (int) (STROKE_WIDTH_DP * getResources().getDisplayMetrics().density);
//        int halfStrokeWidthPx = strokeWidthPx / 2;

        rectF = new RectF();
        paintBorder = new Paint();
        paintBorder.setStyle(Paint.Style.STROKE);
        // Stroke width is in pixels.
        paintBorder.setStrokeWidth(strokeWidthPx);
        // Our color for the border.
        paintBorder.setColor(Color.BLUE);

//        int totalWidth = bitmap.getWidth() + strokeWidthPx * 2;
//        int totalHeight = bitmap.getHeight()  + strokeWidthPx * 2;
//
//        // An empty bitmap with the same size of our resource to display, increased of the desired border width.
//        setImageBitmap(Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888));
//
//        // The rectangle that will be used for drawing the colored border.
//        rectF = new RectF(halfStrokeWidthPx, halfStrokeWidthPx, totalWidth - halfStrokeWidthPx, totalHeight - halfStrokeWidthPx);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        bitmap = getResizedBitmap(bitmap, canvas.getWidth() - strokeWidthPx * 2, canvas.getHeight() - strokeWidthPx * 2);

        int totalWidth = bitmap.getWidth() + strokeWidthPx * 2;
        int totalHeight = bitmap.getHeight()  + strokeWidthPx * 2;
        int halfStrokeWidthPx = strokeWidthPx / 2;

        // An empty bitmap with the same size of our resource to display, increased of the desired border width.
        setImageBitmap(Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888));

        // The rectangle that will be used for drawing the colored border.
        rectF.set(halfStrokeWidthPx, halfStrokeWidthPx, totalWidth - halfStrokeWidthPx , totalHeight - halfStrokeWidthPx);



        // The bitmap for the resource R.drawable.m_image.
        // Note the Paint for the bitmap is null, we'll talk about this in a moment...
        canvas.drawBitmap(bitmap, strokeWidthPx, strokeWidthPx, null);
        // A rounded rect will be printed.
        canvas.drawRoundRect(rectF, 40, 40, paintBorder);

    }



    private Bitmap getResizedBitmap(Bitmap bitmap, int width, int height) {

        Matrix matrix = new Matrix();

        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dest = new RectF(0, 0, width, height);

        matrix.setRectToRect(src, dest, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

}
