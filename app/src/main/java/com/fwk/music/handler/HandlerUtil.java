package com.fwk.music.handler;

import android.content.Context;
import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by wenke on 2018/3/5.
 */

public class HandlerUtil extends Handler {

    private static HandlerUtil instance = null;
    private WeakReference<Context> mActivityReference;

    public static HandlerUtil getInstance(Context context){
        if (instance == null){
            synchronized (HandlerUtil.class){
                instance = new HandlerUtil(context.getApplicationContext());
            }
        }
        return instance;
    }

    private HandlerUtil(Context context){
        mActivityReference = new WeakReference<Context>(context);
    }

}
