package com.harris.informationgather;

/**
 * Created by Steve on 9/20/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.harris.informationgather.ButtonsInReport.DateActivity;
import com.harris.informationgather.ButtonsInReport.PeopleActivity;
import com.harris.informationgather.ButtonsInReport.PhotoActivity;
import com.harris.informationgather.ButtonsInReport.TimeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 9/20/2016.
 */

public class EMTActivity  extends AppCompatActivity {

    public static Button incidentNumButton, datePickButton, timePickButton, peopleButton, photoButton;
    public static TextView emt_incident_check, emt_date_check, emt_time_check, emt_ppl_check, emt_photo_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emtpanel);

        incidentNumButton = (Button) findViewById(R.id.emt_incident_b);
        datePickButton = (Button) findViewById(R.id. emt_date_b);
        timePickButton = (Button) findViewById(R.id. emt_time_b);
        peopleButton = (Button) findViewById(R.id. emt_patinfo_b);
        photoButton = (Button) findViewById(R.id. emt_photo_b);

        emt_incident_check = (TextView) findViewById(R.id.emt_incident_check);
        emt_date_check = (TextView) findViewById(R.id.emt_date_check);
        emt_time_check = (TextView) findViewById(R.id.emt_time_check);
        emt_ppl_check = (TextView) findViewById(R.id.emt_ppl_check);
        emt_photo_check = (TextView) findViewById(R.id.emt_photo_check);


        incidentNumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                incidentNumButton.setText("2016000001");
                incidentNumButton.setClickable(false);
                emt_incident_check.setVisibility(View.VISIBLE);
                incidentNumButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            }
        });

        datePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DateActivity.class);
                myIntent.putExtra("caller", "EMT");
                startActivityForResult(myIntent, 0);
                emt_date_check.setVisibility(View.VISIBLE);
            }
        });

        timePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TimeActivity.class);
                myIntent.putExtra("caller", "EMT");
                startActivityForResult(myIntent, 0);
                emt_time_check.setVisibility(View.VISIBLE);
            }
        });

        peopleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PeopleActivity.class);
                myIntent.putExtra("caller", "EMT");
                startActivityForResult(myIntent, 0);
                emt_ppl_check.setVisibility(View.VISIBLE);
            }
        });

        photoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PhotoActivity.class);
                myIntent.putExtra("caller", "EMT");
                startActivityForResult(myIntent, 0);
                emt_photo_check.setVisibility(View.VISIBLE);
            }
        });
    }
}
