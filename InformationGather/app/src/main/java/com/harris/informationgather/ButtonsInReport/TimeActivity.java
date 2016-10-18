package com.harris.informationgather.ButtonsInReport;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import com.harris.informationgather.FireActivity;
import com.harris.informationgather.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by myiee on 10/9/2016.
 */
@TargetApi(Build.VERSION_CODES.M)
public class TimeActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_timepicker);

        SimpleDateFormat simpleDateFormat;
        final String time;
        Calendar calander;
        Button timePickerClickCon = (Button) findViewById(R.id.button13);
        Button timeGetCurrent = (Button) findViewById(R.id.button12);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        calander = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        time = simpleDateFormat.format(calander.getTime());


        timePickerClickCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FireActivity.timePickButton.setText(timePicker.getHour() + ":" + timePicker.getMinute());
                TimeActivity.super.onBackPressed();
            }
        });

        timeGetCurrent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FireActivity.timePickButton.setText(time);
                TimeActivity.super.onBackPressed();
            }
        });
    }
}
