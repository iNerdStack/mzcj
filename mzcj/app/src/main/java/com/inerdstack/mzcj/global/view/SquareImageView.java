package com.inerdstack.mzcj.global.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.inerdstack.mzcj.R;

/**
 * Created by wangjie on 2016/10/31.
 */
public class SquareImageView extends ImageView {

    /*
    用于宽度或高度固定的标记，若宽度固定，则高度以宽度为标准，与宽度保持一致；
    若高度固定，则宽度以高度为标准，和高度保持一致
     */
    // 宽度固定
    private static final int WIDTH_SOLID = -1;
    // 高度固定
    private static final int HEIGHT_SOLID = -2;

    // 默认宽度固定
    private int mSolidFlag = WIDTH_SOLID;

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyImageView);
        mSolidFlag = ta.getInt(R.styleable.MyImageView_solid, WIDTH_SOLID);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (getDrawable() == null) {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//            return;
//        }

        // 宽度
        int width = MeasureSpec.getSize(widthMeasureSpec);
        // 高度
        int height = MeasureSpec.getSize(heightMeasureSpec);
        // 如果宽度固定
        if (mSolidFlag == WIDTH_SOLID) {
            width = height;
        } else if (mSolidFlag == HEIGHT_SOLID) { // 如果高度固定
            height = width;
        }
        // 将计算出的宽度和高度设置为图片显示的大小
        setMeasuredDimension(width, height);
    }
}
