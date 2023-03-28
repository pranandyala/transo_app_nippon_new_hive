package com.transo.nippon.customer.vendor.nein.user.utils;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/*
Geocode Intent Service to convert Latlng to Address
 */
public class GeocodeAddressIntentService extends IntentService {

    private static final String TAG = "GEO_ADDY_SERVICE";
    protected ResultReceiver resultReceiver;

    public GeocodeAddressIntentService() {
        super("GeocodeAddressIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG, "onHandleIntent");
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String errorMessage = "";
        List<Address> addresses = null;

        int fetchType = intent.getIntExtra(AppUtils.FETCH_TYPE_EXTRA, 0);
        Log.e(TAG, "fetchType == " + fetchType);

        if (fetchType == AppUtils.USE_ADDRESS_NAME) {
            String name = intent.getStringExtra(AppUtils.LOCATION_NAME_DATA_EXTRA);
            try {
                addresses = geocoder.getFromLocationName(name, 1);
            } catch (IOException e) {
                errorMessage = "Service not available";
                Log.e(TAG, errorMessage, e);
            }
        } else if (fetchType == AppUtils.USE_ADDRESS_LOCATION) {
            double latitude = intent.getDoubleExtra(AppUtils.LOCATION_LATITUDE_DATA_EXTRA, 0);
            double longitude = intent.getDoubleExtra(AppUtils.LOCATION_LONGITUDE_DATA_EXTRA, 0);

            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
            } catch (IOException ioException) {
                errorMessage = "Service Not Available";
                Log.e(TAG, errorMessage, ioException);
            } catch (IllegalArgumentException illegalArgumentException) {
                errorMessage = "Invalid Latitude or Longitude Used";
                Log.e(TAG, errorMessage + ". " +
                        "Latitude = " + latitude + ", Longitude = " +
                        longitude, illegalArgumentException);
            }
        } else {
            errorMessage = "Unknown Type";
            Log.e(TAG, errorMessage);
        }

        resultReceiver = intent.getParcelableExtra(AppUtils.RECEIVER);
        if (addresses == null || addresses.size() == 0) {
            if (errorMessage.isEmpty()) {
                errorMessage = "Not Found";
                Log.e(TAG, errorMessage);
            }
            deliverResultToReceiver(AppUtils.FAILURE_RESULT, errorMessage, null);
        } else {
            for (Address address : addresses) {
                String outputAddress = "";
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    outputAddress += " --- " + address.getAddressLine(i);
                }
                Log.e(TAG, outputAddress);
            }
            Address address = addresses.get(0);


            ArrayList<String> addressFragments = new ArrayList<>();

            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                addressFragments.add(address.getAddressLine(i));
            }

            System.out.println("addrss " + address);
            Log.i(TAG, "Address Found");
            deliverResultToReceiver(AppUtils.SUCCESS_RESULT,
                    TextUtils.join(System.getProperty("line.separator"),
                            addressFragments), address);


        }
    }

    private void deliverResultToReceiver(int resultCode, String message, Address address) {
        try {
            message = address.getAddressLine(0);
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (address != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AppUtils.RESULT_ADDRESS, address);
            bundle.putString(AppUtils.RESULT_DATA_KEY, message);
            bundle.putString(AppUtils.RESULT_CITY, address.getLocality());
            bundle.putString(AppUtils.RESULT_STATE, address.getAdminArea());
            bundle.putString(AppUtils.RESULT_PINCODE, address.getPostalCode());
            bundle.putString(AppUtils.RESULT_STREET_ADDRESS, address.getAddressLine(0));
            resultReceiver.send(resultCode, bundle);
        }
    }
}
