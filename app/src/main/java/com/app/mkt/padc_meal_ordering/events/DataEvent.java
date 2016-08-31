package com.app.mkt.padc_meal_ordering.events;

import com.app.mkt.padc_meal_ordering.data.vos.MealVO;

import java.util.List;

/**
 * Created by mkt on 8/29/2016.
 */
public class DataEvent {

    public static class MealOrderDataLoadedEvent {
        private String message;
        private List<MealVO> mealVOList;

        public MealOrderDataLoadedEvent(String message, List<MealVO> mealVOList) {
            this.message = message;
            this.mealVOList = mealVOList;
        }

        public String getMessage() {
            return message;
        }

        public List<MealVO> getMealVOList() {
            return mealVOList;
        }
    }

    public static class FailedMealOrderEvent {

        private String message;

        public FailedMealOrderEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
