package com.inerdstack.mzcj.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.inerdstack.mzcj.R;

/**
 * 项目名称：mzcj
 * 模块名称：全局
 * 包名：com.inerdstack.mzcj.view
 * 类功能：自定义控件，标题栏
 * 创建人：inerdstack
 * 创建时间：2016 16/10/17 下午11:42
 * 联系邮箱: wjnovember@icloud.com
 */
public class TitleBar extends LinearLayout {

    // 默认返回按钮状态:不激活
    private static final boolean DEFAULT_BACK_BTN_ENABLED = false;
    // 默认返回按钮颜色：#ffffffff
    private static final int DEFAULT_BACK_BTN_COLOR = 0xffffffff;
    // 默认分割线状态
    private static final boolean DEFAULT_DIVIDER_ENABLED = false;
    // 默认分割线颜色
    private static final int DEFAULT_DIVIDER_COLOR = 0xffb6b6b6;
    // 默认字体大小：12sp
    private static final float DEFAULT_TEXT_SIZE = 12;
    // 默认字体颜色：#ff212121
    private static final int DEFAULT_TEXT_COLOR = 0xff212121;
    // 默认图标尺寸: 15dp
    private static final float DEFAULT_DRAWABLE_SIZE = 15;
    // 默认左侧图标点击状态：不可点击
    private static final boolean DEFAULT_DRAWABLE_LEFT_CLICKABLE = false;
    // 默认右侧图标点击状态：不可点击
    private static final boolean DEFAULT_DRAWABLE_RIGHT_CLICKABLE = false;
    // 默认图标间距：20dp
    private static final float DEFAULT_DRAWABLE_SPACING = 20;

    // 返回按钮状态
    private boolean mBackBtnEnabled;
    // 返回按钮颜色
    private int mBackBtnColor;
    // 分割线状态
    private boolean mDividerEnabled;
    // 分割线颜色
    private boolean mDividerColor;
    // 标题字体大小
    private float mTitleTextSize;
    // 标题字体颜色
    private float mTitleTextColor;
    // 图标尺寸
    private float mDrawableDimen;
    // 左侧图标点击状态
    private float mDrawableLeftClickable;
    // 右侧图标点击状态
    private float mDrawableRightClickable;
    // 图标间距
    private float mDrawableSpacing;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        // -获取属性
//        TypedArray ta = context.obtainStyledAttributes(R.styleable.TitleBar);
//        mBackBtnEnabled = ta.getBoolean(R.styleable.TitleBar_enableBackBtn, DEFAULT_BACK_BTN_ENABLED);
//        mBackBtnColor = ta.getInt(R.styleable.TitleBar_backBtnColor, DEFAULT_BACK_BTN_COLOR);
//        mDividerEnabled = ta.getBoolean(R.styleable.TitleBar_enableDivider, DEFAULT_DIVIDER_ENABLED);
    }
}
