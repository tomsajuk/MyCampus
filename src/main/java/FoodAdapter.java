package com.ait_pro.tsk.mycampus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TSK on 27-08-2016.
 */
public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Activity context, ArrayList<Food> dish) {
        super(context, 0, dish);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.food, parent, false);
        }


        Food currentDish = getItem(position);

        TextView dish = (TextView) listItemView.findViewById(R.id.dish);
        dish.setText(currentDish.getDish());

        TextView money = (TextView) listItemView.findViewById(R.id.price);
        money.setText(currentDish.getPrice());

        return listItemView;
    }
}