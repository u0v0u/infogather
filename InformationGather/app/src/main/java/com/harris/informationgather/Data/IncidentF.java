package com.harris.informationgather.Data;

import java.util.List;

/**
 * Created by Steve on 11/15/2016.
 */

public class IncidentF {
    private String incidentNum;
    private String date;
    private String time;
    private List<PeopleData> people;
    private List<String> photos;
    private List<String> audios;
    private String initialAction;
    private String respond2Action;
    private String evaluation;

    public IncidentF(String in, String date, String time, List<PeopleData> people, List<String> photos, List<String> audios, String ia, String ra, String eva){
        this.incidentNum = in;
        this.date = date;
        this.time = time;
        this.people = people;
        this.photos = photos;
        this.audios = audios;
        this.initialAction = ia;
        this.respond2Action = ra;
        this.evaluation = eva;
    }

    public String getIncidentNum() { return incidentNum; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public List<PeopleData> getPeople() { return people; }
    public List<String> getPhotos() { return photos; }
    public List<String> getAudios() { return audios; }
    public String getInitialAction(){ return initialAction; }
    public String getRespond2Action(){ return respond2Action; }
    public String getEvaluation(){ return evaluation; }

    public void setIncidentNum(String in){ this.incidentNum=in; }
    public void setDate(String date){ this.date=date; }
    public void setTime(String time) { this.time=time; }
    public void setPeople(List<PeopleData> people) { this.people = people; }
    public void setPhotos(List<String> photos) {this.photos = photos; }
    public void setAudios(List<String> audios) {this.audios = audios; }
    public void setInitialAction(String ia) {this.initialAction = ia; }
    public void setRespond2Action(String ra) {this.respond2Action = ra; }
    public void setEvaluation(String eva) {this.evaluation = eva; }
}
