package com.transo.nippon.customer.vendor.nein.user.utils;

import android.net.Uri;

import androidx.fragment.app.FragmentActivity;

import java.io.InputStream;

/*
Class to get size of the file in kilobytes
 */

public class UtilClassName {

    public static int getFileSize(Uri imageUri, FragmentActivity activity){
        int kb_size=0;
        try {
            InputStream is=activity.getContentResolver().openInputStream(imageUri);
            assert is != null;
            int byte_size=is.available();
            kb_size=byte_size/1024;
        }
        catch (Exception e){
            // here you can handle exception here
        }
        return kb_size;
    }
}
