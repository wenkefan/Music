package com.fwk.music.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wenke on 2018/2/6.
 */

public class Nammu {

    private static final String TAG = Nammu.class.getSimpleName();

    private static SharedPreferences sp;

    private static Context context;

    public static void init(Context context){
        sp = context.getSharedPreferences("pl.tajchert.runtimepermissionhelper",Context.MODE_PRIVATE);
        Nammu.context = context;
    }

    public static boolean verifyPermissions(int[] grantResults){
        for (int result : grantResults){
            if (result != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /**
     * 如果Activity能访问所有的给定权限，返回true
     * @param activity
     * @param permissions
     * @return
     */
    public static boolean hasPermission(Activity activity, String[] permissions){
        for (String permission : permissions) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static void askForPermission(Activity activity, String[] permissions, PermissionCallback permissionCallback) {
        if (permissionCallback == null) {
            return;
        }
        if (hasPermission(activity, permissions)) {
            permissionCallback.permissionGranted();
            return;
        }
        PermissionRequest permissionRequest = new PermissionRequest(new ArrayList<String>(Arrays.asList(permissions)), permissionCallback);
//        permissionRequests.add(permissionRequest);

        activity.requestPermissions(permissions, permissionRequest.getRequestCode());
    }
}
