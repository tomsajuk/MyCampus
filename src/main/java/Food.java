package com.ait_pro.tsk.mycampus;

/**
 * Created by TSK on 27-08-2016.
 */
public class Food {

    private String dish;
    private String price;

    public Food(String itemName, String money) {

        dish = itemName;
        price = money;
    }

    public String getDish() {
        return dish;
    }

    public String getPrice() {
        return price;
    }
}
