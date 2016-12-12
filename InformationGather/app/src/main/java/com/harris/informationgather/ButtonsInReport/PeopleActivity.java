package com.harris.informationgather.ButtonsInReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.harris.informationgather.FireActivity;
import com.harris.informationgather.PoliceActivity;
import com.harris.informationgather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 10/9/2016.
 */

public class PeopleActivity extends AppCompatActivity {

    private Button addPPL, save;
    public static ListView pplLV;
    public static String caller;
    public static ArrayAdapter<String> adapter;
    public static List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_people);
        caller = getIntent().getStringExtra("caller");
        addPPL = (Button) findViewById(R.id.button_addpeople);
        save = (Button) findViewById(R.id.button_peoplesave);
        pplLV = (ListView) findViewById(R.id.pplLV);
        items = new ArrayList<String>();

        switch (caller) {
            case "Police":
                if (PoliceActivity.peopleList != null) {
                    for (int i = 0; i < PoliceActivity.peopleList.size(); i++) {
                        items.add(PoliceActivity.peopleList.get(i).name);
                    }
                }
        }
        if (items != null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            pplLV.setAdapter(adapter);
        }

        addPPL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PplAddActivity.class);
                myIntent.putExtra("caller", caller);
                startActivityForResult(myIntent, 0);

                PeopleActivity.this.finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PeopleActivity.this.finish();
                PeopleActivity.super.onBackPressed();
            }
        });
    }
}
