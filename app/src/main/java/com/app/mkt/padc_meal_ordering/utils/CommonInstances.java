package com.app.mkt.padc_meal_ordering.utils;

import com.google.gson.Gson;

/**
 * Created by mkt on 8/29/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
