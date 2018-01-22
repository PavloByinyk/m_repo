package com.example.gottgried.clientuser_animation.cunvas_and_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

import com.example.gottgried.clientuser_animation.R;

/**
 * Created by Gottgried on 16.01.2018.
 */

public class MyLayout extends View {

    Paint red_paitbrush_fill, blue_paitbrush_fill, green_paitbrush_fill;
    Paint red_paitbrush_stroke, blue_paitbrush_stroke, green_paitbrush_stroke;

    Path path_triangle;

    Bitmap image_bm;
    int image_x, image_y;
    int move__x_image, move_y_image;

    public MyLayout(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);

        image_x = 320;
        image_y = 470;

        move__x_image = 3;
        move_y_image = 3;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        red_paitbrush_fill = new Paint();
        red_paitbrush_fill.setColor(Color.RED);
        red_paitbrush_fill.setStyle(Paint.Style.FILL);

        blue_paitbrush_fill = new Paint();
        blue_paitbrush_fill.setColor(Color.BLUE);
        blue_paitbrush_fill.setStyle(Paint.Style.FILL);

        green_paitbrush_fill = new Paint();
        green_paitbrush_fill.setColor(Color.GREEN);
        green_paitbrush_fill.setStyle(Paint.Style.FILL);

        red_paitbrush_stroke = new Paint();
        red_paitbrush_stroke.setColor(Color.RED);
        red_paitbrush_stroke.setStyle(Paint.Style.STROKE);
        red_paitbrush_stroke.setStrokeWidth(10);

        blue_paitbrush_stroke = new Paint();
        blue_paitbrush_stroke.setColor(Color.BLUE);
        blue_paitbrush_stroke.setStyle(Paint.Style.STROKE);
        blue_paitbrush_stroke.setStrokeWidth(10);

        green_paitbrush_stroke = new Paint();
        green_paitbrush_stroke.setColor(Color.GREEN);
        green_paitbrush_stroke.setStyle(Paint.Style.STROKE);
        green_paitbrush_stroke.setStrokeWidth(10);


        Rect rect1 = new Rect();
        rect1.set(210, 125,250, 175);
        canvas.drawRect(rect1, green_paitbrush_stroke);

        Rect rect2 = new Rect();
        rect2.set(420, 125,460, 175);
        canvas.drawRect(rect1, red_paitbrush_fill);

        canvas.drawCircle(400, 400, 70, blue_paitbrush_stroke);
        canvas.drawCircle(400, 400, 20, green_paitbrush_fill);
        canvas.drawCircle(400, 400, 10, red_paitbrush_fill);


        path_triangle = new Path();
        path_triangle.moveTo(400, 400);
        path_triangle.lineTo(600, 600);
        //path_triangle.moveTo(600,600);
        path_triangle.lineTo(200,600);
        //path_triangle.moveTo(200,600);
        //path_triangle.lineTo(400,400);
        path_triangle.close();
        canvas.drawPath(path_triangle, red_paitbrush_stroke);

        image_bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_bus);

        if(image_x  >= canvas.getWidth() - image_bm.getWidth()){
            move__x_image = -3;
        }

        if(image_x <= 0){
            move__x_image = 3;
        }

        if(image_y >= canvas.getHeight() - image_bm.getHeight()){
            move_y_image = -3;
        }

        if(image_y <= 0){
            move_y_image = 3;
        }

        image_x = image_x + move__x_image;
        image_y = image_y + move_y_image;

        canvas.drawBitmap(image_bm, image_x, image_y, null);

        postInvalidate();
    }
}
