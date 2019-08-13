package org.doubango.ngn.data.viewmodel;

import androidx.lifecycle.ViewModel;

import org.doubango.ngn.NgnApplication;
import org.doubango.ngn.data.ContactList;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public class ViewModelContactList extends ViewModel implements INgnViewModel<ContactList> {
    private ContactList contactList = NgnApplication.getInstance().getNgnRepository().getContactList();

    @Override
    public ContactList getLiveData() {
        return contactList;
    }
}
