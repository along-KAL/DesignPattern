package com.example.along.bridgepattern;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by along on 2017/7/28.
 */

public class MListView extends ListView {
    public MListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        Log.d("flagg", "ListView onMeasure: ");

    }
}
