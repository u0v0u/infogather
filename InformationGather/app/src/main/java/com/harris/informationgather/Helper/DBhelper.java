package com.harris.informationgather.Helper;

import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.harris.informationgather.Data.IncidentE;
import com.harris.informationgather.Data.IncidentF;
import com.harris.informationgather.Data.IncidentP;
import com.harris.informationgather.Data.SigninItem;
import com.harris.informationgather.Data.TempClass;
import com.harris.informationgather.LoginActivity;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.query.Query;
import com.microsoft.windowsazure.mobileservices.table.query.QueryOperations;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncContext;
import com.microsoft.windowsazure.mobileservices.table.sync.MobileServiceSyncTable;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.ColumnDataType;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.MobileServiceLocalStoreException;
import com.microsoft.windowsazure.mobileservices.table.sync.localstore.SQLiteLocalStore;
import com.microsoft.windowsazure.mobileservices.table.sync.synchandler.SimpleSyncHandler;
import com.squareup.okhttp.OkHttpClient;
import com.microsoft.windowsazure.mobileservices.*;

/**
 * Created by Steve on 11/15/2016.
 */

public class DBhelper {

    private MobileServiceTable<IncidentE> EMTTable;
    private MobileServiceTable<IncidentF> FireTable;
    private MobileServiceTable<IncidentP> PoliceTable;
    private MobileServiceTable<TempClass> TempTable;
    private static MobileServiceClient mClient;

    //Offline Sync
    /**
     * Mobile Service Table used to access and Sync data
     */
    //private MobileServiceSyncTable<ToDoItem> mToDoTable;

    private EditText mTextNewToDo;
    private ProgressBar mProgressBar;

    public void dbConnect(String i) {
        mClient = LoginActivity.mClient;
        try {
            // Extend timeout from default of 10s to 20s
            mClient.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });

            switch(i) {
                case "EMT":
                    EMTTable = mClient.getTable(IncidentE.class);
                case "Fire":
                    FireTable = mClient.getTable(IncidentF.class);
                case "Police":
                    PoliceTable = mClient.getTable(IncidentP.class);
                case "try":
                    TempTable = mClient.getTable(TempClass.class);
            }

            // Offline Sync
            //mToDoTable = mClient.getSyncTable("ToDoItem", ToDoItem.class);
            //TempTable = mClient.getSyncTable("TempTable", TempClass.class);

