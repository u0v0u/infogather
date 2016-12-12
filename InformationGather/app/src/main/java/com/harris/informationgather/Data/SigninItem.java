package com.harris.informationgather.Data;

/**
 * Created by myiee on 12/6/2016.
 */

public class SigninItem {
    public String Id;
    public String Username;
    public String Password;
    public int type;

    public SigninItem() {
        Username = "Default";
        Password = "Default";
        type = 3;
    }
}
