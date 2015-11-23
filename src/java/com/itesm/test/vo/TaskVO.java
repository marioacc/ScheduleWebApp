package com.itesm.test.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.Date;


/**
 * Created by mario on 11/21/2015.
 */
public class TaskVO implements Serializable{

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getWork_hours_id() {
        return work_hours_id;
    }

    public void setWork_hours_id(String work_hours_id) {
        this.work_hours_id = work_hours_id;
    }

    private int day;
    private Timestamp start_date;
    private Timestamp end_date;
    private int priority;
    private String work_hours_id;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AgendaVO){
            return this.id.equals(((TaskVO) obj).id);
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
