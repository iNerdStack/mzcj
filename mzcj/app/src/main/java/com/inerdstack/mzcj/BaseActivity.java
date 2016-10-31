package com.inerdstack.mzcj;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wangjie on 2016/10/31.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    /**
     * 返回上移页面
     */
    protected void back() {
        this.finish();
    }
}
