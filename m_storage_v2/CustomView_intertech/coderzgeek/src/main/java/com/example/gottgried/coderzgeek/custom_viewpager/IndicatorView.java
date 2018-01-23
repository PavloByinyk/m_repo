package com.example.gottgried.coderzgeek.custom_viewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pbyin on 23.01.2018.
 */

public class IndicatorView  extends View{

    public IndicatorView(Context context) {
        super(context);
        initializeParameters(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeParameters(context, attrs);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeParameters(context, attrs);
    }

    private void initializeParameters(Context context, AttributeSet attributes) {
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }

    static float dpOrSpToPx(final Context context, final float dpOrSpValue) {
        return dpOrSpValue * context.getResources().getDisplayMetrics().density;
    }
}
