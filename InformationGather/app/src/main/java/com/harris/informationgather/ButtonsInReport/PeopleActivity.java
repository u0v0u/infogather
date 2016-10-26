package com.harris.informationgather.ButtonsInReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.harris.informationgather.FireActivity;
import com.harris.informationgather.R;

/**
 * Created by Steve on 10/9/2016.
 */

public class PeopleActivity extends AppCompatActivity {

    private Button addPPL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_people);

        addPPL = (Button) findViewById(R.id.button_addpeople);

        addPPL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.subactivity_people_add);
            }
        });
    }
}
