package com.harris.informationgather;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

import com.harris.informationgather.Data.SigninItem;
import com.harris.informationgather.Data.TempClass;
import com.harris.informationgather.Data.TodoItem;
import com.harris.informationgather.Helper.ADhelper;
import com.harris.informationgather.Helper.DBhelper;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.PromptBehavior;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import org.w3c.dom.Text;

import static com.microsoft.windowsazure.mobileservices.table.query.QueryOperations.val;

public class LoginActivity extends AppCompatActivity implements OnItemSelectedListener {

    public static MobileServiceClient mClient;
    private SigninItem siItem;
    public static SigninItem msiItem;
    private Button loginButton;
    private EditText unET, pwET;
    private TextView tv1;
    private ProgressBar pb1;

    public static int selectionid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        siItem = new SigninItem();
        loginButton = (Button) findViewById(R.id.button);
        unET = (EditText) findViewById(R.id.editText);
        pwET = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView18);
        pb1 = (ProgressBar) findViewById(R.id.progressBar);
        pb1.setVisibility(View.INVISIBLE);

        try {
            mClient = new MobileServiceClient("http://harrisphoneapp.azurewebsites.net", this);
        } catch (MalformedURLException e) {
        } catch (Exception e) {
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                Handler handler = new Handler();
                //siItem.Username = "Default";
                //siItem.Password = "Default";
                tv1.setText("");
                if (!unET.getText().toString().equals("")) {
                    pb1.setVisibility(View.VISIBLE);
                    getLogin(unET.getText().toString());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (!siItem.Username.equals("Default")) {
                                if (siItem.Password.equals(pwET.getText().toString())) {
                                    msiItem = siItem;
                                    Intent myIntent = new Intent(view.getContext(), IncidentActivity.class);
                                    startActivityForResult(myIntent, 0);
                                } else {
                                    tv1.setText("Wrong Password");
                                }
                            } else {
                                tv1.setText("Username Not Found");
                            }
                            pb1.setVisibility(View.INVISIBLE);
                        }
                    }, 1200);
                } else {
                    tv1.setText("Enter Username");
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectionid = (int) id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //mAuthContext.onActivityResult(requestCode, resultCode, data);
    }

    private void getLogin(final String username) {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    siItem = getSigninFromMobileServiceTable(username).get(0);
                } catch (final Exception e) {
                }
                return null;
            }
        };
        runAsyncTask(task);
    }

    private List<SigninItem> getSigninFromMobileServiceTable(String username) throws ExecutionException, InterruptedException {
        return mClient.getTable(SigninItem.class).where().field("USERNAME").
                eq(username).execute().get();
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

}
