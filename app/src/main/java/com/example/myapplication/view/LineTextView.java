package com.example.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class LineTextView extends TextView {

    //定义画笔，用来绘制中心曲线
    private Paint mPaint;

    /**
     * 创建构造方法
     * @param context
     */
    public LineTextView(Context context) {
        super(context);
        init();
    }

    public LineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    //重写draw方法，绘制我们需要的中间线以及背景
    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        mPaint.setColor(Color.BLUE);
        //绘制方形背景
        RectF rectF = new RectF(0,0,width,height);
        canvas.drawRect(rectF,mPaint);
        mPaint.setColor(Color.BLACK);
        //绘制中心曲线，起点坐标（0,height/2），终点坐标（width,height/2）
        mPaint.setStrokeWidth(5);
        canvas.drawLine(0,height/2,width,height/2,mPaint);

        super.onDraw(canvas);
    }
}
