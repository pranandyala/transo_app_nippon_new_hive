package com.transo.nippon.customer.vendor.nein.user.utils;


import android.text.format.DateFormat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by deepak on 30/1/18.
 */

public class Utils {


    //Convert long data type timestamp to 'dd MMM yyyy hh:mm a' date format
    public static String formatedate(String lastpingtime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
            Date time = new Date(Long.valueOf(lastpingtime));
            return sdf.format(time);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "NA";
    }


    //Convert String price format to format decimal format

    public static String price(String price) {
        try {
            return new DecimalFormat("##,##,##0").format(Integer.parseInt(price)) + " /-";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "NA";
    }

    public static String longDateString(long data) {
        String dateConvert = "";
        try {
            String format="dd MMM yyyy hh:mm aaa";
            dateConvert = DateFormat.format(format, new Date(data)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateConvert;
    }

}
