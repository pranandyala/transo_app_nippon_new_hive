package com.transo.nippon.customer.vendor.nein.user.utils;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Deepak on 2/25/2016.
 * Volley Callback
 */
public interface IResult {
     void notifySuccess(String requestType, JSONObject response);
     void notifyError(String requestType, VolleyError error);
}
