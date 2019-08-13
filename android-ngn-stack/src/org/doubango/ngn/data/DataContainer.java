package org.doubango.ngn.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public class DataContainer<DATA_TYPE> {
    private Status status;
    private DATA_TYPE data;
    private Throwable error;

    public DataContainer(@NonNull Status status, @Nullable DATA_TYPE data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public Status getStatus() {
        return status;
    }

    public DATA_TYPE getData() {
        return data;
    }

    public Throwable getError() {
        return error;
    }

    public boolean isCompleted() {
        return status == Status.COMPLETED;
    }

    public enum Status {
        LOADING,
        COMPLETED
    }


}
