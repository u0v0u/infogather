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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 9/20/2016.
 */

public class PoliceActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policepanel);

        Button next = (Button) findViewById(R.id.button7);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                findViewById(R.id.datePicker2).setVisibility(View.VISIBLE);
            }
        });
    }
}
