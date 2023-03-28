package com.transo.nippon.customer.vendor.nein.user.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMinMaxUtils {

    public static class InputFilterMinMax implements InputFilter {

        private int min, max;

        public InputFilterMinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            StringBuilder builder = new StringBuilder(dest);
            builder.replace(dstart, dend, source
                    .subSequence(start, end).toString());
            if (!builder.toString().matches(
                    "(([1-9]{1})([0-9]{0," + (min - 1) + "})?)?(\\.[0-9]{0," + max + "})?"

            )) {
                if (source.length() == 0)
                    return dest.subSequence(dstart, dend);
                return "";
            }
            return null;
        }
    }
}
