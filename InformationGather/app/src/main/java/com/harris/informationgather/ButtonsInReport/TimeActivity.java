package com.harris.informationgather.ButtonsInReport;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.harris.informationgather.EMTActivity;
import com.harris.informationgather.FireActivity;
import com.harris.informationgather.PoliceActivity;
import com.harris.informationgather.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by myiee on 10/9/2016.
 */
@TargetApi(Build.VERSION_CODES.M)
public class TimeActivity extends AppCompatActivity {

    private SimpleDateFormat simpleDateFormat;
    private String time, caller, pickedTime;
    private Calendar calander;
    private Button timePickerClickCon, timeGetCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_timepicker);

        caller = getIntent().getStringExtra("caller");

        timePickerClickCon = (Button) findViewById(R.id.button13);
        timeGetCurrent = (Button) findViewById(R.id.button12);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        calander = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        time = simpleDateFormat.format(calander.getTime());

        if (caller.equals("Police")) {
            timePickerClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    pickedTime = timePicker.getHour() + ":" + timePicker.getMinute();
                    PoliceActivity.timePickButton.setText(pickedTime);
                    PoliceActivity.time = pickedTime;
                    TimeActivity.super.onBackPressed();
                }
            });
            timeGetCurrent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PoliceActivity.timePickButton.setText(time);
                    PoliceActivity.time = time;
                    TimeActivity.super.onBackPressed();
                }
            });
        } else if (caller.equals("Fire")) {
            timePickerClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    pickedTime = timePicker.getHour() + ":" + timePicker.getMinute();
                    FireActivity.timePickButton.setText(pickedTime);
                    //FireActivity.time = pickedTime;
                    TimeActivity.super.onBackPressed();
                }
            });
            timeGetCurrent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FireActivity.timePickButton.setText(time);
                    //FireActivity.time = time;
                    TimeActivity.super.onBackPressed();
                }
            });
        } else if (caller.equals("EMT")) {
            timePickerClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    pickedTime = timePicker.getHour() + ":" + timePicker.getMinute();
                    EMTActivity.timePickButton.setText(pickedTime);
                    //EMTActivity.time = pickedTime;
                    TimeActivity.super.onBackPressed();
                }
            });
            timeGetCurrent.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EMTActivity.timePickButton.setText(time);
                    //EMTActivity.time = time;
                    TimeActivity.super.onBackPressed();
                }
            });
        }
    }
}
