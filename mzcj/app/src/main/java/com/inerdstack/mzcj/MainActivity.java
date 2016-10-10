package com.inerdstack.mzcj;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.inerdstack.mzcj.databinding.ActivityMainBinding;
import com.inerdstack.mzcj.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("inerdstack", "22");
        binding.setUser(user);
    }
}
