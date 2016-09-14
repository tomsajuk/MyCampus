package com.ait_pro.tsk.mycampus;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by TSK on 23-08-2016.
 */
public class orderAct extends AppCompatActivity {

    ArrayList<Food> brought = new ArrayList<>();
    private String item;
    private String price;
    private double totalCost = 0.00;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodmenu);

        final ArrayList<Food> dishes = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("fooditem.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int check = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                check++;
                if (check % 2 == 1) {
                    item = mLine;
                }
                if (check % 2 == 0) {
                    price = mLine;
                    dishes.add(new Food(item, price));
                }


            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                }
            }
        }

        FoodAdapter adapter = new FoodAdapter(orderAct.this, dishes);
        ListView listView = (ListView) findViewById(R.id.menu_list);
        if (listView != null)
            listView.setAdapter(adapter);

        Button checkOut = (Button) findViewById(R.id.checkOut);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOut();
            }
        });


    }

    public void order(View view) {
        LinearLayout vwParentRow = (LinearLayout) view.getParent();

        TextView orderFood = (TextView) vwParentRow.getChildAt(0);
        TextView costFood = (TextView) vwParentRow.getChildAt(1);
        item = (String) orderFood.getText();
        price = (String) costFood.getText();

        brought.add(new Food(item, price));

        double temp = Double.valueOf(price);
        totalCost += temp;

        vwParentRow.setBackgroundColor(Color.RED);
        vwParentRow.refreshDrawableState();
    }

    public void checkOut() {

        setContentView(R.layout.bill);
        FoodAdapter adapter = new FoodAdapter(orderAct.this, brought);
        ListView listView = (ListView) findViewById(R.id.bill_list);
        if (listView != null)
            listView.setAdapter(adapter);

        TextView cost = (TextView) findViewById(R.id.cost);
        String temp = totalCost + " ₹ ";
        cost.setText(temp);

        Button order = (Button) findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Order Will Be Sent. Cost = " + totalCost;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }



}
