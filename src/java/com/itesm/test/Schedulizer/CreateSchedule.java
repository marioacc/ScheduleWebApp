package com.itesm.test.Schedulizer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.util.Iterator;
import java.util.ListIterator;

import com.itesm.test.Schedulizer.schedulizer;
import com.itesm.test.vo.PersonaVO;
import com.itesm.test.vo.TaskVO;
import com.itesm.test.vo.WorkHoursVO;
import com.itesm.test.manager.WorkHoursManager;
import com.itesm.test.dao.WorkHoursDAO;
import com.itesm.test.dao.TaskDAO;
import com.itesm.test.manager.TaskManager;
import com.sun.javafx.tk.Toolkit;
import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Created by carla on 23/11/15.
 */
public class CreateSchedule {
    PersonaVO user = new PersonaVO();
    public CreateSchedule (PersonaVO user){
        this.user = user;
    }
    private String getUserAgenda (){
       return user.getAgenda_id();
    }
    private List<WorkHoursVO> getUserWorkingHours (){
        WorkHoursDAO whd = new WorkHoursDAO();
        List<WorkHoursVO> workhours = new ArrayList<>();
        workhours = whd.findByAgendaId(getUserAgenda());
        return workhours;
    }
    private List<TaskVO> getUserTasks (){
        TaskDAO tskd = new TaskDAO();
        List<TaskVO> task_list = new ArrayList<>();
        task_list = tskd.findByAgenda(getUserAgenda());
        return task_list;
    }
    private List<WorkHoursVO> CalculateDurationOfWorkingHours(List<WorkHoursVO> whs){
        WorkHoursManager whm = new WorkHoursManager();
        for (WorkHoursVO wh: whs) {
            Long start= wh.getStart_date().getTime();
            Long end =wh.getEnd_date().getTime();
            Long fi = end-start;
            int days= (int) ((end-start)/(1000*3600));
            int minutes= (int) (end-start-(days*1000*3600))/1000*60;
            Time gg = new Time(days,minutes,0);

            wh.setDuration(gg);
            whm.actualizar(wh);
        }
        return whs;
    }
    public List<TaskVO> getSortedTasks (List <TaskVO> tasks) {
        List<TaskVO> tasks_ordered = new ArrayList<>();
        for(int i=0; i<=tasks.size()-1; i++){
            for (int j= i+1; j<=tasks.size()-1; j++){
                if(tasks.get(i).getPriority()>=tasks.get(j).getPriority()){
                    tasks_ordered.add(tasks.get(i));
                }else
                    tasks_ordered.add(tasks.get(j));
            }
        }
        return tasks_ordered;
    }

    public void matchTaskWithWorkhours (List <TaskVO> tasks, List<WorkHoursVO> workhours){
        ListIterator<TaskVO> task_it = tasks.listIterator();
        ListIterator<WorkHoursVO> wh_it = workhours.listIterator();
        TaskManager tskm = new TaskManager();
        while (task_it.hasNext() && wh_it.hasNext()){
            TaskVO task = task_it.next();
            WorkHoursVO wh = wh_it.next();
            if(task.getDuration().getTime()==wh.getDuration().getTime()){
                task.setWork_hours_id(wh.getId());
                task.setDay(wh.getDay());
                tskm.actualizar(task);
            } else if (task.getDuration().getTime()< wh.getDuration().getTime()){
                task.setWork_hours_id(wh.getId());
                task.setDay(wh.getDay());
                tskm.actualizar(task);
                WorkHoursVO wh1= copyWorkHours(wh);
                wh1.setDuration(new Time(wh.getDuration().getTime()-task.getDuration().getTime()));
                wh_it.add(wh1);
            } else if(task.getDuration().getTime()> wh.getDuration().getTime()){
                TaskVO tk1 = new TaskVO();
                tk1 = copyTask(task);
                tk1.setDuration(new Time(task.getDuration().getTime()-wh.getDuration().getTime()));
                task.setWork_hours_id(wh.getId());
                task.setDuration(wh.getDuration());
                task.setDay(wh.getDay());
                tskm.actualizar(task);
                task_it.add(tk1);
                tskm.agregar(tk1);
            }
        }

    }

