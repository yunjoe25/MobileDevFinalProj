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

    float pointX;
    float pointY;
    float startX;
    float startY;
    float radius = 500;

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
        canvas.drawCircle(pointX, pointY, (Math.abs(startX - pointX)+ Math.abs(startY - pointY)/1.5f), drawPaint);
    }
//    (Math.abs(firstX-x) + Math.abs(firstY-y))/1.5f
}
