package com.mark.basemoudle.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            return;
        }
        setContentView(getLayoutId());
        initView();
        getData();
    }

    protected abstract void initView();

    protected abstract void getData();

    protected abstract int getLayoutId();
}
