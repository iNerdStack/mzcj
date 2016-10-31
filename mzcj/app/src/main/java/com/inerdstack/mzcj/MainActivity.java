package com.inerdstack.mzcj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inerdstack.mzcj.databinding.ActivityMainBinding;
import com.inerdstack.mzcj.model.User;
import com.inerdstack.mzcj.global.view.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titlebar)
    TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用ButterKnife框架
        ButterKnife.bind(this);
    }
}
