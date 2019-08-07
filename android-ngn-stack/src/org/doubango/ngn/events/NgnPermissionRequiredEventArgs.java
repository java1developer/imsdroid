package org.doubango.ngn.events;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dmitry Ovsiannikov on 8/7/19.
 */
public class NgnPermissionRequiredEventArgs implements Parcelable {
    private List<String> permissions = new ArrayList<String>();

    public List<String> getPermissions() {
        return permissions;
    }

    public NgnPermissionRequiredEventArgs setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.permissions);
    }

    private NgnPermissionRequiredEventArgs() {
    }

    protected NgnPermissionRequiredEventArgs(Parcel in) {
        this.permissions = in.createStringArrayList();
    }

    public static final Parcelable.Creator<NgnPermissionRequiredEventArgs> CREATOR = new Parcelable.Creator<NgnPermissionRequiredEventArgs>() {
        @Override
        public NgnPermissionRequiredEventArgs createFromParcel(Parcel source) {
            return new NgnPermissionRequiredEventArgs(source);
        }

        @Override
        public NgnPermissionRequiredEventArgs[] newArray(int size) {
            return new NgnPermissionRequiredEventArgs[size];
        }
    };

    public static class Builder {
        private List<String> permissions = new ArrayList<>();

        public Builder addPermission(String permission) {
            permissions.add(permission);
            return this;
        }

        public NgnPermissionRequiredEventArgs build() {
            NgnPermissionRequiredEventArgs result = new NgnPermissionRequiredEventArgs();
            result.setPermissions(permissions);
            return result;
        }
    }


}
