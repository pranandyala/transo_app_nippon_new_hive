package com.transo.nippon.customer.vendor.nein.user.utils;

public class StringUtils {


    public static String getMiddleChars(String data) {
        try {
            if (data.length() == 15) {
                return data.substring(2, 12);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
