package com.transo.nippon.customer.vendor.nein.user.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.core.app.ActivityCompat;

public class DeviceUtils {

    /**
     * Device name
     *
     * @return device name
     */
    public static String getDeviceNames() {
        try {
//            String manufacturer = Build.MANUFACTURER;
//            String model = Build.MODEL;
            if (Build.MODEL.startsWith(Build.MANUFACTURER)) {
                return capitalize(Build.MODEL);
            } else {
                return capitalize(Build.MANUFACTURER) + " " + Build.MODEL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * @param s
     * @return
     */
    private static String capitalize(String s) {
        try {
            if (s == null || s.length() == 0) {
                return "";
            }
            char first = s.charAt(0);
            if (Character.isUpperCase(first)) {
                return s;
            } else {
                return Character.toUpperCase(first) + s.substring(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Check app version name
     *
     * @param ctx
     * @return package version name
     */
    public static String getVersionName(Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

//    /**
//     * To access the current device name
//     */
//    public static String getDeviceNames() {
//        try {
//            String manufacturer = Build.MANUFACTURER;
//            return capitalizes(manufacturer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    /**
//     * To capitalize the device
//     */
//    public static String capitalizes(String str) {
//        if (TextUtils.isEmpty(str)) {
//            return str;
//        }
//        char[] arr = str.toCharArray();
//        boolean capitalizeNext = true;
//        StringBuilder phrase = new StringBuilder();
//        for (char c : arr) {
//            if (capitalizeNext && Character.isLetter(c)) {
//                phrase.append(Character.toUpperCase(c));
//                capitalizeNext = false;
//                continue;
//            } else if (Character.isWhitespace(c)) {
//                capitalizeNext = true;
//            }
//            phrase.append(c);
//        }
//        return phrase.toString();
//    }

    /**
     * Ckeck battery percentage
     *
     * @param context
     * @return battery percentage
     */
    public static int batteryLevel(Context context) {
        int percent = 0;
        Intent intent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        if (intent != null) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
            percent = (level * 100) / scale;
        }
        return percent;
    }

    /**
     * To hide keyboard
     */
    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View view = activity.getCurrentFocus();
            if (view == null) {
                view = new View(activity);
            }
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To show keyboard
     */
    public static void showKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To access the current device name
     */
    public static String getDeviceName() {
        try {
            String manufacturer = Build.MANUFACTURER;
            return capitalizes(manufacturer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * To capitalize the device
     */
    private static String capitalizes(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }
        return phrase.toString();
    }

    public static int getVersionCode(Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDeviceIMEI(Context ctx) {
        String imeiNumber = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return "permission";
            }
            if (telephonyManager != null) {
                imeiNumber = telephonyManager.getDeviceId();
            }
            return imeiNumber;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imeiNumber;
    }

}
