package com.fwk.music.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fwk.music.R;
import com.fwk.music.handler.HandlerUtil;
import com.fwk.music.weight.SplashScreen;

public class MainActivity extends BaseActivtiy {

    private SplashScreen splashScreen;

    @Override
    public void splash() {
        splashScreen = new SplashScreen(this);
        splashScreen.show(R.mipmap.art_login_bg,SplashScreen.SLIDE_LEFT);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        removeSplah();
    }

    /**
     * 关闭闪屏页
     */
    private void removeSplah(){
        HandlerUtil.getInstance(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreen.removeSplahDialog();
            }
        },3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashScreen.removeSplahDialog();
    }
}
