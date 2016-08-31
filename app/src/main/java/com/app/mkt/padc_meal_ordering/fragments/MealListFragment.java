package com.app.mkt.padc_meal_ordering.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.mkt.padc_meal_ordering.R;
import com.app.mkt.padc_meal_ordering.adapter.MealOrderListAdapter;
import com.app.mkt.padc_meal_ordering.controllers.ControllerMealOrderItem;
import com.app.mkt.padc_meal_ordering.data.model.MealOrderModel;
import com.app.mkt.padc_meal_ordering.data.vos.MealVO;
import com.app.mkt.padc_meal_ordering.events.DataEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * A placeholder fragment containing a simple view.
 */
public class MealListFragment extends Fragment {

    @BindView(R.id.rv_mealOrder)
    RecyclerView rvMealOrder;

    private MealOrderListAdapter mealOrderListAdapter;
    private ControllerMealOrderItem mController;

    public MealListFragment() {
    }

    public static Fragment newInstance() {
        Fragment fragment = new MealListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mController = (ControllerMealOrderItem) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mealOrderListAdapter = new MealOrderListAdapter(null, mController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_list, container, false);
        ButterKnife.bind(this, view);

        MealOrderModel.getInstance().loadMealOrder();

        rvMealOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMealOrder.setAdapter(mealOrderListAdapter);

        return view;
    }

    public void onEventMainThread(DataEvent.MealOrderDataLoadedEvent event) {
        String extra = event.getMessage();
        Toast.makeText(getContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();

        List<MealVO> mealOrderList = event.getMealVOList();
        mealOrderListAdapter.setData(mealOrderList);

    }
}
