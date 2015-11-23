package com.itesm.test.vo;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Time;

/**
 * Created by mario on 11/21/2015.
 */
public class WorkHoursVO implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Time getStart_date() {
        return start_date;
    }

    public void setStart_date(Time start_date) {
        this.start_date = start_date;
    }

    public Time getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Time end_date) {
        this.end_date = end_date;
    }

    public String getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(String agenda_id) {
        this.agenda_id = agenda_id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;
    private Time start_date;
    private Time end_date;
    private String agenda_id;

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    private Time duration;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AgendaVO){
            return this.id.equals(((WorkHoursVO) obj).id);
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return this.id+" "+this.start_date+" "+this.end_date;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
