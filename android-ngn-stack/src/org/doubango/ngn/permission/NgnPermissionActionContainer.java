package org.doubango.ngn.permission;

import org.doubango.ngn.utils.INgnAction;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public class NgnPermissionActionContainer {
    private INgnAction action;
    private HashMap<String, String> permissions = new HashMap<>();

    public INgnAction getAction() {
        return action;
    }

    public NgnPermissionActionContainer setAction(INgnAction action) {
        this.action = action;
        return this;
    }

    public NgnPermissionActionContainer addPermission(@NotNull String permission, @NotNull String explainMessage) {
        permissions.put(permission, explainMessage);
        return this;
    }
}
