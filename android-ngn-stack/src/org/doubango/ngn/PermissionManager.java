package org.doubango.ngn;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import org.doubango.ngn.events.NgnPermissionRequiredEventArgs;
import org.doubango.ngn.events.NgnPublicationEventArgs;

/**
 * Created by Dmitry Ovsiannikov on 8/7/19.
 */
public class PermissionManager {
    private static final String ACTION_PERMISSION_EVENT = PermissionManager.class.getName();
    private static final String KEY_PERMISSION_REQUIRED_DATA = "KEY_PERMISSION_REQUIRED_DATA";

    public static boolean isReadContactPermissionOn() {
        return  (ContextCompat.checkSelfPermission(NgnApplication.getInstance(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED);
    }

    public static void broadcastPermissionRequiredEvent(NgnPermissionRequiredEventArgs args) {
        final Intent intent = new Intent(ACTION_PERMISSION_EVENT);
        intent.putExtra(KEY_PERMISSION_REQUIRED_DATA, args);
        NgnApplication.getInstance().sendBroadcast(intent);
    }
}
