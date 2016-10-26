package com.harris.informationgather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.PromptBehavior;

public class LoginActivity extends AppCompatActivity implements OnItemSelectedListener {

    /* Configurations */
    public final static String CLIENT_ID = "YOUR_CLIENT_ID"; //REPLACE WITH YOUR CLIENT ID
    public final static String REDIRECT_URI = "http://localhost"; //REPLACE WITH YOUR REDIRECT URL
    public final static String AUTHORITY_URL = "https://login.microsoftonline.com/common";  //COMMON OR YOUR TENANT ID
    private final static String AUTH_TAG = "auth"; // Search "auth" in your Android Monitor to see errors
    private AuthenticationContext mAuthContext;

    public static int selectionid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        selectionid = 125;

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Policeman");
        categories.add("Firefighter");
        categories.add("EMT");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), IncidentActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
/*
        mAuthContext = new AuthenticationContext(LoginActivity.this, AUTHORITY_URL, true);
        mAuthContext.acquireToken(
                LoginActivity.this,
                CLIENT_ID,
                CLIENT_ID,
                REDIRECT_URI,
                PromptBehavior.Auto,
                new AuthenticationCallback<AuthenticationResult>()
                {

                    @Override
                    public void onError(Exception e)
                    {
                        //Log.e(AUTH_TAG, "Error getting token: " + e.toString());
                    }

                    @Override
                    public void onSuccess(AuthenticationResult result)
                    {
                        Log.v(AUTH_TAG, "Successfully obtained token, still need to validate");
                        if (result != null && !result.getAccessToken().isEmpty())
                        {
                            try
                            {
                                String firstName = result.getUserInfo().getGivenName();
                                String lastName = result.getUserInfo().getFamilyName();
                                updateLoggedInUI(firstName, lastName);
                            }
                            catch (Exception e)
                            {
                                Log.e(AUTH_TAG, "Exception Generated, Unable to hit the backend: " + e.toString());
                            }
                        }
                        else
                        {
                            Log.e(AUTH_TAG, "Error: token came back empty");
                        }
                    }
                });
            */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectionid = (int) id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void updateLoggedInUI(String firstName, String lastName)
    {
    /* Hide the sign in button */
        //findViewById(R.id.button).setVisibility(View.INVISIBLE);

    /* Show the welcome message */
        //TextView signedIn = (TextView) findViewById(R.id.welcomeSignedIn);
        //signedIn.setVisibility(View.VISIBLE);
        //signedIn.setText("Welcome " + firstName + " " + lastName);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        mAuthContext.onActivityResult(requestCode, resultCode, data);
    }
}
