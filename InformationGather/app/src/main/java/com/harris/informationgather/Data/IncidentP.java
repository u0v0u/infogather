package com.harris.informationgather.Data;

import java.util.List;

/**
 * Created by Steve on 11/15/2016.
 */

public class IncidentP {
    private String id;
    private String incidentNum;
    private String date;
    private String time;
    private String people;
    private String photos;
    private String audios;
    private String initialAction;

    public IncidentP(String in, String date, String time, String people, String photos, String audios, String ia){
        this.incidentNum = in;
        this.date = date;
        this.time = time;
        this.people = people;
        this.photos = photos;
        this.audios = audios;
        this.initialAction = ia;
    }

    public String getIncidentNum() { return incidentNum; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getPeople() { return people; }
    public String getPhotos() { return photos; }
    public String getAudios() { return audios; }
    public String getInitialAction(){ return initialAction; }

    public void setIncidentNum(String in){ this.incidentNum=in; }
    public void setDate(String date){ this.date=date; }
    public void setTime(String time) { this.time=time; }
    public void setPeople(String people) { this.people = people; }
    public void setPhotos(String photos) {this.photos = photos; }
    public void setAudios(String audios) {this.audios = audios; }
    public void setInitialAction(String ia) {this.initialAction = ia; }
}