    private TaskVO copyTask (TaskVO task){
        TaskVO task_copied = new TaskVO();
        task_copied.setDay(task.getDay());
        task_copied.setDescription(task.getDescription());
        task_copied.setPriority(task.getPriority());
        task_copied.setEnd_date(task.getEnd_date());
        task_copied.setAgenda_id(task.getAgenda_id());
        return task_copied;
    }

    private WorkHoursVO copyWorkHours (WorkHoursVO workHoursVO){
        WorkHoursVO wh_copied = new WorkHoursVO();
        wh_copied.setDay(workHoursVO.getDay());
        wh_copied.setEnd_date(workHoursVO.getEnd_date());
        wh_copied.setAgenda_id(workHoursVO.getAgenda_id());
        return wh_copied;
    }
    public void createSchedule (){
        List<TaskVO> tasks_list = new ArrayList<>();
        List<WorkHoursVO> work_hours_list = new ArrayList<>();
        tasks_list = getUserTasks();
        work_hours_list = getUserWorkingHours();
        tasks_list = getSortedTasks(tasks_list);
        work_hours_list = CalculateDurationOfWorkingHours(work_hours_list);
        matchTaskWithWorkhours(tasks_list,work_hours_list);
    }



  /*  private int convert_to_milliseconds(int hours, int min){
        return ((hours*60)+min)*1000;
    }

    private Time calculate_dur(WorkHoursVO wh) {
        int start_date = convert_to_milliseconds(wh.getStart_date().getHours(), wh.getStart_date().getMinutes());
        int end_date = convert_to_milliseconds(wh.getEnd_date().getHours(), wh.getEnd_date().getMinutes());
        Time duration = new Time(end_date-start_date);
        return duration;
    }*/




    /*private void match(List<TaskVO> tasks, List<WorkHoursVO> workhour, int pt, int pwh){

        if(pt< tasks.size() && pwh< workhour.size()){
            if(tasks.get(pt).getDuration().getTime() <= workhour.get(pwh).getDuration().getTime()){
                tasks.get(pt).setWork_hours_id(workhour.get(pwh).getId());
                //update
                TaskManager tm = new TaskManager();
                tm.actualizar(tasks.get(pt));
                //...
                if (tasks.get(pt).getDuration().getTime()== workhour.get(pwh).getDuration().getTime()){
                    pt++;
                    pwh++;
                    match(tasks,workhour,pt,pwh);}
                else {
                    workhour.get(pwh).setDuration(new Time(workhour.get(pwh).getDuration().getTime()-tasks.get(pt).getDuration().getTime()));
                    pt++;
                    match(tasks,workhour,pt,pwh);
                }
            } else if (tasks.get(pt).getDuration().getTime() > workhour.get(pwh).getDuration().getTime()){
                breakBigTask(tasks.get(pt),workhour,pwh);
            }
        }
     }
    public void breakBigTask (TaskVO task, List<WorkHoursVO> wh_list, int pointer){
        if (pointer< wh_list.size()-1){
            if(task.getDuration().getTime()>wh_list.get(pointer).getDuration().getTime()){
                TaskVO task2 = new TaskVO();
                task2.setWork_hours_id(wh_list.get(pointer+1).getId());
                task2.setAgenda_id(task.getAgenda_id());
                task2.setPriority(task.getPriority());
                task2.setDescription(task.getDescription());
                task2.setDuration(new Time(task.getDuration().getTime()-wh_list.get(pointer).getDuration().getTime()));
                task2.setEnd_date(task.getEnd_date());
                task.setEnd_date(new Timestamp(wh_list.get(pointer).getEnd_date().getTime()));
                //create
                TaskManager tm = new TaskManager();
                tm.agregar(task2);
                //...
                pointer++;
                breakBigTask(task2,wh_list,pointer);
            }
        }
    }
*/


}
