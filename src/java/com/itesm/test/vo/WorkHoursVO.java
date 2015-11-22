package com.itesm.test.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

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

    public String getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(String agenda_id) {
        this.agenda_id = agenda_id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    private Date day;
    private Timestamp start_date;
    private Timestamp end_date;
    private String agenda_id;


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
