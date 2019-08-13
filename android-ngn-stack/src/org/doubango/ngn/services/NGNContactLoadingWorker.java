package org.doubango.ngn.services;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.doubango.ngn.NgnApplication;
import org.doubango.ngn.data.DataContainer;
import org.doubango.ngn.model.NgnContact;
import org.doubango.ngn.model.NgnPhoneNumber;
import org.doubango.ngn.utils.NgnStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry Ovsiannikov on 8/9/19.
 */
public class NGNContactLoadingWorker extends Worker {

    public NGNContactLoadingWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        load();
        return Result.success();
    }

    private void load() {
        List<NgnContact> contactList = new ArrayList<>();

        NgnContact contact = null;
        ContentResolver contentResolver = NgnApplication.getInstance().getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                DataContainer<List<NgnContact>> result = new DataContainer<>(DataContainer.Status.LOADING, contactList, null);
                NgnApplication.getInstance().getNgnRepository().getContactList().postValue(result);

                int indexPhoneContactId = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
                int indexPhoneType = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                int indexPhoneLabel = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.LABEL);
                int indexPhoneNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int indexPhonePhotoId = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID);
                int indexContactDisplayName = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

                while (cursor.moveToNext()) {
                    int id = cursor.getInt(indexPhoneContactId);
                    int type = cursor.getInt(indexPhoneType);
                    String label = cursor.getString(indexPhoneLabel);
                    String phoneNumber = cursor.getString(indexPhoneNumber);
                    int photoId = cursor.getInt(indexPhonePhotoId);

                    if(phoneNumber != null){
                        phoneNumber = phoneNumber.replace("-", "");
                        if(NgnStringUtils.isNullOrEmpty(label)){
                            final int resId = android.provider.ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(type);
                            label = NgnApplication.getInstance().getString(resId);
                        }
                        if(contact == null || contact.getId() != id){
                            String displayName = cursor.getString(indexContactDisplayName);
                            contact = new NgnContact(id, displayName);
                            if(photoId != 0){
                                contact.setPhotoId(photoId);
                            }
                            contactList.add(contact);
                        }
                        contact.addPhoneNumber(NgnPhoneNumber.fromAndroid2LocalType(type), phoneNumber, label);
                    }
                }
            }
        } finally {
            DataContainer<List<NgnContact>> result = new DataContainer<>(DataContainer.Status.COMPLETED, contactList, null);
            NgnApplication.getInstance().getNgnRepository().getContactList().postValue(result);

            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
