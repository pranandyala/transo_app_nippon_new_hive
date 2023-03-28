package com.transo.nippon.customer.vendor.nein.user.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.transo.nippon.customer.vendor.nein.user.constants.Constant;


import org.json.JSONException;
import org.json.JSONObject;

public class PincodeVerification {



    private static boolean exist =false;
    /**
     * The  result callback.
     */
    private static IResult mResultCallback = null;

    public static boolean verify(String postalCode, Context baseContext){
        initVolleyCallback();


        JSONObject object= new JSONObject();
        try {
            object.put("pincode",postalCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //mVolleyService.postDataVolley(Constant.PINCODE_VERIFICATION,Constant.PINCODE_VERIFICATION,object);
        return exist;
    }

    private static void initVolleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject json) {
                Log.d("RESULT", json.toString());

                if (requestType.equals(Constant.GET_AVAILABLE_VEHICLE_TYPES)) {

                    try {

                        if (json.getString("success").equals("exist")) {

                                exist =true;

                        }
                        if (json.getString("success").equals("not_exist")) {

                            exist =false;
                        }
                        System.out.println("json :" + json);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
            @Override
            public void notifyError(String requestType, VolleyError error) {
                error.printStackTrace();
            }
        };


    }
}
