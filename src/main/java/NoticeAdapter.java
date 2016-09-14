package com.ait_pro.tsk.mycampus;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TSK on 25-08-2016.
 */
public class NoticeAdapter extends ArrayAdapter<Notice> {

    public NoticeAdapter(Activity context, ArrayList<Notice> notices) {
        super(context, 0, notices);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.notice, parent, false);
        }


        Notice currentnotice = getItem(position);

        TextView heading = (TextView) listItemView.findViewById(R.id.head);
        heading.setText(currentnotice.getHeading());

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(currentnotice.getDescription());

        TextView issue = (TextView) listItemView.findViewById(R.id.issued);
        issue.setText(currentnotice.getIssued());

        return listItemView;
    }
}
