package com.example.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private static final int SQUARE=500;
    Rect rect;
    Paint paint;

    int squareColor;
    int squareSize;
    Paint paintCircle;
    float circleX,circleY,circleRadius=100f;

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }
    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public void init(@Nullable AttributeSet set){
        rect=new Rect();
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle=new Paint();

        paintCircle.setColor(Color.BLUE);

        if(set==null){
            return;
        }
        TypedArray ta=getContext().obtainStyledAttributes(set,R.styleable.CustomView);

        squareColor=ta.getColor(R.styleable.CustomView_box_color,Color.GREEN);
        squareSize=ta.getDimensionPixelSize(R.styleable.CustomView_box_size,SQUARE);

        paint.setColor(squareColor);

        ta.recycle();
    }

    public void swapColor(){
        if(paint.getColor()==squareColor){
            paint.setColor(Color.RED);
        }
        else if(paint.getColor()==squareColor){
            paint.setColor(Color.GREEN);
        }

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawColor(Color.RED);

        rect.left=10;
        rect.top=10;
        rect.right=rect.left+squareSize;
        rect.bottom=rect.top+squareSize;




        canvas.drawRect(rect,paint);
/*
        float cx,cy;
        float radius=100f;

        cx=getWidth()-radius-50f;
        cy=rect.top+(rect.height()/2);

 */
        if(circleX==0f || circleY==0f){
            circleX=getWidth()/2;
            circleY=getHeight()/2;
        }

        canvas.drawCircle(circleX,circleY,circleRadius,paintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value= super.onTouchEvent(event);

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                float x=event.getX();
                float y=event.getY();

                if(rect.left<x && rect.right>x){
                    if(rect.top<y && rect.bottom>y){
                        circleRadius+=10f;
                        postInvalidate();
                    }
                }

                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                float x=event.getX();
                float y=event.getY();

                double dx=Math.pow(x-circleX,2);
                double dy=Math.pow(y-circleY,2);

                if(dx+dy<Math.pow(circleRadius,2)){
                    circleX=x;
                    circleY=y;

                    postInvalidate();

                    return true;
                }
            }
        }

        return value;
    }
}
