package com.transo.nippon.customer.vendor.nein.user.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;



public class BaseDialogFragment extends DialogFragment {
  //  public VolleyService mVolleyService;
    /**
     * The  result callback.
     */
    //public IResult mResultCallback = null;
    //public PrefUtils pref;

/*
    protected App getApp() {
        if (getActivity() != null) {
            return (App) getActivity().getApplication();
        }
        return null;
    }*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
       // pref = new PrefUtils(getActivity());
        return container;
    }


}
