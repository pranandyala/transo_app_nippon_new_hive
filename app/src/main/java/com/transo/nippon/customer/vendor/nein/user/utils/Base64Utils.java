package com.transo.nippon.customer.vendor.nein.user.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Base64Utils {

    public static String convertToBase64(String imagePath) {
        String data = "";
        try {
            Bitmap bm = BitmapFactory.decodeFile(imagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] byteArrayImage = baos.toByteArray();
            return Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

     /**
     * Convert file to base64 data
     *
     * @param context
     * @param filePath
     * @return base64 data
     */
    public static String convertToBase64(Context context, String filePath) {
        String base64 = "";
        try {
            Bitmap bm = BitmapFactory.decodeFile(filePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
            byte[] bytes = baos.toByteArray();
            base64 = Base64.encodeToString(bytes, Base64.DEFAULT);
            return base64;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }
}
