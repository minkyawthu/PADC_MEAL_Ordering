package com.app.mkt.padc_meal_ordering.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mkt on 8/28/2016.
 */
public class MealVO {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("img_url")
    private String image;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private int price;

    @SerializedName("ingredients")
    private String [] ingredients;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}
