package com.example.sunzh.viewtouchevent.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by sunzh on 2017/12/25.
 *
 * @author sunzh
 */

public class DragView extends View {
    private static final String TAG = DragView.class.getSimpleName();

    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int mLastX;
    private int mLastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int delatY = y - mLastY;
                //方式一：通过改变布局参数来实现动画
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin += deltaX;
                layoutParams.topMargin += delatY;
                setLayoutParams(layoutParams);
                //方式二：通过nineoldandroids库（为了兼容3.0以前没有属性动画，因为在3.0以前没有属性动画，只有view动画）来实现
//                Log.d(TAG, "onTouchEvent: move, deltaX:" + deltaX + " deltaY:" + delatY);
//                int tranX = (int) (ViewHelper.getTranslationX(this) + deltaX);
//                int tranY = (int) (ViewHelper.getTranslationY(this) + delatY);
//                ViewHelper.setTranslationX(this, tranX);
//                ViewHelper.setTranslationY(this, tranY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        mLastY = y;
        mLastX = x;
        return true;
    }
}
