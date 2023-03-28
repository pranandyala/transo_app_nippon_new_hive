package com.transo.nippon.customer.vendor.nein.user.utils;

public class JsonDataUtils {


    public static String jsonStringData(String data, String input) {
        try {
            if (data == null || data.equals("null")) {
                return input;
            } else {
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return input;
        }
    }

    public static Integer jsonIntData(Integer data) {
        try {
            if (data != null) {
                return data;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Integer jsonIntData(String data) {
        try {
            if (data == null || data.equals("null") || data.equals("")) {
                return 0;
            } else {
                return Integer.parseInt(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static String jsonStringData(String data) {
        try {
            if (data == null || data.equals("null") || data.equals("")) {
                return "0";
            } else {
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static Double jsonDoubleData(String data) {
        try {
            if (data == null || data.equals("null") || data.equals("")) {
                return 0.0;
            } else {
                return Double.parseDouble(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
