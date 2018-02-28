package com.fwk.music.permissions;

/**
 * Created by wenke on 2018/2/6.
 */

public interface PermissionCallback {

    void permissionGranted();

    void permissionRefused();
}
