package com.harris.informationgather.Data;

import android.graphics.Bitmap;
import android.provider.Contacts;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

/**
 * Created by Steve on 11/15/2016.
 */

public class IncidentE {
    private String incidentNum;
    private String date;
    private String time;
    private List<PeopleData> people;
    private List<String> photos;

    public IncidentE(String in, String date, String time, List<PeopleData> people, List<String> photos){
        this.incidentNum = in;
        this.date = date;
        this.time = time;
        this.people = people;
        this.photos = photos;
    }

    public String getIncidentNum() { return incidentNum; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public List<PeopleData> getPeople() { return people; }
    public List<String> getPhotos() { return photos; }

    public void setIncidentNum(String in){ this.incidentNum=in; }
    public void setDate(String date){ this.date=date; }
    public void setTime(String time) { this.time=time; }
    public void setPeople(List<PeopleData> people) { this.people = people; }
    public void setPhotos(List<String> photos) {this.photos = photos; }
}

