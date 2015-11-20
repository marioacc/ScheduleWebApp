package com.itesm.test.vo;

import java.io.Serializable;

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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getHours_left() {
        return hours_left;
    }

    public void setHours_left(String hours_left) {
        this.hours_left = hours_left;
    }

    private String id;
    private String start_date;
    private String end_date;
    private String hours_left;

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
