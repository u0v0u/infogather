package com.harris.informationgather.Data;

/**
 * Created by Steve on 11/15/2016.
 */

public class PeopleData {
    private String id;
    public String mid;
    public String name;
    public String dob;
    public String sex;
    public String skin;
    public String eyes;
    public String o2;
    public String pulse;
    public String heart;

    public PeopleData(String mid, String name, String dob, String sex, String skin, String eyes, String o2, String pulse, String heart) {
        this.mid = mid;
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.skin = skin;
        this.eyes = eyes;
        this.o2 = o2;
        this.pulse = pulse;
        this.heart = heart;
    }
}
