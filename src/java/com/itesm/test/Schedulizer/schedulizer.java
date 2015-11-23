package com.itesm.test.Schedulizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

/**
 * Created by carla on 22/11/15.
 */
public class schedulizer {
    //ArrayList of TasksVO
    List<TaskVO> jobs = new ArrayList<TaskVO>();
    int r;
    //Custom Constructor, receives a TASKVO arraylist
    public schedulizer(List<TaskVO> task_array){
        jobs = task_array;
        r = jobs.size();
    }
    /*This methods compares two dates, receives an arraylist of tasks, an integer pointing
    to the beggining of the array NOTE: SHOULD BE 1, and a pointer to the end of the array.*/
    public List<TaskVO> sortByDuedate (List<TaskVO> task_array, int p, int r){
            if(p<r){
                int q = (p+r)/2;
                sortByDuedate(task_array,p,q);
                sortByDuedate(task_array, q+1,r);
                merge(task_array, p,q,r);
            }
    }
    public void merge (List<TaskVO> task_array,int p, int q, int r){
        int n_one = q-p+1;
        int n_two = r-q;
        List<TaskVO> left = new ArrayList<TaskVO>();
        List<TaskVO> right = new ArrayList<TaskVO>();
        for (int i=1; i<=n_one; i++){
            left.set(i,task_array.get(p+i-1));
        }
        for (int j=1; j<=n_two; j++){
            right.set(j,task_array.get(q+j));
        }
        int i =1;
        int j= 1;
        //if(left.get(i)<right.)
    }

    //Sort jobs by due date a.k.a end date
    public List<TaskVO> sort_by_duedate(){
        Collections.sort(jobs);
    }
}
