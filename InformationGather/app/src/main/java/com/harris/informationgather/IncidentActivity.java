package com.harris.informationgather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 9/20/2016.
 */

public class IncidentActivity  extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_incident);

            Button next = (Button) findViewById(R.id.button4);
            final Spinner temp = (Spinner) findViewById(R.id.spinner);
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LoginActivity.selectionid == 0) {
                        Intent myIntent = new Intent(view.getContext(), PoliceActivity.class);
                        startActivityForResult(myIntent, 0);
                    }
                    else if (LoginActivity.selectionid == 1) {
                        Intent myIntent = new Intent(view.getContext(), FireActivity.class);
                        startActivityForResult(myIntent, 0);
                    }
                    else if (LoginActivity.selectionid == 2) {
                        Intent myIntent = new Intent(view.getContext(), PoliceActivity.class);
                        startActivityForResult(myIntent, 0);
                    }
                }
            });
        }
}