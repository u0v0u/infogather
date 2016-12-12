package com.harris.informationgather;

/**
 * Created by Steve on 9/20/2016.
 */

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.harris.informationgather.ButtonsInReport.AudioActivity;
import com.harris.informationgather.ButtonsInReport.DateActivity;
import com.harris.informationgather.ButtonsInReport.IActionActivity;
import com.harris.informationgather.ButtonsInReport.PeopleActivity;
import com.harris.informationgather.ButtonsInReport.PhotoActivity;
import com.harris.informationgather.ButtonsInReport.PplAddActivity;
import com.harris.informationgather.ButtonsInReport.TimeActivity;
import com.harris.informationgather.Data.IncidentP;
import com.harris.informationgather.Data.PeopleData;
import com.harris.informationgather.Data.SigninItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Steve on 9/20/2016.
 */

public class PoliceArchiveActivity extends AppCompatActivity {

    private ListView lv;
    public static ArrayAdapter<String> adapter;
    public static List<String> items;
    private List<IncidentP> poArchive;
    private ProgressBar pb1;
    private Context mCon;
    public static IncidentP selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policearchive);
        mCon = this;

        poArchive = new ArrayList<IncidentP>();
        lv = (ListView) findViewById(R.id.palv);
        pb1 = (ProgressBar) findViewById(R.id.progressBar3);
        items = new ArrayList<String>();

        getArchive();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (poArchive != null) {
                    for (int i = 0; i < poArchive.size(); i++) {
                        items.add(poArchive.get(i).getIncidentNum());
                    }
                }

                if(items!=null) {
                    adapter = new ArrayAdapter<String>(mCon, android.R.layout.simple_list_item_1, items);
                    lv.setAdapter(adapter);
                }
                pb1.setVisibility(View.INVISIBLE);
            }
        }, 1500);

        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = poArchive.get(position);
                Intent myIntent = new Intent(view.getContext(), PoliceActivity.class);
                myIntent.putExtra("caller", "archive");
                startActivityForResult(myIntent, 0);
            }
        });;
}


    private void getArchive() {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    poArchive = getArchiveFromMobileServiceTable();
                } catch (final Exception e) {
                }
                return null;
            }
        };
        runAsyncTask(task);
    }

    private List<IncidentP> getArchiveFromMobileServiceTable() throws ExecutionException, InterruptedException {
        return LoginActivity.mClient.getTable(IncidentP.class).select().execute().get();
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
}
