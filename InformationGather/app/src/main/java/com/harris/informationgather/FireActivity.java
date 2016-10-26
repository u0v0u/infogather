package com.harris.informationgather;

/**
 * Created by Steve on 9/20/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.harris.informationgather.ButtonsInReport.AudioActivity;
import com.harris.informationgather.ButtonsInReport.DateActivity;
import com.harris.informationgather.ButtonsInReport.EvaActivity;
import com.harris.informationgather.ButtonsInReport.IActionActivity;
import com.harris.informationgather.ButtonsInReport.PeopleActivity;
import com.harris.informationgather.ButtonsInReport.PhotoActivity;
import com.harris.informationgather.ButtonsInReport.RActionActivity;
import com.harris.informationgather.ButtonsInReport.TimeActivity;

import java.util.Calendar;

/**
 * Created by Steve on 9/20/2016.
 */

public class FireActivity  extends AppCompatActivity {

    public static Button incidentNumButton, datePickButton, timePickButton, peopleButton, photoButton, audioButton,
            iActionButton, rActionButton, evaButton;
    public static TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firepanel);

        datePickButton = (Button) findViewById(R.id.button11);
        timePickButton = (Button) findViewById(R.id.button23);
        incidentNumButton = (Button) findViewById(R.id.button14);
        peopleButton = (Button) findViewById(R.id.button24);
        photoButton = (Button) findViewById(R.id.button25);
        audioButton = (Button) findViewById(R.id.button26);
        iActionButton = (Button) findViewById(R.id.button27);
        rActionButton = (Button) findViewById(R.id.button28);
        evaButton = (Button) findViewById(R.id.button15);


        tv1 = (TextView) findViewById(R.id.textView6);
        tv2 = (TextView) findViewById(R.id.textView5);
        tv3 = (TextView) findViewById(R.id.textView7);
        tv4 = (TextView) findViewById(R.id.textView8);
        tv5 = (TextView) findViewById(R.id.textView11);
        tv6 = (TextView) findViewById(R.id.textView12);
        tv7 = (TextView) findViewById(R.id.textView14);
        tv8 = (TextView) findViewById(R.id.textView16);
        tv9 = (TextView) findViewById(R.id.textView17);

        incidentNumButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                incidentNumButton.setText("2016000001");
                incidentNumButton.setClickable(false);
                incidentNumButton.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                tv1.setVisibility(View.VISIBLE);
            }
        });

        datePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DateActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        timePickButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TimeActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        peopleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PeopleActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        photoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PhotoActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AudioActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        iActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), IActionActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        rActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RActionActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });

        evaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), EvaActivity.class);
                myIntent.putExtra("caller", "Fire");
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
