package com.app.mkt.padc_meal_ordering.data.retrofit;

import com.app.mkt.padc_meal_ordering.data.model.MealOrderModel;
import com.app.mkt.padc_meal_ordering.data.response.MealListResponse;
import com.app.mkt.padc_meal_ordering.events.DataEvent;
import com.app.mkt.padc_meal_ordering.utils.CommonInstances;
import com.app.mkt.padc_meal_ordering.utils.MealOrderConstants;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mkt on 8/29/2016.
 */
public class RetrofitDataAgent implements MealOrderAgent {

    private static RetrofitDataAgent objInstance;

    private final MealOrderApi theApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MealOrderConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(MealOrderApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }


    @Override
    public void loadMealOrder() {
        Call<MealListResponse> loadMealOrderCall = theApi.loadMealOrder(MealOrderConstants.ACCESS_TOKEN);
        loadMealOrderCall.enqueue(new Callback<MealListResponse>() {
            @Override
            public void onResponse(Call<MealListResponse> call, Response<MealListResponse> response) {
                MealListResponse mealListResponse = response.body();
                if (mealListResponse == null) {
                    DataEvent.FailedMealOrderEvent event = new DataEvent.FailedMealOrderEvent(mealListResponse.getMessage());
                    EventBus.getDefault().post(event);

                } else {
                    DataEvent.MealOrderDataLoadedEvent event = new DataEvent.MealOrderDataLoadedEvent(mealListResponse.getMessage(), mealListResponse.getMealList());
                    EventBus.getDefault().post(event);
                    MealOrderModel.getInstance().notifyMealList(mealListResponse.getMealList());
                }
            }

            @Override
            public void onFailure(Call<MealListResponse> call, Throwable t) {
                DataEvent.FailedMealOrderEvent event = new DataEvent.FailedMealOrderEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });

    }
}
