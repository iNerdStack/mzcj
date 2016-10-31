package com.inerdstack.mzcj.global.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.inerdstack.mzcj.R;

/**
 * Created by wangjie on 2016/10/31.
 */
public class ScaleRelativeLayout extends RelativeLayout {

    /*
    用于宽度或高度固定的标记，若宽度固定，则高度以宽度为标准，与宽度保持一致；
    若高度固定，则宽度以高度为标准，和高度保持一致
     */
    // 宽度固定
    private static final int WIDTH_SOLID = -1;
    // 高度固定
    private static final int HEIGHT_SOLID = -2;

    // 无比例标记
    private static final float NO_SCALE = -999f;

    // 默认宽度固定
    private int mSolidFlag = WIDTH_SOLID;

    private float mScale = NO_SCALE;

    public ScaleRelativeLayout(Context context) {
        this(context, null);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyScaleView);
        mSolidFlag = ta.getInt(R.styleable.MyScaleView_solid, WIDTH_SOLID);
        mScale = ta.getFloat(R.styleable.MyScaleView_scale, NO_SCALE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 如果无比例，则不做任何操作
        if (mScale == NO_SCALE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        // 宽度
        int width = MeasureSpec.getSize(widthMeasureSpec);
        // 高度
        int height = MeasureSpec.getSize(heightMeasureSpec);

        // 如果宽度固定
        if (mSolidFlag == HEIGHT_SOLID) {
                width = (int) (height / mScale);
        } else if (mSolidFlag == WIDTH_SOLID) { // 如果高度固定
                height = (int) (width * mScale);
        }
        // 将计算出的宽度和高度设置为图片显示的大小
        setMeasuredDimension(width, height);
    }
}
