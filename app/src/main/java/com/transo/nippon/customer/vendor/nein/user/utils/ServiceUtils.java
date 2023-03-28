package com.transo.nippon.customer.vendor.nein.user.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.ContextCompat;


public class ServiceUtils {


    /**
     * Check service is running
     *
     * @param context      -pass context
     * @param serviceClass -service class name
     * @return -true/false
     */
    public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null) {
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void doPeriodicTask(Context context, Class<?> serviceClass) {
        System.out.println("Service started...");
        if (!isServiceRunning(context, serviceClass)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ContextCompat.startForegroundService(context, new Intent(context, serviceClass));
            } else {
                context.startService(new Intent(context, serviceClass));
            }
        }
    }

    public static void doPeriodicTask(Context context, Class<?> serviceClass, Bundle bundle) {
        if (!isServiceRunning(context, serviceClass)) {
            Intent intent = new Intent(context, serviceClass);
            intent.putExtras(bundle);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ContextCompat.startForegroundService(context, intent);
                System.out.println("Service started...");
            } else {
                context.startService(intent);
                System.out.println("Service started...");
            }
        }
    }

    public static void doPeriodicTasks(Context context, Class<?> serviceClass) {
        System.out.println("Service started...");
        if (!isServiceRunning(context, serviceClass)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Intent intent = new Intent(context, serviceClass);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ContextCompat.startForegroundService(context, intent);
            } else {
                Intent intent = new Intent(context, serviceClass);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startService(intent);
            }
        }
    }

    public static void startService(Context context, Class<?> serviceClass) {
        System.out.println("Service started...");
        if (!isServiceRunning(context, serviceClass)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ContextCompat.startForegroundService(context, new Intent(context, serviceClass));
//                writeToFile("\nService started-->"+getCurrentDateTimeAsString(),"Service ");
            } else {
                context.startService(new Intent(context, serviceClass));
            }
        }
    }


    public static void stopService(Context context, Class<?> serviceClass) {
        System.out.println("Service stoped..."+serviceClass);
        if (isServiceRunning(context, serviceClass)) {
            context.stopService(new Intent(context, serviceClass));
        }
    }
}