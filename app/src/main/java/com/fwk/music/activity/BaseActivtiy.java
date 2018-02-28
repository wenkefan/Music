package com.fwk.music.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wenke on 2018/2/28.
 * 基类
 */

public abstract class BaseActivtiy extends AppCompatActivity {

    private String TAG = BaseActivtiy.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splash();
        setContentView(getLayoutId());
        //初始化控件
        init();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    //MainActivity重写此方法，引导页面
    public void splash(){}
}
