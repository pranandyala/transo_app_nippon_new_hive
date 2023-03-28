package com.transo.nippon.customer.vendor.nein.user.utils;

import android.content.Context;

import com.android.volley.VolleyError;
import com.transo.nippon.customer.vendor.nein.user.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Error {

    public static JSONObject parseVolleyError(VolleyError error) {
        JSONObject data = null;
        try {
            if (error != null && error.networkResponse != null && error.networkResponse.data != null) {
                final String responseBody = new String(error.networkResponse.data, "utf-8");
                data = new JSONObject(responseBody);
                System.out.println("Error data-->" + data);
            }
        } catch (JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static boolean parseVolleyErrorToast(VolleyError error, Context context) {
        JSONObject data = null;
        try {
            if (error != null && error.networkResponse != null && error.networkResponse.data != null) {
                final String responseBody = new String(error.networkResponse.data, "utf-8");
                data = new JSONObject(responseBody);
                System.out.println("Error data-->" + data);
                if (data != null) {
                    if (context != null) {
                        System.out.println("Volley error message-->" + data);
                        if (data.has("message")) {
                            ToastUtils.make(context, data.getString("message"), true);
                        } else {
                            ToastUtils.make(context, context.getResources().getString(R.string.err_server), true);
                        }
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
