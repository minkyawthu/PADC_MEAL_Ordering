package com.app.mkt.padc_meal_ordering.data.response;

import com.app.mkt.padc_meal_ordering.data.vos.MealVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mkt on 8/28/2016.
 */
public class MealListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("meal_list")
    private List<MealVO> mealList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<MealVO> getMealList() {
        return mealList;
    }
}
