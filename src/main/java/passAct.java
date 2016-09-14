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
import android.support.v4.app.Fragment;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by TSK on 23-08-2016.
 */

public class passAct extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);

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
        TextView date = (TextView) findViewById(R.id.from_date);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        date.setText(getString(R.string.show_date, day, month + 1, year));

        //To set text to  current time
        TextView from_time = (TextView) findViewById(R.id.from_time);
        TextView to_time = (TextView) findViewById(R.id.to_time);
        Calendar fromTime = Calendar.getInstance();
        int hour = fromTime.get(Calendar.HOUR_OF_DAY);
        int minute = fromTime.get(Calendar.MINUTE);
        from_time.setText(getString(R.string.show_time, hour, minute));
        to_time.setText(getString(R.string.show_time, hour, minute));


        //Initializing to send mails for now
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


   /* protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"thomaskoshy_15132@aitpune.edu.in"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nighout/Leave");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I am going out during College hours");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(passAct.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }*/

    //@Override
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


    //Fragment dialog to set the from time
    public void showFromTimePickerDialog(View v) {
        DialogFragment newFragment = new From_Time();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    //Fragment Dialog to set the to time
    public void showToTimePickerDialog(View v) {
        DialogFragment newFragment = new To_Time();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    //FragmentDialog to set the date
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new From_Date();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
