package com.transo.nippon.customer.vendor.nein.user.utils;

import android.view.View;
import android.widget.ScrollView;

public class ScrollViewUtils {

    public static void scrollToViewTop(ScrollView scrollView, View childView) {
        try {
            long delay = 100; //delay to let finish with possible modifications to ScrollView
            if (scrollView != null && childView != null)
                scrollView.postDelayed(() -> scrollView.smoothScrollTo(0, childView.getTop()), delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollToViewBottom(ScrollView scrollView, View childView) {
        try {
            long delay = 100; //delay to let finish with possible modifications to ScrollView
            if (scrollView != null && childView != null)
                scrollView.postDelayed(() -> scrollView.smoothScrollTo(0, childView.getBottom()), delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