            //Init local storage
            initLocalStore(i).get();

        } catch (Exception e){
            Log.i("_______",e.toString());
        }
    }

    public void updateIncident(final String i, final IncidentP P, final IncidentE E, final IncidentF F) throws ExecutionException, InterruptedException{
        if (mClient == null) {
            return;
        }
        // Insert the item
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    switch(i) {
                        case "EMT":
                            EMTTable.update(E).get();
                        case "Fire":
                            FireTable.update(F).get();
                        case "Police":
                            PoliceTable.update(P).get();
                    }
                } catch (final Exception e) {
                }
                return null;
            }
        };
        runAsyncTask(task);
    }

    public void addIncident(final String i, final IncidentP P, final IncidentE E, final IncidentF F, final TempClass T) throws ExecutionException, InterruptedException {
        if (mClient == null) {
            return;
        }
        // Insert the new item
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    switch(i) {
                        case "EMT":
                            EMTTable.insert(E);
                        case "Fire":
                            FireTable.insert(F);
                        case "Police":
                            PoliceTable.insert(P);
                        case "try":
                            TempTable.insert(T);
                    }
                } catch (final Exception e) {

                }
                return null;
            }
        };
        runAsyncTask(task);
    }

    /**
     * Refresh the list with the items in the Table
     */
    private IncidentE getIncidentE(final String incidentNum) throws ExecutionException, InterruptedException {
        List<IncidentE> results = EMTTable.where().field("incidentNum").eq(incidentNum).execute().get();
        return results.get(0);
    }

    private IncidentF getIncidentF(final String incidentNum) throws ExecutionException, InterruptedException {
        List<IncidentF> results = FireTable.where().field("incidentNum").eq(incidentNum).execute().get();
        return results.get(0);
    }

    private IncidentP getIncidentP(final String incidentNum) throws ExecutionException, InterruptedException {
        List<IncidentP> results = PoliceTable.where().field("incidentNum").eq(incidentNum).execute().get();
        return results.get(0);
    }

    public static String getU(final String in) throws ExecutionException, InterruptedException {
        List<SigninItem> results = mClient.getTable(SigninItem.class).where().field("USERNAME").eq("apple").execute().get();
        return results.get(0).Username;
    }

    /**
     * Refresh the list with the items in the Mobile Service Table
     */

    //Offline Sync
    /**
     * Refresh the list with the items in the Mobile Service Sync Table
     */
    /*private List<ToDoItem> refreshItemsFromMobileServiceTableSyncTable() throws ExecutionException, InterruptedException {
        //sync the data
        sync().get();
        Query query = QueryOperations.field("complete").
                eq(val(false));
        return mToDoTable.read(query).get();
    }*/

    /**
     * Initialize local storage
     * @return
     * @throws MobileServiceLocalStoreException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private AsyncTask<Void, Void, Void> initLocalStore(final String i) throws MobileServiceLocalStoreException, ExecutionException, InterruptedException {

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    MobileServiceSyncContext syncContext = mClient.getSyncContext();
                    if (syncContext.isInitialized())
                        return null;

                    SQLiteLocalStore localStore = new SQLiteLocalStore(mClient.getContext(), "OfflineStore", null, 1);
                    Map<String, ColumnDataType> tableDefinition = new HashMap<String, ColumnDataType>();

                    switch(i) {
                        case "EMT":
                            tableDefinition.put("incidentNum", ColumnDataType.String);
                            tableDefinition.put("date", ColumnDataType.String);
                            tableDefinition.put("time", ColumnDataType.String);
                            tableDefinition.put("people", ColumnDataType.Other);
                            tableDefinition.put("photos", ColumnDataType.String);
                            localStore.defineTable("EMTTable", tableDefinition);
                        case "Fire":
                            tableDefinition.put("incidentNum", ColumnDataType.String);
                            tableDefinition.put("date", ColumnDataType.String);
                            tableDefinition.put("time", ColumnDataType.String);
                            tableDefinition.put("people", ColumnDataType.Other);
                            tableDefinition.put("photos", ColumnDataType.String);
                            tableDefinition.put("audios", ColumnDataType.String);
                            tableDefinition.put("initialAction", ColumnDataType.String);
                            tableDefinition.put("respond2Action", ColumnDataType.String);
                            tableDefinition.put("evaluation", ColumnDataType.String);
                            localStore.defineTable("FireTable", tableDefinition);
                        case "Police":
                            tableDefinition.put("incidentNum", ColumnDataType.String);
                            tableDefinition.put("date", ColumnDataType.String);
                            tableDefinition.put("time", ColumnDataType.String);
                            tableDefinition.put("people", ColumnDataType.Other);
                            tableDefinition.put("photos", ColumnDataType.String);
                            tableDefinition.put("audios", ColumnDataType.String);
                            tableDefinition.put("initialAction", ColumnDataType.String);
                            localStore.defineTable("PoliceTable", tableDefinition);
                    }

                    SimpleSyncHandler handler = new SimpleSyncHandler();
                    syncContext.initialize(localStore, handler).get();

                } catch (final Exception e) {
                }
                return null;
            }
        };
        return runAsyncTask(task);
    }

    //Offline Sync
    /**
     * Sync the current context and the Mobile Service Sync Table
     * @return
     */
    /*
    private AsyncTask<Void, Void, Void> sync() {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    MobileServiceSyncContext syncContext = mClient.getSyncContext();
                    syncContext.push().get();
                    mToDoTable.pull(null).get();
                } catch (final Exception e) {
                    createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };
        return runAsyncTask(task);
    }
    */

    /**
     * Run an ASync task on the corresponding executor
     * @param task
     * @return
     */
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
}
