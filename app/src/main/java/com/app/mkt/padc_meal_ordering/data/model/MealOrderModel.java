package com.app.mkt.padc_meal_ordering.data.model;

import android.support.v7.widget.LinearSmoothScroller;

import com.app.mkt.padc_meal_ordering.data.retrofit.MealOrderAgent;
import com.app.mkt.padc_meal_ordering.data.retrofit.RetrofitDataAgent;
import com.app.mkt.padc_meal_ordering.data.vos.MealVO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mkt on 8/29/2016.
 */
public class MealOrderModel {

    private static MealOrderModel objInstance;

    private MealOrderAgent dataAgent;
    private List<MealVO> mMealList;

    public MealOrderModel() {
        mMealList = new ArrayList<>();
        dataAgent = RetrofitDataAgent.getInstance();

    }

    public static MealOrderModel getInstance() {
        if (objInstance == null) {
            objInstance = new MealOrderModel();
        }
        return objInstance;
    }

    public void loadMealOrder() {
        dataAgent.loadMealOrder();
    }

    public void notifyMealList(List<MealVO> mealList) {
        mMealList = mealList;
    }

    public MealVO getMealData(int id) {
        for (MealVO meal : mMealList) {
            if (meal.getId() == id)
                return meal;
        }

        return null;
    }
}
