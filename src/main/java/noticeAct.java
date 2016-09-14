package com.ait_pro.tsk.mycampus;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by TSK on 23-08-2016.
 */
public class noticeAct extends AppCompatActivity {

    private String header;
    private String description;
    private String issued;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_list);

        final ArrayList<Notice> notices = new ArrayList<>();


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("notices.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int check = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                check++;
                if (check % 3 == 1) {
                    header = mLine;
                }
                if (check % 3 == 2) {
                    description = mLine;
                }
                if (check % 3 == 0) {
                    issued = mLine;
                    notices.add(new Notice(header, description, issued));
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

        NoticeAdapter adapter = new NoticeAdapter(noticeAct.this, notices);
        ListView listView = (ListView) findViewById(R.id.notice_list);
        if (listView != null)
            listView.setAdapter(adapter);



    }


}
