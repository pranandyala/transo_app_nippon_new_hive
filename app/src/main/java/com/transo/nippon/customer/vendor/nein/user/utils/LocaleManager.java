package com.transo.nippon.customer.vendor.nein.user.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Locale;

/**
 * The type Locale manager.
 */
public class LocaleManager {

    /**
     * The constant LANGUAGE_ENGLISH.
     */
    private static final String LANGUAGE_ENGLISH = "en";
    /**
     * The constant LANGUAGE_KANNADA.
     */
    public static final String LANGUAGE_KANNADA = "kn";
    private static final String LANGUAGE_KEY = "language_key";

    /**
     * Sets locale.
     *
     * @param c the c
     * @return the locale
     */
    static Context setLocale(Context c) {
        return updateResources(c, getLanguage(c));
    }

    /**
     * Sets new locale.
     *
     * @param c        the c
     * @param language the language
     * @return the new locale
     */
    public static Context setNewLocale(Context c, String language) {
        persistLanguage(c, language);
        return updateResources(c, language);
    }

    /**
     * Gets language.
     *
     * @param c the c
     * @return the language
     */
    private static String getLanguage(Context c) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
        return prefs.getString(LANGUAGE_KEY, LANGUAGE_ENGLISH);
    }

    @SuppressLint("ApplySharedPref")
    private static void persistLanguage(Context c, String language) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
        // use commit() instead of apply(), because sometimes we kill the application process immediately
        // which will prevent apply() to finish
        prefs.edit().putString(LANGUAGE_KEY, language).commit();
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    /**
     * Gets locale.
     *
     * @param res the res
     * @return the locale
     */
    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }


}