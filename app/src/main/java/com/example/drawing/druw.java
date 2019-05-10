package com.example.drawing;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class druw extends View {


    Path path = new Path();
    Paint paint = new Paint();
    float Xpos;
    float Ypos;
    ViewGroup.LayoutParams layoutParams;

    public druw(Context context) {
        super(context);

        layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);


        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(9f);


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        Xpos = e.getX();
        Ypos = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(Xpos,Ypos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(Xpos,Ypos);
                break;
                default:
                    return false;
        }
        postInvalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path,paint);
    }
}
