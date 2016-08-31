package com.app.mkt.padc_meal_ordering;

import android.app.Application;
import android.content.Context;

/**
 * Created by mkt on 8/28/2016.
 */
public class MealOrderingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
