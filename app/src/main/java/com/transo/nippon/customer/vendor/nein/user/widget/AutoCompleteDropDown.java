package com.transo.nippon.customer.vendor.nein.user.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;

/**
 * Created by ezyloads on 8/5/18.
 */

public class AutoCompleteDropDown extends AppCompatAutoCompleteTextView {
    //    implements AdapterView.OnItemClickListener
    private static final int MAX_CLICK_DURATION = 200;
    private long startClickTime;
    private boolean isPopup;

    public AutoCompleteDropDown(Context context) {
        super(context);
//        setOnItemClickListener(this);
    }

    public AutoCompleteDropDown(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
//        setOnItemClickListener(this);
    }

    public AutoCompleteDropDown(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
//        setOnItemClickListener(this);
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction,
                                  Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
           // performFiltering("", 0);
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imm!=null) {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            setKeyListener(null);
            dismissDropDown();
        } else {
            isPopup = false;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (isPopup) {
                dismissDropDown();
            } else {
                requestFocus();
                showDropDown();
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void showDropDown() {
        super.showDropDown();
        isPopup = true;
    }

    @Override
    public void dismissDropDown() {
        super.dismissDropDown();
        isPopup = false;
    }


    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
        } else {
            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        }

    }


    public int getPosition() {
        int mPosition = ListView.INVALID_POSITION;
        return mPosition;
    }

    public void setOnItemSelectedListener(FragmentActivity activity) {
    }
}