package com.kjdy.mobiledevfinalproject.drawing;

/**
 * Created by yunjo on 4/9/2017.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by yunjo on 4/8/2017.
 */

public class CircleDrawingView extends View {

    private final int paintColor = Color.BLACK;
    private Paint drawPaint;
    private Path path = new Path();

    static float pointX;
    static float pointY;
    static float startX;
    static float startY;
    static float radius;

    public CircleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }




    private void setupPaint() {
// Setup paint with color and stroke styles
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pointX = event.getX();
        pointY = event.getY();
// Checks for the event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = pointX;
                startY = pointY;
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            default:
                return false;
        }
// Force a view to draw again
        postInvalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawCircle(pointX, pointY, (Math.abs(startX - pointX)+ Math.abs(startY - pointY)/1.5f), drawPaint);
        canvas.drawCircle(pointX, pointY, (float) Math.sqrt((Math.pow((pointX - startX), 2.0))+( Math.pow( (pointY - startY), 2.0) ) ), drawPaint);
        radius = (float) Math.sqrt((Math.pow((pointX - startX), 2.0f))+( Math.pow( (pointY - startY), 2.0f) ) );

    }
//    (Math.abs(firstX-x) + Math.abs(firstY-y))/1.5f



    public static String getCircleX() {
        return (pointX - startX)+"";
    }
    public static String getCircleY() {
        return (pointY - startY)+"";
    }
    public static String getRadius(){
        return (radius)+"";
    }
    public static String getCircleMidPoint() {
        return (((pointX - startX)/2)+" , "+((pointY - startY)/2))+"";
    }
    public static String getCircleArea() {
        return ( Math.PI* Math.pow(radius, 2) )+"";
    }
    public static String getCircleCircum() {
        return ((Math.PI* radius) *2)+"";
    }
    public static String getCircleDiameter() {
        return (Math.abs(pointX-startX)*2)+"";
    }

}
