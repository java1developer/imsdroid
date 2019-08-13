package org.doubango.ngn.data.viewmodel;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public interface INgnViewModel<LIVE_DATA_TYPE> {
    LIVE_DATA_TYPE getLiveData();
}
