package com.harris.informationgather.Data;

import java.util.List;

/**
 * Created by Steve on 11/15/2016.
 */

public class IncidentP {
    private String incidentNum;
    private String date;
    private String time;
    private List<PeopleData> people;
    private List<String> photos;
    private List<String> audios;
    private String initialAction;

    public IncidentP(String in, String date, String time, List<PeopleData> people, List<String> photos, List<String> audios, String ia){
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
    public List<PeopleData> getPeople() { return people; }
    public List<String> getPhotos() { return photos; }
    public List<String> getAudios() { return audios; }
    public String getInitialAction(){ return initialAction; }

    public void setIncidentNum(String in){ this.incidentNum=in; }
    public void setDate(String date){ this.date=date; }
    public void setTime(String time) { this.time=time; }
    public void setPeople(List<PeopleData> people) { this.people = people; }
    public void setPhotos(List<String> photos) {this.photos = photos; }
    public void setAudios(List<String> audios) {this.audios = audios; }
    public void setInitialAction(String ia) {this.initialAction = ia; }
}
