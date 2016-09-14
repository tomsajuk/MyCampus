package com.ait_pro.tsk.mycampus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView night = (TextView) findViewById(R.id.night);
        //if(night != null){
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nightIntent = new Intent(Menu.this, nightAct.class);
                startActivity(nightIntent);
            }
        });
        //}

        TextView outPass = (TextView) findViewById(R.id.pass);
        if (outPass != null) {
            outPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent passIntent = new Intent(Menu.this, passAct.class);
                    startActivity(passIntent);
                }
            });
        }

        TextView notice = (TextView) findViewById(R.id.notice);
        if (outPass != null) {
            notice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent noticeIntent = new Intent(Menu.this, noticeAct.class);
                    startActivity(noticeIntent);
                }
            });
        }

        TextView order = (TextView) findViewById(R.id.order);
        if (outPass != null) {
            order.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent orderIntent = new Intent(Menu.this, orderAct.class);
                    startActivity(orderIntent);
                }
            });
        }

    }
}