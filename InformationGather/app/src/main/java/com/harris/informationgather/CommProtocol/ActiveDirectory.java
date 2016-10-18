package com.harris.informationgather.CommProtocol;

import com.microsoft.aad.adal.AuthenticationContext;

/**
 * Created by myiee on 10/18/2016.
 */

public class ActiveDirectory {

    /* Configurations */
    public final static String CLIENT_ID = "YOUR_CLIENT_ID"; //REPLACE WITH YOUR CLIENT ID
    public final static String REDIRECT_URI = "http://localhost"; //REPLACE WITH YOUR REDIRECT URL
    public final static String AUTHORITY_URL = "https://login.microsoftonline.com/common";  //COMMON OR YOUR TENANT ID
    private final static String AUTH_TAG = "auth"; // Search "auth" in your Android Monitor to see errors
    private AuthenticationContext mAuthContext;
    public static int selectionid;


}
