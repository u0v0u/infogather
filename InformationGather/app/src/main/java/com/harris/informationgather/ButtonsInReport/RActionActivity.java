package com.harris.informationgather.ButtonsInReport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.harris.informationgather.R;

/**
 * Created by myiee on 10/9/2016.
 */

public class RActionActivity  extends AppCompatActivity {

    private Button rSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_raction);

        rSave = (Button) findViewById(R.id.button_ractionsave);

        rSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RActionActivity.super.onBackPressed();
            }
        });
    }
}
