package com.itesm.test.Schedulizer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.itesm.test.vo.TaskVO;

/**
 * Created by carla on 22/11/15.
 */
public class schedulizer {
    //ArrayList of TasksVO
    List<TaskVO> jobs = new ArrayList<>();
    int r;
    //Custom Constructor, receives a TASKVO arraylist
    public schedulizer(List<TaskVO> task_array){
        jobs = task_array;
        r = jobs.size();
    }
    /*This methods compares two dates, receives an arraylist of tasks, an integer pointing
    to the beggining of the array NOTE: SHOULD BE 1, and a pointer to the end of the array.*/
    public List<TaskVO> sortByDuedate (List<TaskVO> task_array, int p, int r){
        List<TaskVO> empty = new ArrayList<>();
            if(p<r) {
                int q = (p + r) / 2;
                sortByDuedate(task_array, p, q);
                sortByDuedate(task_array, q + 1, r);
                return merge(task_array, p, q, r);
            }
        return empty;
    }
    /*merge sort: p is the beggining, q is the n/2 and r is the end*/
    private List<TaskVO> merge (List<TaskVO> task_array,int p, int q, int r){
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
        int i=1;
        int j=1;
        for (int k=p; k<=r; k++) {
            if (CompareDates(left.get(i).getEnd_date(), right.get(j).getEnd_date()) == 1) {
                task_array.set(k, left.get(i));
                i++;
            } else {
                task_array.set(k, right.get(j));
                j++;
            }
        }
        return task_array;
    }
    private int CompareDates(Timestamp date1, Timestamp date2){
        if(date1.before(date2)){
            return 1; //left side comes before
        }

        if(date1.after(date2)) {
            return 2; //right side comes before.
        }
        return 1;//equals
    }
    /*Schedulizing this shit*/
    public int latestNonConflict(List<TaskVO> task_list, int i) {
        for (int j=i-1; j>=1; j--)
        {
            if(CompareDates(task_list.get(j).getEnd_date(),task_list.get(i).getStart_date()) == 1)
                return j;
        }
        return -1;
    }
    /*Receives an arraylist of task and the array lenght. List index must begin in 1 for sort to wok*/
    public ArrayList<TaskVO> Schedulize(List<TaskVO> task_list, int n)
    {
        //Store the task in order of schedule
        List<TaskVO> sortedTasks = new ArrayList<TaskVO>();
        ArrayList<ArrayList<TaskVO>> Combinations = new ArrayList<ArrayList<TaskVO>>();

        //Sort this shit with the lowest due date
        sortedTasks= sortByDuedate(task_list,1,this.r);

        // Create an array to store solutions of subproblems.  table[i]
        // stores the profit for jobs till arr[i] (including arr[i])
        int []table = new int[n];
        table[1] = sortedTasks.get(1).getPriority();

        // Fill entries in M[] using recursive property
        for (int i=2; i<n; i++)
        {
            // Find profit including the current job
            int inclProf = sortedTasks.get(i).getPriority();
            int l = latestNonConflict(sortedTasks, i);
            ArrayList<TaskVO> tasks1 = new ArrayList<TaskVO>();
            if (l != -1) {
                inclProf += table[l];
                tasks1.add(sortedTasks.get(l));
                tasks1.add(sortedTasks.get(i));

            }else {
                tasks1.add(sortedTasks.get(i));
            }
            Combinations.set(i,tasks1);
            // Store min of including and excluding
            //If it's better to include:
            if(inclProf >= table[i-1]){
                table[i] = inclProf;
                //col.addAll(otherCol)
                if(l != -1 && l>=2){
                    ArrayList<TaskVO> union = new ArrayList<TaskVO>();
                    union = Combinations.get(l);
                    union.addAll(Combinations.get(i));
                    Combinations.set(i,union);
                } else {
                    Combinations.set(i, Combinations.get(i));
                }

            //If it's better to let go.
            } else {
                table[i] = table[i-1];
                Combinations.set(i,Combinations.get(i-1));
            }
            //table[i] = Math.max(inclProf, table[i-1]);
        }

        // Store result and free dynamic memory allocated for table[]
        int result = table[n];
        return Combinations.get(n);
    }
}
