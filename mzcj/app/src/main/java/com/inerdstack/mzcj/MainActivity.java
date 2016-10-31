package com.inerdstack.mzcj;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottombar_homepage)
    LinearLayout mTabHomepage;
    @BindView(R.id.bottombar_car)
    LinearLayout mTabCar;
    @BindView(R.id.bottombar_me)
    LinearLayout mTabMe;

    // 碎片声明
    private Fragment mHomepageFragment;
    private Fragment mCarFragment;
    private Fragment mMeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用ButterKnife框架
        ButterKnife.bind(this);

    }

    /**
     * tab栏事件监听
     * @param v
     */
    @OnClick({R.id.bottombar_homepage, R.id.bottombar_car, R.id.bottombar_me})
    void clickTab(View v) {
        switch (v.getId()) {
            case R.id.bottombar_homepage:

                break;
            case R.id.bottombar_car:

                break;
            case R.id.bottombar_me:

                break;
        }
    }

    private void setSelection() {

    }

}
