package com.itesm.test.vo;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * Created by mario on 11/18/2015.
 */
public class AgendaVO implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public Time getHours_left() {
        return hours_left;
    }

    public void setHours_left(Time hours_left) {
        this.hours_left = hours_left;
    }

    private String id;
    private Timestamp start_date;
    private Timestamp end_date;
    private Time hours_left;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AgendaVO){
            return this.id.equals(((AgendaVO) obj).id);
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
