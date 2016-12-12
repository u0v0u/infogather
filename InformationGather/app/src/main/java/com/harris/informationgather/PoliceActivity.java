package com.harris.informationgather;

/**
 * Created by Steve on 9/20/2016.
 */

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.harris.informationgather.Data.IncidentP;
import com.harris.informationgather.Data.PeopleData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Steve on 9/20/2016.
 */

public class PoliceActivity extends AppCompatActivity {

    public static Button incidentNumButton, datePickButton, timePickButton, peopleButton, photoButton, audioButton, initiButton, locationButton, saveButton;
    public static TextView p_incident_check, p_date_check, p_time_check, p_ppl_check, p_photo_check, p_initial_check, p_audio_check;
    private IncidentP policeItem;
    public static String inNum, date, time, iaction, photo, audio, loc;
    private PeopleData people[];
    private double longitude, latitude;
    private Location location;
    public static List<PeopleData> peopleList;
    private String caller="";
    private Context mCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policepanel);
        caller = getIntent().getStringExtra("caller");
        mCon = this;

        if (caller.equals("archive")) {
            populateArchive();
        } else {
            populate();
        }

        peopleList = new ArrayList<PeopleData>();

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    }

    private void populate() {
        incidentNumButton = (Button) findViewById(R.id.p_incident_b);
        datePickButton = (Button) findViewById(R.id.p_data_b);
        timePickButton = (Button) findViewById(R.id.p_time_b);
        peopleButton = (Button) findViewById(R.id.p_people_b);
        photoButton = (Button) findViewById(R.id.p_photo_b);
        audioButton = (Button) findViewById(R.id.p_audio_b);
        initiButton = (Button) findViewById(R.id.p_initial_b);
        locationButton = (Button) findViewById(R.id.p_location_b);
        saveButton = (Button) findViewById(R.id.p_save_b);

        p_incident_check = (TextView) findViewById(R.id.p_incident_check);
        p_date_check = (TextView) findViewById(R.id.p_date_check);
        p_time_check = (TextView) findViewById(R.id.p_time_check);
        p_initial_check = (TextView) findViewById(R.id.p_initial_check);
        p_ppl_check = (TextView) findViewById(R.id.p_ppl_check);
        p_photo_check = (TextView) findViewById(R.id.p_photo_check);
        p_audio_check = (TextView) findViewById(R.id.p_audio_check);

        incidentNumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                inNum = "" + System.currentTimeMillis();
                incidentNumButton.setText(inNum);
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
                myIntent.putExtra("archive", "");
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

        locationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (location != null) {
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    loc = latitude + "," + longitude;
                    locationButton.setText(loc);
                    locationButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                } else {
                    locationButton.setText("Location not Found");
                    locationButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    loc = "";
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IncidentP policeItem = new IncidentP(inNum, date, time, inNum, "", "", IActionActivity.iaText);
                LoginActivity.mClient.getTable(IncidentP.class).insert(policeItem);
                for (int i=0; i<peopleList.size();i++) {
                    LoginActivity.mClient.getTable(PeopleData.class).insert(peopleList.get(i));
                }
                PoliceActivity.super.onBackPressed();
            }
        });
    }

    private void populateArchive() {
        IncidentP p = PoliceArchiveActivity.selectedItem;
        iaction = p.getInitialAction();

        incidentNumButton = (Button) findViewById(R.id.p_incident_b);
        incidentNumButton.setText(p.getIncidentNum());
        incidentNumButton.setClickable(false);

        datePickButton = (Button) findViewById(R.id.p_data_b);
        datePickButton.setText(p.getDate());
        datePickButton.setClickable(false);

        timePickButton = (Button) findViewById(R.id.p_time_b);
        timePickButton.setText(p.getTime());
        timePickButton.setClickable(false);

        peopleButton = (Button) findViewById(R.id.p_people_b);
        peopleButton.setText("view people");

        photoButton = (Button) findViewById(R.id.p_photo_b);
        photoButton.setText("View photo");

        audioButton = (Button) findViewById(R.id.p_audio_b);
        audioButton.setText("view audio");

        initiButton = (Button) findViewById(R.id.p_initial_b);
        initiButton.setText("view");

        locationButton = (Button) findViewById(R.id.p_location_b);

        saveButton = (Button) findViewById(R.id.p_save_b);
        saveButton.setText("go back");

        p_incident_check = (TextView) findViewById(R.id.p_incident_check);
        p_date_check = (TextView) findViewById(R.id.p_date_check);
        p_time_check = (TextView) findViewById(R.id.p_time_check);
        p_initial_check = (TextView) findViewById(R.id.p_initial_check);
        p_ppl_check = (TextView) findViewById(R.id.p_ppl_check);
        p_photo_check = (TextView) findViewById(R.id.p_photo_check);
        p_audio_check = (TextView) findViewById(R.id.p_audio_check);

        initiButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), IActionActivity.class);
                myIntent.putExtra("caller", "PArchive");
                startActivityForResult(myIntent, 0);
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

        locationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PoliceActivity.super.onBackPressed();
            }
        });
    }
}
