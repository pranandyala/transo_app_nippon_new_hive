package com.transo.nippon.customer.vendor.nein.user.utils;

import android.location.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtils {

    public static final String DATEFORMAT1 = "dd MMM yyyy h:mm a";
    public static final String DATEFORMAT2 = "dd-mm-yyyy";
    public static final String DATEFORMAT3 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMAT4 = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String DATEFORMAT5 = "dd-MMM-yyyy";
    public static final String DATEFORMAT7 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMAT6 = "dd MMM yyyy hh:mm a";
    public static final String DATEFORMAT8 = "MM/dd/yyyy";
    public static final String DATEFORMAT9 = "yyyy_MM_dd_HH_mm_ss";
    public static final String DATEFORMAT10 = "dd-mm-yyyy";
    public static final String DATEFORMAT11 = "dd-MMM-yyyy";
    public static final String DATEFORMAT12 = "dd-MM-yyyy";
    public static final String DATEFORMAT13 = "dd/MM/yyyy";

    private static final String TIMEFORMAT = "HH:mm a";
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormatToDisplay = new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH);

    public static SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);


//    Date format
//     "yyyy-MM-dd HH:mm:ss.S"
//     "yyyy-MM-dd HH:mm:ss.SS"
//     "yyyy-MM-dd HH:mm:ss.SSS"
//     "yyyy-MM-dd HH:mm:ss.SSSS"
//     "yyyy-MM-dd HH:mm:ss.SSSSS"
//     "yyyy-MM-dd HH:mm:ss.SSSSSS"


    /**
     * To get current time in string format
     */
    public static String getDateTimeAsString() {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT1, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Function to get utc time
     *
     * @param str - date to be converted
     */
    public static String parseUTCDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT7, Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = dateFormat.parse(str);
            assert date != null;
            return formatDate(date.getTime(), DATEFORMAT6);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To change time stamp to given date format
     *
     * @param timestamp  -  timestamp to be converted
     * @param destFormat - required format
     */
    private static String formatDate(long timestamp, String destFormat) {
        try {
            Date date = new Date(timestamp);
            SimpleDateFormat dateFormat = new SimpleDateFormat(destFormat, Locale.ENGLISH);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * To get current time in string format
     */
    public static String getCurrentdatetimeAsString() {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT5, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * To get current time in string format
     */
    public static String getCurrentTimeAsString() {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(TIMEFORMAT, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * To get current utc time in string format
     */
    public static String getUTCdatetimeAsString() {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * To get current utc time in string format
     */
    public static String getCurrentDateTimeAsString() {

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * To get current utc time in string format
     */
    public static String getCurrentDateTimeAsStringWithNanoSeconds() {

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT4, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * To get current date time in string format
     *
     * @param milliSeconds
     * @return date time
     */
    public static String getDateTimeFromMiliSeconds(long milliSeconds) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT1, Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliSeconds);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * To get current date time in string format
     *
     * @param milliSeconds
     * @return date time
     */
    public static String getDateTimeFromMiliSeconds(String milliSeconds) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT8, Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(milliSeconds));
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return milliSeconds;
        }
    }


    /**
     * Get utc time from location
     *
     * @param location - location variable to fetch time
     */
    public static String getUTCDateTimeFromLocationAsString(Location location) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(new Date(location.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get utc time from location
     *
     * @param time - location variable to fetch time
     */
    public static String getUTCDateTimeFromLocationAsString(String time) {
        try {
            long times = Long.parseLong(time);
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(new Date(times));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get current time from location
     *
     * @param location - location variable to fetch time
     */
    public static String getCurrentDateFromLocationAsString(Location location) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT2, Locale.ENGLISH);
            return sdf.format(new Date(location.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get current time from location
     *
     * @param location - location variable to fetch time
     */
    public static String getCurrentDateTimeFromLocationAsString(Location location) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            return sdf.format(new Date(location.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Get current time from location
     */
    public static String getCurrentdatefromDeviceAsString() {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT2, Locale.ENGLISH);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * Get current time from location
     *
     * @param location - location variable to fetch time
     */
    public static String getCurrentLocationdatetimeAsString(Location location) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT3, Locale.ENGLISH);
            return sdf.format(new Date(location.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getLastPingTime(SimpleDateFormat sdf, String lastpingtime) {
        try {
            Date date = new Date(Long.valueOf(lastpingtime)); // *1000 is to convert seconds to milliseconds
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "NA";
        }
    }

    public static String getDate(String timeStamp) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);
            Date netDate = (new Date(Long.parseLong(timeStamp)));
            return sdf.format(netDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "NA";
        }
    }

    public static String getCurrentDate() {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getCurrentDate(String format) {
        try {
            return new SimpleDateFormat(format, Locale.ENGLISH).format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }



    public static String getCurrentDateTime() {
        try {
            return new SimpleDateFormat(DATEFORMAT9).format(Calendar.getInstance().getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getLastWeekDate(String format) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DAY_OF_YEAR, -7);
            cal.getTime();
            return new SimpleDateFormat(format, Locale.ENGLISH).format(cal.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

}
