package com.transo.nippon.customer.vendor.nein.user.utils;




import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;


import com.transo.nippon.customer.vendor.nein.user.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidationUtils {

    private static String emailPattern = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static String gstinPattern = "\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}[A-Z\\d]{1}[Z]{1}[A-Z\\d]{1}";
    private static String panPattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    private static String voteridPattern = "^([a-zA-Z]){3}([0-9]){7}?$";
    private static String drivinglicensePattern = "[A-Z]{2}[0-9]{13}";
    private static String ifscCodePattern = "^[A-Z]{4}0[A-Z0-9]{6}$";
    private static String accountNoPattern = "[0-9]{9,18}";

//    android:digits="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz- "


    /**
     * Validate email .
     *
     * @param email the email
     * @return true/false
     */
    public static boolean validateEmail(String email) {
        try {
            Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate email .
     *
     * @param email the email
     * @return true/false
     */
    public static boolean isValidMail(String email) {
        try {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate mobileno .
     *
     * @param phone the mobileno
     * @return true/false
     */
    public static boolean isValidMobile(String phone) {
        try {
            return Patterns.PHONE.matcher(phone).matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate mobileno
     *
     * @param phoneNumber
     * @return true/false
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        try {
            if (!TextUtils.isEmpty(phoneNumber)) {
                return Patterns.PHONE.matcher(phoneNumber).matches();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate GstIn .
     *
     * @param number the number
     * @return true/false
     */
    public static boolean validateGstin(String number) {
        try {
            Pattern pattern = Pattern.compile(gstinPattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Validate Pan no .
     *
     * @param number the number
     * @return true/false
     */
    public static boolean validatePan(String number) {
        try {
            Pattern pattern = Pattern.compile(panPattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param aadharNumber number
     * @return true/false
     */

  /*  public static boolean validateAadharNumber(String aadharNumber){
        Pattern aadharPattern = Pattern.compile("\\d{12}");
        boolean isValidAadhar = aadharPattern.matcher(aadharNumber).matches();
        if(isValidAadhar){
            isValidAadhar = VerhoeffAlgorithm.validateVerhoeff(aadharNumber);
        }
        return isValidAadhar;
    }*/

    /**
     * @param number number
     * @return true/false
     */

    public static boolean validateVoterid(String number) {
        try {
            Pattern pattern = Pattern.compile(voteridPattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param number number
     * @return true/false
     */

    public static boolean validateDrivingLicense(String number) {
        try {
            Pattern pattern = Pattern.compile(drivinglicensePattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param number number
     * @return true/false
     */
    public static boolean validateIfscCode(String number) {
        try {
            Pattern pattern = Pattern.compile(ifscCodePattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param number number
     * @return true/false
     */
    public static boolean validateAccountNo(String number) {
        try {
            Pattern pattern = Pattern.compile(accountNoPattern);
            Matcher matcher = pattern.matcher(number);
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean validateEmailMobileNo(Context context, View view, String data) {
        if (data.length() == 0) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_email_mobile));
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateMobileNo(Context context, View view, String data) {
        if (data.length() == 0) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_mobileno));
            return false;
        } else if (data.length() < 10) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_valid_mobileno));
            return false;
        } else {
            return true;
        }
    }

    public static boolean cinValidation(String cinval) {
        try {
            if (cinval.length() >= 21) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean validateEmailAndMobileNo(Context context, View view, String data) {
        if (data.length() == 0) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_email_mobile));
            return false;
        } else if (data.length() < 10) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_valid_email_mobile));
            return false;
        } else {
            return true;
        }
    }

    public static boolean validatePassword(Context context, View view, String data) {
        if (data.length() == 0) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_password));
            return false;
        } else if (data.length() < 6) {
            //showSnakbar(view, context.getResources().getString(R.string.err_enter_valid_password));
            return false;
        } else {
            return true;
        }
    }


}
