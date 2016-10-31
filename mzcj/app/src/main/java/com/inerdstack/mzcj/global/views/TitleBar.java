package com.inerdstack.mzcj.global.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inerdstack.mzcj.R;
import com.inerdstack.mzcj.global.utils.AppLog;
import com.inerdstack.mzcj.global.utils.Constants;

/**
 * 项目名称：mzcj
 * 模块名称：全局
 * 包名：com.inerdstack.mzcj.view
 * 类功能：自定义控件，标题栏
 * 创建人：inerdstack
 * 创建时间：2016 16/10/17 下午11:42
 * 联系邮箱: wjnovember@icloud.com
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    // 默认返回按钮状态:不激活
    private static final boolean DEFAULT_BACK_BTN_ENABLED = false;
    // 默认返回按钮颜色：#ffffffff
    private static final int DEFAULT_BACK_BTN_COLOR = 0xffffffff;
    // 默认分割线状态
    private static final boolean DEFAULT_DIVIDER_ENABLED = false;
    // 默认分割线颜色
    private static final int DEFAULT_DIVIDER_COLOR = 0xffb6b6b6;
    // 默认标题内容
    private static final String DEFAULT_TITLE_TEXT = "hehe";
    // 默认字体大小：12sp
    private static final float DEFAULT_TEXT_SIZE = 16;
    // 默认字体颜色：#ff212121
    private static final int DEFAULT_TEXT_COLOR = 0xff212121;
    // 默认图标尺寸: 15dp
    private static final float DEFAULT_DRAWABLE_DIMEN = 15;
    // 默认左侧图标点击状态：不可点击
    private static final boolean DEFAULT_DRAWABLE_LEFT_CLICKABLE = false;
    // 默认右侧图标点击状态：不可点击
    private static final boolean DEFAULT_DRAWABLE_RIGHT_CLICKABLE = false;
    // 默认图标间距：20dp
    private static final float DEFAULT_DRAWABLE_SPACING = 20;
    // 无资源
    private static final int SRC_NULL = -999;

    // 返回按钮状态
    private boolean mBackBtnEnabled;
    // 返回按钮颜色
    private int mBackBtnColor;
    // 分割线状态
    private boolean mDividerEnabled;
    // 分割线颜色
    private int mDividerColor;
    // 标题文本
    private String mTitleText = DEFAULT_TITLE_TEXT;
    // 标题字体大小
    private float mTitleTextSize;
    // 标题字体颜色
    private int mTitleTextColor;
    // 图标尺寸
    private float mDrawableDimen;
    // 左侧图标资源
    private int mDrawableLeftSrc;
    // 左侧图标点击状态
    private boolean mDrawableLeftClickable;
    // 右侧图标资源
    private int mDrawableRightSrc;
    // 右侧图标点击状态
    private boolean mDrawableRightClickable;
    // 图标间距
    private float mDrawableSpacing;

    // -控件声明
    // 标题控件
    private TextView mTvTitle;
    // 返回按钮
    private ImageView mImgBack;
    // 左侧图标
    private ImageView mImgLeftIcon;
    // 右侧图标
    private ImageView mImgRightIcon;
    //分割线
    private View mDivider;

    // 点击事件监听
    private OnIconClickListener mListener;

    public TitleBar(Context context) {
        this(context, null);
        AppLog.i(Constants.TITLE_BAR, "titlebar()");
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        AppLog.i(Constants.TITLE_BAR, "titlebar()-");
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AppLog.i(Constants.TITLE_BAR, "titlebar()--");

        // -获取属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        // 激活返回按钮
        mBackBtnEnabled = ta.getBoolean(R.styleable.TitleBar_enableBackBtn, DEFAULT_BACK_BTN_ENABLED);
        // 返回按钮颜色
        mBackBtnColor = ta.getInt(R.styleable.TitleBar_backBtnColor, DEFAULT_BACK_BTN_COLOR);
        // 激活分割线
        mDividerEnabled = ta.getBoolean(R.styleable.TitleBar_enableDivider, DEFAULT_DIVIDER_ENABLED);
        // 分割线颜色
        mDividerColor = ta.getInt(R.styleable.TitleBar_dividerColor, DEFAULT_DIVIDER_COLOR);
        // 标题文本
        mTitleText = ta.getString(R.styleable.TitleBar_titleBarText);
        // 标题字体大小
        mTitleTextSize = ta.getFloat(R.styleable.TitleBar_titleTextSize, DEFAULT_TEXT_SIZE);
        // 标题字体颜色
        mTitleTextColor = ta.getInt(R.styleable.TitleBar_titleBarTextColor, DEFAULT_TEXT_COLOR);
        // 图标大小
        mDrawableDimen = ta.getFloat(R.styleable.TitleBar_drawableDimen, DEFAULT_DRAWABLE_DIMEN);
        // 左图标资源
        mDrawableLeftSrc = ta.getResourceId(R.styleable.TitleBar_drawableLeftSrc, SRC_NULL);
        // 左图标是否可点击
        mDrawableLeftClickable = ta.getBoolean(R.styleable.TitleBar_drawableLeftClickable, DEFAULT_DRAWABLE_LEFT_CLICKABLE);
        // 右图标资源
        mDrawableRightSrc = ta.getResourceId(R.styleable.TitleBar_drawableRightSrc, SRC_NULL);
        // 右图标是否可点击
        mDrawableRightClickable = ta.getBoolean(R.styleable.TitleBar_drawableRightClickable, DEFAULT_DRAWABLE_RIGHT_CLICKABLE);
        // 图标间距
        mDrawableSpacing = ta.getFloat(R.styleable.TitleBar_drawableSpacing, DEFAULT_DRAWABLE_SPACING);
        // 回收资源
        ta.recycle();

        // 布局填充
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);

        // -关联控件
        mTvTitle = (TextView) findViewById(R.id.titlebar_title);
        mImgBack = (ImageView) findViewById(R.id.titlebar_back);
        mImgLeftIcon = (ImageView) findViewById(R.id.titlebar_left_icon);
        mImgRightIcon = (ImageView) findViewById(R.id.titlebar_right_icon);
        mDivider = findViewById(R.id.titlebar_divider);


        // -初始控件
        // 标题文
        mTvTitle.setText(mTitleText);
        mTvTitle.setTextColor(mTitleTextColor);
        mTvTitle.setTextSize(mTitleTextSize);

        // 分割线
        mDivider.setBackgroundColor(mDividerColor);

        // 返回按钮
        if (mBackBtnEnabled) { // 激活状态下可见
            mImgBack.setVisibility(VISIBLE);
        } else { // 非激活状态下不可见
            mImgBack.setVisibility(GONE);
        }
        // 监听事件回调
        mImgBack.setOnClickListener(this);

        // 左侧图标
        if (mDrawableLeftSrc != SRC_NULL) {
            // 设置图标可见
            mImgLeftIcon.setVisibility(VISIBLE);
            // 设置资源
            mImgLeftIcon.setImageResource(mDrawableLeftSrc);
            // 如果图标可以点击
            if (mDrawableLeftClickable) {
                mImgLeftIcon.setOnClickListener(this);
            }
        } else {
            // 设置图标不可见
            mImgLeftIcon.setVisibility(GONE);
            // 不可点击
            mDrawableLeftClickable = false;
        }

        // 右侧图标
        if (mDrawableRightSrc != SRC_NULL) {
            // 设置图标可见
            mImgRightIcon.setVisibility(VISIBLE);
            // 设置资源
            mImgRightIcon.setImageResource(mDrawableRightSrc);
            // 如果图标可以点击
            if (mDrawableRightClickable) {
                mImgRightIcon.setOnClickListener(this);
            }
        } else {
            // 设置图标不可见
            mImgRightIcon.setVisibility(GONE);
            // 不可点击
            mDrawableRightClickable = false;
        }
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        mTitleText = title;
        mTvTitle.setText(mTitleText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.titlebar_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.titlebar_left_icon:
                mListener.onLeftIconClickListener();
                break;
            case R.id.titlebar_right_icon:
                mListener.onRightIconClickListener();
                break;
        }
    }

    /**
     * 设置监听事件
     * @param listener
     */
    public void setOnIconClickListener(OnIconClickListener listener) {
        this.mListener = listener;
    }

    /**
     * 图标点击事件监听接口
     */
    public interface OnIconClickListener {
        // 左侧图标点击事件
        void onLeftIconClickListener();

        // 右侧图标点击事件
        void onRightIconClickListener();
    }
}
