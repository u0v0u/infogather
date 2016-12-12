package com.harris.informationgather.ButtonsInReport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.harris.informationgather.Data.IncidentF;
import com.harris.informationgather.Data.IncidentP;
import com.harris.informationgather.Data.PeopleData;
import com.harris.informationgather.PoliceActivity;
import com.harris.informationgather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myiee on 12/7/2016.
 */

public class PplAddActivity extends AppCompatActivity {
    public static Button clear, save, date;
    private EditText et1, et2, et3, et4;
    private CheckBox cbW, cbC, cbD, cbM, cbF, cbP, cbEP, cbEC, cbED, cbEN;
    private String caller;
    private Spinner sexSpinner;
    private String sex = "", id = "";
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_people_add);
        mContext = this;

        caller = PeopleActivity.caller;
        populate();
    }

    private void populate() {
        et1 = (EditText) findViewById(R.id.editText8);
        et2 = (EditText) findViewById(R.id.editText10);
        et3 = (EditText) findViewById(R.id.editText13);
        et4 = (EditText) findViewById(R.id.editText15);

        cbW = (CheckBox) findViewById(R.id.checkBox);
        cbC = (CheckBox) findViewById(R.id.checkBox2);
        cbD = (CheckBox) findViewById(R.id.checkBox3);
        cbM = (CheckBox) findViewById(R.id.checkBox4);
        cbF = (CheckBox) findViewById(R.id.checkBox5);
        cbP = (CheckBox) findViewById(R.id.checkBox6);
        cbEP = (CheckBox) findViewById(R.id.checkBox9);
        cbEC = (CheckBox) findViewById(R.id.checkBox10);
        cbED = (CheckBox) findViewById(R.id.checkBox12);
        cbEN = (CheckBox) findViewById(R.id.checkBox13);

        clear = (Button) findViewById(R.id.button18);
        save = (Button) findViewById(R.id.button19);
        date = (Button) findViewById(R.id.button16);

        sexSpinner = (Spinner) findViewById(R.id.spinner2);
        List<String> cat = new ArrayList<String>();
        cat.add("Male");
        cat.add("Female");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cat);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(dataAdapter);

        date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), DateActivity.class);
                myIntent.putExtra("caller", "PplAddActivity");
                startActivityForResult(myIntent, 0);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.subactivity_people_add);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String skin = "", eye = "";
                if (cbW.isChecked())
                    skin = skin + "w";
                if (cbC.isChecked())
                    skin = skin + "c";
                if (cbD.isChecked())
                    skin = skin + "d";
                if (cbF.isChecked())
                    skin = skin + "f";
                if (cbM.isChecked())
                    skin = skin + "m";
                if (cbP.isChecked())
                    skin = skin + "p";
                if (cbEC.isChecked())
                    eye = eye + "c";
                if (cbED.isChecked())
                    eye = eye + "d";
                if (cbEN.isChecked())
                    eye = eye + "n";
                if (cbEP.isChecked())
                    eye = eye + "p";

                switch (caller) {
                    case "Police":
                        id = PoliceActivity.inNum;
                }

                PeopleData pplItem = new PeopleData(id, et1.getText().toString(), date.getText().toString(), sexSpinner.getSelectedItem().toString(),
                        skin, eye, et2.getText().toString(), et3.getText().toString(), et4.getText().toString());

                switch (caller) {
                    case "Police":
                        PoliceActivity.peopleList.add(pplItem);
                }

                Intent myIntent = new Intent(view.getContext(), PeopleActivity.class);
                myIntent.putExtra("caller", caller);
                startActivityForResult(myIntent, 0);

                PplAddActivity.this.finish();
            }
        });
    }
}
