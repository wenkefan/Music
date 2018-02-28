package com.fwk.music;

import android.app.Application;
import android.content.Context;

/**
 * Created by wenke on 2018/2/6.
 */

public class MyApplication extends Application {

    public static Context context;

    private static int MAX_MEN = (int) (Runtime.getRuntime().maxMemory() / 4);

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
