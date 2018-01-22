package com.example.gottgried.clientuser_animation.cunvas_and_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.gottgried.clientuser_animation.R;

/**
 * Created by pbyin on 22.01.2018.
 */

public class MyLayout2 extends SurfaceView implements Runnable{

    Thread thread = null;
    boolean canDraw = false;

    Paint red_paitbrush_fill, blue_paitbrush_fill, green_paitbrush_fill;
    Paint red_paitbrush_stroke, blue_paitbrush_stroke, green_paitbrush_stroke;

    Path path_square;

    Bitmap image_move;
    int image_move_x, image_move_y;

    int circle_x, circle_y;



    Bitmap backGroundCheck;
    Canvas canvas;
    SurfaceHolder surfaceHolder;

    public MyLayout2(Context context) {
        super(context);

        surfaceHolder = getHolder();
        backGroundCheck = BitmapFactory.decodeResource(getResources(), R.drawable.m_image);
        image_move = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_bus);
        image_move_x = 650;
        image_move_y = 130;

        circle_x = 130;
        circle_y = 130;
    }

    @Override
    public void run() {

        prepPaintBrushes();

        while (canDraw){
            //do drawing
            if(!surfaceHolder.getSurface().isValid()){
                continue;
            }

            canvas = surfaceHolder.lockCanvas();
            motionImageBus(10);
            motionCircle(10);
            canvas.drawBitmap(backGroundCheck, 0,0, null);
            drawSquare(130, 130, 650, 650);
            canvas.drawBitmap(image_move, image_move_x - (image_move.getWidth()/2), image_move_y - (image_move.getHeight()/2), null);
            canvas.drawCircle(circle_x, circle_y, 50, green_paitbrush_fill);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    //TODO method for getting pixels
    private int toPxs(int dps){
        return (int) (dps * getResources().getDisplayMetrics().density);
    }



    private void drawSquare(int x1, int y1, int x2, int y2) {

        path_square = new Path();
        path_square.moveTo(x1, y1);
        path_square.lineTo(x2, y1);
        path_square.lineTo(x2, y2);
        path_square.lineTo(x1, y2);
        path_square.lineTo(x1, y1);

        this.canvas.drawPath(path_square, green_paitbrush_stroke);
    }


    public void resume(){
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause(){
        canDraw = false;

        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread = null;
    }

    private void prepPaintBrushes(){
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
    }

    private void motionImageBus(int speed){

        if( (image_move_y == 130) && (image_move_x < 650)){
            image_move_x = image_move_x + speed;
        }

        if( (image_move_y < 650) && (image_move_x == 650)){
            image_move_y = image_move_y + speed;
        }

        if( (image_move_y == 650) && (image_move_x > 130)){
            image_move_x = image_move_x - speed;
        }

        if( (image_move_y > 130) && (image_move_x == 130)){
            image_move_y = image_move_y - speed;
        }
    }

    private void motionCircle(int speed) {
        if( (circle_y == 130) && (circle_x < 650)){
            circle_x = circle_x + speed;
        }

        if( (circle_y < 650) && (circle_x == 650)){
            circle_y = circle_y + speed;
        }

        if( (circle_y == 650) && (circle_x > 130)){
            circle_x = circle_x - speed;
        }

        if( (circle_y > 130) && (circle_x == 130)){
            circle_y = circle_y - speed;
        }
    }

}
