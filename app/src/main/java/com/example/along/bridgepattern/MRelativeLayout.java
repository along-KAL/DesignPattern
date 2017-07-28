package com.example.along.bridgepattern;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by along on 2017/7/28.
 */

public class MRelativeLayout extends RelativeLayout {
    public MRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //Log.d("flagg", "LinearLayout -----  onMeasure: ");

    }
}
