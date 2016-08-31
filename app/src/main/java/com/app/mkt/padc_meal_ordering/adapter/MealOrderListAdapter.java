package com.app.mkt.padc_meal_ordering.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.mkt.padc_meal_ordering.MealOrderingApp;
import com.app.mkt.padc_meal_ordering.R;
import com.app.mkt.padc_meal_ordering.controllers.ControllerMealOrderItem;
import com.app.mkt.padc_meal_ordering.data.vos.MealVO;
import com.app.mkt.padc_meal_ordering.views.MealOrderViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkt on 8/29/2016.
 */
public class MealOrderListAdapter extends RecyclerView.Adapter<MealOrderViewHolder>{

    private List<MealVO> mealOrderList;
    private LayoutInflater mInflater;
    private ControllerMealOrderItem mController;

    public MealOrderListAdapter(List<MealVO> mealOrderList, ControllerMealOrderItem controllerMealOrderItem) {
        if (mealOrderList == null) {
            this.mealOrderList = new ArrayList<MealVO>();
        } else {
            this.mealOrderList = mealOrderList;
        }
        mInflater = LayoutInflater.from(MealOrderingApp.getContext());
        this.mController = controllerMealOrderItem;
    }

    public void setData(List<MealVO> mealOrderList) {
        this.mealOrderList = mealOrderList;
        notifyDataSetChanged();
    }

    @Override
    public MealOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_item_meal, parent, false);

        return new MealOrderViewHolder(view, mController);
    }

    @Override
    public void onBindViewHolder(MealOrderViewHolder holder, int position) {
        holder.bindData(mealOrderList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealOrderList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
