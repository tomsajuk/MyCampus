package com.ait_pro.tsk.mycampus;


import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by TSK on 23-08-2016.
 */

public class nightAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave);

        //Spinner to select the year of student
        Spinner yr_spinner = (Spinner) findViewById(R.id.year);
        ArrayAdapter<CharSequence> yr_adapter = ArrayAdapter.createFromResource(this,
                R.array.Year, android.R.layout.simple_spinner_item);
        yr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yr_spinner.setAdapter(yr_adapter);

        //Spinner to select the branch of student
        Spinner branch_spinner = (Spinner) findViewById(R.id.branch);
        ArrayAdapter<CharSequence> br_adapter = ArrayAdapter.createFromResource(this,
                R.array.Branch, android.R.layout.simple_spinner_item);
        br_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch_spinner.setAdapter(br_adapter);

        //Spinner to select the hostel living
        Spinner hos_spinner = (Spinner) findViewById(R.id.hostel);
        ArrayAdapter<CharSequence> hos_adapter = ArrayAdapter.createFromResource(this,
                R.array.Hostel, android.R.layout.simple_spinner_item);
        hos_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hos_spinner.setAdapter(hos_adapter);

        //Spinner to select the Flank if applicable
        Spinner flank_spinner = (Spinner) findViewById(R.id.flank);
        ArrayAdapter<CharSequence> flank_adapter = ArrayAdapter.createFromResource(this,
                R.array.Flank, android.R.layout.simple_spinner_item);
        flank_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flank_spinner.setAdapter(flank_adapter);

        //to show the current date
        TextView fromDate = (TextView) findViewById(R.id.from_date);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        fromDate.setText(getString(R.string.show_date, day, month + 1, year));
        TextView toDate = (TextView) findViewById(R.id.to_date);
        toDate.setText(getString(R.string.show_date, day, month + 1, year));


        Button mail = (Button) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Order Will Be Sent";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    /*protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"thomaskoshy_15132@aitpune.edu.in"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nighout/Leave");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here. HI");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(nightAct.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }*/

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, (android.view.Menu) menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //FragmentDialog to set the date
    public void showFromDatePickerDialog(View v) {
        DialogFragment newFragment = new From_Date();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void showToDatePickerDialog(View v) {
        DialogFragment newFragment = new To_Date();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
