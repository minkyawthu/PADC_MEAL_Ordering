package com.app.mkt.padc_meal_ordering.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.mkt.padc_meal_ordering.R;
import com.app.mkt.padc_meal_ordering.controllers.ControllerMealOrderItem;
import com.app.mkt.padc_meal_ordering.data.vos.MealVO;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkt on 8/29/2016.
 */
public class MealOrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_meal)
    ImageView ivMeal;

    @BindView(R.id.tv_meal_name)
    TextView tvMealName;

    @BindView(R.id.tv_price)
    TextView tvMealPrice;


    private ControllerMealOrderItem mController;
    private MealVO mMealOrder;

    public MealOrderViewHolder(View itemView, ControllerMealOrderItem mController) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        this.mController = mController;
    }

    public void bindData(MealVO mealOrder) {
        mMealOrder = mealOrder;

        tvMealName.setText(mealOrder.getName());
        tvMealPrice.setText(Integer.toString(mealOrder.getPrice()));

        Glide.with(ivMeal.getContext())
                .load(mealOrder.getImage())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivMeal);

    }

    @Override
    public void onClick(View view) {
        mController.onTapMealOrder(mMealOrder);
    }
}
