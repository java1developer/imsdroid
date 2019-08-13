package org.doubango.ngn.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.doubango.ngn.model.NgnContact;

import java.util.List;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public class ContactList extends MutableLiveData<DataContainer<List<NgnContact>>> {
}
