package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.harris.informationgather.EMTActivity;
import com.harris.informationgather.FireActivity;
import com.harris.informationgather.PoliceActivity;
import com.harris.informationgather.PoliceArchiveActivity;
import com.harris.informationgather.R;

/**
 * Created by myiee on 10/9/2016.
 */

public class IActionActivity extends AppCompatActivity {

    private Button iSave;
    private EditText et1;
    private String caller;
    public static String iaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_iaction);
        caller = getIntent().getStringExtra("caller");
        iSave = (Button) findViewById(R.id.button_iactionsave);
        et1 = (EditText) findViewById(R.id.editText4);

        if (iaText == null) {
            iaText = "";
        } else {
            et1.setText(iaText);
        }

        switch(caller) {
            case "PArchive":
                et1.setText(PoliceActivity.iaction);
        }

        if (caller.equals("Police")) {
        } else if (caller.equals("Fire")) {
        } else if (caller.equals("EMT")) {
        }

        iSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                iaText = et1.getText().toString();
                IActionActivity.super.onBackPressed();
            }
        });
    }
}
