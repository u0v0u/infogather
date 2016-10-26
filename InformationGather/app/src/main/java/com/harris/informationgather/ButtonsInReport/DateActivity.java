package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.harris.informationgather.EMTActivity;
import com.harris.informationgather.FireActivity;
import com.harris.informationgather.PoliceActivity;
import com.harris.informationgather.R;

/**
 * Created by Steve on 10/9/2016.
 */

public class DateActivity extends AppCompatActivity {

    private String caller;
    private Button datePickClickCon;
    public static DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_datepicker);

        caller = getIntent().getStringExtra("caller");

        datePickClickCon = (Button) findViewById(R.id.button29);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        if (caller.equals("Police")) {
            datePickClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PoliceActivity.datePickButton.setText(datePicker.getYear() + "." + datePicker.getMonth() + "." + datePicker.getDayOfMonth());
                    //EMTActivity.tv2.setVisibility(View.VISIBLE);
                    DateActivity.super.onBackPressed();
                }
            });
        } else if (caller.equals("Fire")) {
            datePickClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FireActivity.datePickButton.setText(datePicker.getYear() + "." + datePicker.getMonth() + "." + datePicker.getDayOfMonth());
                    //EMTActivity.tv2.setVisibility(View.VISIBLE);
                    DateActivity.super.onBackPressed();
                }
            });
        } else if (caller.equals("EMT")) {
            datePickClickCon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EMTActivity.datePickButton.setText(datePicker.getYear() + "." + datePicker.getMonth() + "." + datePicker.getDayOfMonth());
                    //EMTActivity.tv2.setVisibility(View.VISIBLE);
                    DateActivity.super.onBackPressed();
                }
            });
        }
    }
}
