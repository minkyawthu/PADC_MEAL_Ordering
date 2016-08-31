package com.app.mkt.padc_meal_ordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.mkt.padc_meal_ordering.MealOrderingApp;
import com.app.mkt.padc_meal_ordering.R;
import com.app.mkt.padc_meal_ordering.data.model.MealOrderModel;
import com.app.mkt.padc_meal_ordering.data.vos.MealVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mkt on 8/31/2016.
 */
public class MealDetailActivity extends AppCompatActivity {

    private static final String IE_MEAL_ID = "IE_MEAL_ID";
    private static final String IE_MEAL_NAME = "IE_MEAL_NAME";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.iv_meal)
    ImageView ivMeal;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_meal_description)
    TextView tvDesc;

    @BindView(R.id.tv_ingredients)
    TextView tvIngredient;

    public static Intent newIntent(int id, String mealName) {
        Intent intent = new Intent(MealOrderingApp.getContext(), MealDetailActivity.class);
        intent.putExtra(IE_MEAL_ID, id);
        intent.putExtra(IE_MEAL_NAME, mealName);
        return intent;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_detail);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        int id = getIntent().getIntExtra(IE_MEAL_ID, 0);
        String title = getIntent().getStringExtra(IE_MEAL_NAME);
        actionBar.setTitle(title);

        bindData(id);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bindData(int id) {
        MealVO meal = MealOrderModel.getInstance().getMealData(id);
        if (meal != null) {
            tvPrice.setText(Integer.toString(meal.getPrice()));
            tvDesc.setText(meal.getDescription());

            String[] ingredient = meal.getIngredients();
            String concatIngredients = TextUtils.join("\n", ingredient);
            tvIngredient.setText(concatIngredients);

        }
    }
}
