package com.bawei.songjiahao.Base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int layoutId();
}
