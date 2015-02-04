package com.r0adkll.slidr.example;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/**
 * 热词UI 可以根据孩子的宽度自适应排版, 主要不支持任何padding
 */
public class HotWordsView extends ViewGroup{
    private int mMaxRows = 50;
    private int mWordsPadding = 10;
    private int mWordsPaddingTop = 10;
    private int mChildViewHeigh = 50; //默认高度

    public HotWordsView(Context context, AttributeSet attrs , int defStyle) {
        super(context, attrs, defStyle);
    }
    public HotWordsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public HotWordsView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int childCount = getChildCount();

        if (childCount == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int realRows = 1;
        int x = 0; // 计算是否超出viewgroup的宽度

        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            //热词的最大长度是 width - wordsPadding.
            view.measure(MeasureSpec.makeMeasureSpec(width - mWordsPadding, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            x += view.getMeasuredWidth() + mWordsPadding;
            if (x > width) {//如果热词排满了就添加一行, 那么现在x的坐标是width+padding
                realRows ++;
                x = view.getMeasuredWidth() + mWordsPadding;
            }
        }

        mChildViewHeigh = getChildAt(0).getMeasuredHeight();

        int realHeight = mChildViewHeigh * realRows + mWordsPaddingTop * (realRows -1);

        if (realHeight > height) {
            realHeight = height;
        }
         setMeasuredDimension(width, realHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getWidth();

        int childCount = getChildCount();
        int currentX = 0; //布局孩子时 , 其 右边位置

        int x = 0; //view 的左边位置
        int y = 0; //view y方向的起始位置
        int realRow = 1;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() != View.GONE) {
                int viewWidth = view.getMeasuredWidth();
                x = currentX;                
                currentX += viewWidth + mWordsPadding;               
                //如果热词排满了就添加一行, 继续排版 
                if (currentX > width) {
                    currentX =  view.getMeasuredWidth() + mWordsPadding;
                    x =  0;                    
                    y = y + mChildViewHeigh + mWordsPaddingTop;
                    realRow ++;
                    if (realRow > mMaxRows) {
                        break;
                    }
                }

                view.layout( x, y, currentX - mWordsPadding, y + mChildViewHeigh );
            }
        }
    }
}