package com.inerdstack.mzcj;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inerdstack.mzcj.global.fragments.CarFragment;
import com.inerdstack.mzcj.global.fragments.HomeFragment;
import com.inerdstack.mzcj.global.fragments.MeFragment;
import com.inerdstack.mzcj.global.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // -tab栏
    @BindView(R.id.bottombar_homepage)
    LinearLayout mTabHomepage;
    @BindView(R.id.bottombar_car)
    LinearLayout mTabCar;
    @BindView(R.id.bottombar_me)
    LinearLayout mTabMe;

    // -tab栏图标
    @BindView(R.id.bottombar_homepage_icon)
    ImageView mIconHomepage;
    @BindView(R.id.bottombar_car_icon)
    ImageView mIconCar;
    @BindView(R.id.bottombar_me_icon)
    ImageView mIconMe;

    // -tab栏标题
    @BindView(R.id.bottombar_homepage_title)
    TextView mTitleHomepage;
    @BindView(R.id.bottombar_car_title)
    TextView mTitleCar;
    @BindView(R.id.bottombar_me_title)
    TextView mTitleMe;

    // -碎片声明
    private Fragment mHomepageFragment;
    private Fragment mCarFragment;
    private Fragment mMeFragment;

    // -颜色声明
    private int mColorNormal;
    private int mColorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用ButterKnife框架
        ButterKnife.bind(this);

        // 初始化颜色
        initColor();
        // 默认第一项选中
        setSelected(Constants.TAB_HOMEPAGE);
    }

    /**
     * 初始化颜色
     */
    private void initColor() {
        mColorNormal = ContextCompat.getColor(MainActivity.this, R.color.color_tab_text_normal);
        mColorSelected = ContextCompat.getColor(MainActivity.this, R.color.color_tab_text_selected);
    }

    /**
     * tab栏事件监听
     *
     * @param v
     */
    @OnClick({R.id.bottombar_homepage, R.id.bottombar_car, R.id.bottombar_me})
    void clickTab(View v) {
        switch (v.getId()) {
            case R.id.bottombar_homepage:
                setSelected(Constants.TAB_HOMEPAGE);
                break;
            case R.id.bottombar_car:
                setSelected(Constants.TAB_CAR);
                break;
            case R.id.bottombar_me:
                setSelected(Constants.TAB_ME);
                break;
        }
    }

    /**
     * tab栏选中
     *
     * @param selected
     */
    private void setSelected(int selected) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        // 隐藏碎片
        hideFraments(transaction);

        switch (selected) {
            case Constants.TAB_HOMEPAGE: // 首页
                if (mHomepageFragment == null) {
                    mHomepageFragment = new HomeFragment();
                    transaction.add(R.id.fragment_container, mHomepageFragment);
                } else {
                    transaction.show(mHomepageFragment);
                }

                mIconHomepage.setImageResource(R.drawable.icon_home_selected);
                mTitleHomepage.setTextColor(mColorSelected);
                break;
            case Constants.TAB_CAR: // 爱车
                if (mCarFragment == null) {
                    mCarFragment = new CarFragment();
                    transaction.add(R.id.fragment_container, mCarFragment);
                } else {
                    transaction.show(mCarFragment);
                }

                mIconCar.setImageResource(R.drawable.icon_car_selected);
                mTitleCar.setTextColor(mColorSelected);
                break;
            case Constants.TAB_ME: // 我
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.fragment_container, mMeFragment);
                } else {
                    transaction.show(mMeFragment);
                }

                mIconMe.setImageResource(R.drawable.icon_user_selected);
                mTitleMe.setTextColor(mColorSelected);
                break;
        }

         // 提交事务
        transaction.commit();
    }

    /**
     * 隐藏碎片
     */
    private void hideFraments(FragmentTransaction transaction) {
        // 如果事务为空，则退出方法
        if (transaction == null)
            return;

        // 首页
        if (mHomepageFragment != null) {
            transaction.hide(mHomepageFragment);
        }

        // 爱车
        if (mCarFragment != null) {
            transaction.hide(mCarFragment);
        }

        // 我
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }

        // tab栏重置
        resetTab();
    }

    /**
     * tab栏重置
     */
    private void resetTab() {
        // 首页
        mIconHomepage.setImageResource(R.drawable.icon_home_normal);
        mTitleHomepage.setTextColor(mColorNormal);

        // 爱车
        mIconCar.setImageResource(R.drawable.icon_car_normal);
        mTitleCar.setTextColor(mColorNormal);

        // 我
        mIconMe.setImageResource(R.drawable.icon_user_normal);
        mTitleMe.setTextColor(mColorNormal);
    }


}
