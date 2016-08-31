package com.app.mkt.padc_meal_ordering.data.retrofit;

import com.app.mkt.padc_meal_ordering.data.response.MealListResponse;
import com.app.mkt.padc_meal_ordering.utils.MealOrderConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mkt on 8/28/2016.
 */
public interface MealOrderApi {

    @FormUrlEncoded
    @POST(MealOrderConstants.API_GET_MEALS_LIST)
    Call<MealListResponse> loadMealOrder(
            @Field(MealOrderConstants.PARAM_ACCESS_TOKEN) String param);

}
