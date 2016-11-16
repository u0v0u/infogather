package com.harris.informationgather.Helper;

import android.app.Activity;
import android.util.Log;

import com.harris.informationgather.LoginActivity;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.PromptBehavior;

/**
 * Created by myiee on 10/18/2016.
 */

public class ADhelper {

    /* Configurations */
    public final static String CLIENT_ID = "YOUR_CLIENT_ID"; //REPLACE WITH YOUR CLIENT ID
    public final static String REDIRECT_URI = "http://localhost"; //REPLACE WITH YOUR REDIRECT URL
    public final static String AUTHORITY_URL = "https://login.microsoftonline.com/common";  //COMMON OR YOUR TENANT ID
    private final static String AUTH_TAG = "auth"; // Search "auth" in your Android Monitor to see errors
    private static AuthenticationContext mAuthContext;
    public static int selectionid;


    public static void authenticate() {
        mAuthContext = new AuthenticationContext(LoginActivity.context, AUTHORITY_URL, true);
        mAuthContext.acquireToken(
                (Activity) LoginActivity.context,
                CLIENT_ID,
                CLIENT_ID,
                REDIRECT_URI,
                PromptBehavior.Auto,
                new AuthenticationCallback<AuthenticationResult>() {

                    @Override
                    public void onError(Exception e) {
                        //Log.e(AUTH_TAG, "Error getting token: " + e.toString());
                    }

                    @Override
                    public void onSuccess(AuthenticationResult result) {
                        Log.v(AUTH_TAG, "Successfully obtained token, still need to validate");
                        if (result != null && !result.getAccessToken().isEmpty()) {
                            try {
                                String firstName = result.getUserInfo().getGivenName();
                                String lastName = result.getUserInfo().getFamilyName();
                                updateLoggedInUI(firstName, lastName);
                            } catch (Exception e) {
                                Log.e(AUTH_TAG, "Exception Generated, Unable to hit the backend: " + e.toString());
                            }
                        } else {
                            Log.e(AUTH_TAG, "Error: token came back empty");
                        }
                    }
                });
    }

    private static void updateLoggedInUI(String firstName, String lastName)
    {
    /* Hide the sign in button */
        //findViewById(R.id.button).setVisibility(View.INVISIBLE);

    /* Show the welcome message */
        //TextView signedIn = (TextView) findViewById(R.id.welcomeSignedIn);
        //signedIn.setVisibility(View.VISIBLE);
        //signedIn.setText("Welcome " + firstName + " " + lastName);
    }
}
