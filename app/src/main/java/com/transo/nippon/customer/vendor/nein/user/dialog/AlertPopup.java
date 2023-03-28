package com.transo.nippon.customer.vendor.nein.user.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;


import com.transo.nippon.customer.vendor.nein.user.R;


public class AlertPopup extends BaseDialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TAG = "tag";
    private static final String ARG_TITLE = "title";
    private static final String ARG_ICON = "icon";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_BUTTONS = "buttons";
    private static final String TAG = "AlertPopup";
    public static final String ALERT_TITLE_DEFAULT = "Alert";
    public static final int ALERT_ICON_DEFAULT = R.drawable.ic_vector_alerts;

    public static final String BUTTON_OK = "OK";
    public static final String BUTTON_CANCEL = "CANCEL";
    private static final String ARG_EXTRA = "extra";
    // TODO: Rename and change types of parameters
    private int tag, mIconResId;
    private String mMessage, mTitle;
    private String[] mButtons;
    private Bundle mExtra;
    private boolean canDismiss;
    private OnAlertInteractionListener mInteractionListener;

    public AlertPopup() {
        // Required empty public constructor
    }



    public static AlertPopup newInstance(int tag, String title, int icon, String message, String[] buttons) {
        return newInstance(tag, title, icon, message, buttons, null);
    }

    public static AlertPopup newInstance(int tag, String title, int icon, String message, String[] buttons, Bundle extra) {
        AlertPopup fragment = new AlertPopup();
        Bundle args = new Bundle();
        args.putInt(ARG_TAG, tag);
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_ICON, icon);
        args.putString(ARG_MESSAGE, message);
        args.putStringArray(ARG_BUTTONS, buttons);
        args.putBundle(ARG_EXTRA, extra);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (getArguments() != null) {
                tag = getArguments().getInt(ARG_TAG);
                mTitle = getArguments().getString(ARG_TITLE);
                mIconResId = getArguments().getInt(ARG_ICON);
                mMessage = getArguments().getString(ARG_MESSAGE);
                mButtons = getArguments().getStringArray(ARG_BUTTONS);
                mExtra = getArguments().getBundle(ARG_EXTRA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        int width = (getResources().getDisplayMetrics().widthPixels);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return dialog;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_alert, container, false);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnAlertInteractionListener) {
            mInteractionListener = (OnAlertInteractionListener) activity;
        }
    }

    @Override
    public void dismiss() {
        if (canDismiss)
            super.dismiss();
    }


    public interface OnAlertInteractionListener {
        void onAlertInteraction(int tag, boolean isPositive, Bundle extra);
    }
}
