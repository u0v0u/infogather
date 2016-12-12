package com.harris.informationgather;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.harris.informationgather.Data.IncidentE;
import com.harris.informationgather.Data.IncidentP;
import com.harris.informationgather.Data.SigninItem;
import com.harris.informationgather.Data.TodoItem;
import com.harris.informationgather.Helper.DBhelper;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncContext;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.ColumnDataType;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.MobileServiceLocalStoreException;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.SQLiteLocalStore;
import com.microsoft.windowsazure.mobileservices.table.sync.synchandler.SimpleSyncHandler;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Created by Steve on 9/20/2016.
 */

public class IncidentActivity extends AppCompatActivity {

    private int backButtonCount;
    private Button startPanel, startArchive;
    private TextView tv1;

    private MobileServiceClient mClient;
    private MobileServiceTable<SigninItem> STable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);

        backButtonCount = 0;
        startPanel = (Button) findViewById(R.id.button4);
        startArchive = (Button) findViewById(R.id.button3);
        tv1 = (TextView) findViewById(R.id.textView4);
        tv1.setText("Welcome " + LoginActivity.msiItem.Username + "!");

        if (LoginActivity.msiItem.type == 0) {
            this.setTitle("Police");
        } else if (LoginActivity.msiItem.type == 1) {
            this.setTitle("Fire");
        } else if (LoginActivity.msiItem.type == 2) {
            this.setTitle("EMT");
        }

        startPanel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (LoginActivity.msiItem.type == 0) {
                    Intent myIntent = new Intent(view.getContext(), PoliceActivity.class);
                    myIntent.putExtra("caller","");
                    startActivityForResult(myIntent, 0);
                } else if (LoginActivity.msiItem.type == 1) {
                    Intent myIntent = new Intent(view.getContext(), FireActivity.class);
                    myIntent.putExtra("caller","");
                    startActivityForResult(myIntent, 0);
                } else if (LoginActivity.msiItem.type == 2) {
                    Intent myIntent = new Intent(view.getContext(), EMTActivity.class);
                    myIntent.putExtra("caller","");
                    startActivityForResult(myIntent, 0);
                }
            }
        });
        startArchive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (LoginActivity.msiItem.type == 0) {
                    Intent myIntent = new Intent(view.getContext(), PoliceArchiveActivity.class);
                    startActivityForResult(myIntent, 0);
                } else if (LoginActivity.msiItem.type == 1) {
                    Intent myIntent = new Intent(view.getContext(), FireActivity.class);
                    startActivityForResult(myIntent, 0);
                } else if (LoginActivity.msiItem.type == 2) {
                    Intent myIntent = new Intent(view.getContext(), EMTActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }
}