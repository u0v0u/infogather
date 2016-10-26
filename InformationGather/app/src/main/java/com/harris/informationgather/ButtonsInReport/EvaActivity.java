package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.harris.informationgather.R;

/**
 * Created by Shao on 10/25/2016.
 */

public class EvaActivity extends AppCompatActivity {

    private Button eSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_evaluation);

        eSave = (Button) findViewById(R.id.button_evasave);

        eSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EvaActivity.super.onBackPressed();
            }
        });
    }
}
