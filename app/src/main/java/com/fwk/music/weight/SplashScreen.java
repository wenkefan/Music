package com.fwk.music.weight;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by wenke on 2018/2/28.
 * 引导页面，停留若干秒，自动消失
 */

public class SplashScreen {

    public final static int SLIDE_LEFT = 1;
    public final static int SLIDE_UP = 2;
    public final static int SLIDE_OUT = 3;

    private Activity mActivity;

    private Dialog splashDialog;

    public SplashScreen(Activity activity){
        this.mActivity = activity;
    }

    /**
     * 显示引导页面
     * @param imageResource 显示的资源
     * @param animation     消失的动画效果
     */
    public void show(final int imageResource, final int animation){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DisplayMetrics metrics = new DisplayMetrics();

                LinearLayout layout = new LinearLayout(mActivity);
                layout.setMinimumHeight(metrics.heightPixels);
                layout.setMinimumWidth(metrics.widthPixels);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setBackgroundColor(Color.BLACK);
                layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,0.0F));
                layout.setBackgroundResource(imageResource);

                splashDialog = new Dialog(mActivity,android.R.style.Theme_Translucent_NoTitleBar);
                // 全屏 66816 - 非全屏 65792
                // int val = context.getWindow().getAttributes().flags;
                if (splashDialog.getWindow().getAttributes().flags
                        == WindowManager.LayoutParams.FLAG_FULLSCREEN){
                    splashDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
                Window window = splashDialog.getWindow();
                switch (animation){
                    case SLIDE_LEFT:
                        window.setWindowAnimations();
                        break;
                    case SLIDE_UP:
                        break;
                    case SLIDE_OUT:
                    break;
                    default:
                }
            }
        };
    }

    public void removeSplahDialog(){
        if (splashDialog != null && splashDialog.isShowing()){
            splashDialog.dismiss();
            splashDialog = null;
        }
    }

}
