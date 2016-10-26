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

import com.harris.informationgather.ButtonsInReport.AudioActivity;
import com.harris.informationgather.ButtonsInReport.DateActivity;
import com.harris.informationgather.ButtonsInReport.IActionActivity;
import com.harris.informationgather.ButtonsInReport.PeopleActivity;
import com.harris.informationgather.ButtonsInReport.PhotoActivity;
import com.harris.informationgather.ButtonsInReport.TimeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 9/20/2016.
 */

public class PoliceActivity  extends AppCompatActivity {

    public static Button incidentNumButton, datePickButton, timePickButton, peopleButton, photoButton, audioButton, initiButton;
    public static TextView p_incident_check, p_date_check, p_time_check, p_ppl_check, p_photo_check, p_initial_check, p_audio_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policepanel);

        incidentNumButton = (Button) findViewById(R.id.p_incident_b);
        datePickButton = (Button) findViewById(R.id. p_data_b);
        timePickButton = (Button) findViewById(R.id. p_time_b);
        peopleButton = (Button) findViewById(R.id. p_people_b);
        photoButton = (Button) findViewById(R.id. p_photo_b);
        audioButton = (Button) findViewById(R.id. p_audio_b);
        initiButton = (Button) findViewById(R.id. p_initial_b);

        p_incident_check = (TextView) findViewById(R.id.p_incident_check);
        p_date_check = (TextView) findViewById(R.id.p_date_check);
        p_time_check = (TextView) findViewById(R.id.p_time_check);
        p_initial_check = (TextView) findViewById(R.id. p_initial_check);
        p_ppl_check = (TextView) findViewById(R.id.p_ppl_check);
        p_photo_check = (TextView) findViewById(R.id.p_photo_check);
        p_audio_check = (TextView) findViewById(R.id.p_audio_check);

        incidentNumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                incidentNumButton.setText("2016000001");
                incidentNumButton.setClickable(false);
                p_incident_check.setVisibility(View.VISIBLE);
                incidentNumButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            }
        });

        datePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DateActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_date_check.setVisibility(View.VISIBLE);
            }
        });

        timePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TimeActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_time_check.setVisibility(View.VISIBLE);
            }
        });

        initiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), IActionActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_initial_check.setVisibility(View.VISIBLE);
            }
        });

        peopleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PeopleActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_ppl_check.setVisibility(View.VISIBLE);
            }
        });

        photoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PhotoActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_photo_check.setVisibility(View.VISIBLE);
            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AudioActivity.class);
                myIntent.putExtra("caller", "Police");
                startActivityForResult(myIntent, 0);
                p_audio_check.setVisibility(View.VISIBLE);
            }
        });
    }
}
