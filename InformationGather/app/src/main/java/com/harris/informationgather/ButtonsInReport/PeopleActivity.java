package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.harris.informationgather.FireActivity;
import com.harris.informationgather.R;

/**
 * Created by myiee on 10/9/2016.
 */

public class PeopleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_datepicker);

        Button datePickClickCon = (Button) findViewById(R.id.button29);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        datePickClickCon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FireActivity.datePickButton.setText(datePicker.getYear() + "." + datePicker.getMonth() + "." + datePicker.getDayOfMonth());
                FireActivity.tv2.setVisibility(View.VISIBLE);
                PeopleActivity.super.onBackPressed();
            }
        });
    }
}
