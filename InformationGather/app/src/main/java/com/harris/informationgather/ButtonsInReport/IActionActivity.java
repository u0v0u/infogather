package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.harris.informationgather.R;

/**
 * Created by myiee on 10/9/2016.
 */

public class IActionActivity extends AppCompatActivity {

    private Button iSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_iaction);

        iSave = (Button) findViewById(R.id.button_iactionsave);

        iSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IActionActivity.super.onBackPressed();
            }
        });
    }
}
