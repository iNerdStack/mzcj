package com.inerdstack.mzcj.global.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inerdstack.mzcj.R;
import com.inerdstack.mzcj.global.views.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.titlebar_homepage)
    TitleBar mTbHomepage;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // 使用ButterKnife框架
        ButterKnife.bind(this, view);

        // 初始化视图
        initView();
        return view;
    }

    /**
     * 初始化视图
     */
    private void initView() {
        // 设置标题栏点击事件
        mTbHomepage.setOnIconClickListener(new TitleBar.OnIconClickListener() {
            @Override
            public void onLeftIconClickListener() {
                Toast.makeText(getActivity(), "定位", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightIconClickListener() {
                Toast.makeText(getActivity(), "二维码", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
