package com.cat.oschina.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.cat.oschina.R;

public class ScollerContainer extends ViewGroup {

    private Scroller scroller;
    private float XDown;
    private float XMove;
    private float XLastMove;
    private int leftBorder;
    private int rightBorder;
    private int touchSlop;


    public ScollerContainer(Context context) {
        super(context);
        init();
    }

    public ScollerContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScollerContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        scroller = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        touchSlop = viewConfiguration.getScaledTouchSlop();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        float diff = 0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                XDown = event.getRawX();
                XLastMove = XDown;
                break;
            case MotionEvent.ACTION_MOVE:
                XMove = event.getRawX();
                diff = Math.abs(XMove-XDown);
                XLastMove = XMove;
                if (diff>touchSlop){
                    return true;
                }
                break;
        }

        return super.onInterceptHoverEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float scrollerX ;
        float diff;
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                scrollerX = getScrollX();
                XMove = event.getRawX();
                diff = XLastMove-XMove;
                if (scrollerX+diff<leftBorder){
                    scrollTo(leftBorder,0);
                    return true;
                }else if (scrollerX+diff+getWidth()>rightBorder){
                    scrollTo(rightBorder -getWidth(),0);
                    return true;
                }

                scrollBy((int) diff,0);
                XLastMove = XMove;
                break;
            case MotionEvent.ACTION_UP:

                // 当手指抬起时，根据当前的滚动值来判定应该滚动到哪个子控件的界面
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                int dx = targetIndex * getWidth() - getScrollX();
                // 第二步，调用startScroll()方法来初始化滚动数据并刷新界面
                Log.d("moveX:","scrollX="+getScrollX()+"  dx="+dx);
                scroller.startScroll(getScrollX(), 0, dx, 0);
                invalidate();

                break;
        }


        return super.onTouchEvent(event);
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(scroller.getCurrX(),scroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        View child=null;
        for (int i=0;i<count;i++){
            child = getChildAt(i);
            child.measure(widthMeasureSpec,heightMeasureSpec);
        }

    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int count = getChildCount();
        View child = null;
        for (int i=0;i<count;i++){
            child = getChildAt(i);
            child.layout(child.getMeasuredWidth()*i,0,child.getMeasuredWidth()*(i+1),child.getMeasuredHeight());
        }

        leftBorder = getChildAt(0).getLeft();
        rightBorder = getChildAt(count-1).getRight();
    }
}
