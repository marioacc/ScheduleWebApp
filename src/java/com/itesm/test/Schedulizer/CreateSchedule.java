package com.itesm.test.Schedulizer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

import com.itesm.test.Schedulizer.schedulizer;
import com.itesm.test.vo.PersonaVO;
import com.itesm.test.vo.TaskVO;
import com.itesm.test.vo.WorkHoursVO;
import com.itesm.test.manager.WorkHoursManager;
import com.itesm.test.dao.WorkHoursDAO;
import com.itesm.test.dao.TaskDAO;

/**
 * Created by carla on 23/11/15.
 */
public class CreateSchedule {
    PersonaVO user = new PersonaVO();
    List<WorkHoursVO> workhours = new ArrayList<>();
    List<TaskVO> task_list = new ArrayList<>();
    public CreateSchedule (String user_id){
        user.setId(user_id);
    }
    private String getUserAgenda (){
       return user.getAgenda_id();
    }
    private List<WorkHoursVO> getUserWorkingHours (){
        WorkHoursDAO whd = new WorkHoursDAO();
        workhours = whd.findByAgendaId(getUserAgenda());
        return workhours;
    }
    private List<TaskVO> getUserTasks (){
        TaskDAO tskd = new TaskDAO();
        task_list = tskd.findByAgenda(getUserAgenda());
        return task_list;
    }
    private List<TaskVO> normalizeList (List<TaskVO> task_list) {
        List <TaskVO> task_list_normalized = new ArrayList<>();
        for (int i = 0; i<task_list.size(); i++){
            task_list_normalized.set(i+1, task_list.get(i));
        }
        return task_list_normalized;
    }
    private List<TaskVO> getScheludedTaskList(){
        List<TaskVO> tasks_list = new ArrayList<>();
        tasks_list = getUserTasks();
        tasks_list = normalizeList(tasks_list);
        schedulizer schedule = new schedulizer(tasks_list);
        tasks_list = schedule.Schedulize(tasks_list, tasks_list.size());
        return tasks_list;
    }
    private List<WorkHoursVO> CalculateDurationOfWorkingHours(){
        List<WorkHoursVO> workinghours = getUserWorkingHours();
        for (int i=0; i<workinghours.size();i++){
            workinghours.get(i).setDuration(calculate_dur(workinghours.get(i)));
        }
        return workinghours;
    }

    private int convert_to_milliseconds(int hours, int min){
        return ((hours*60)+min)*1000;
    }

    private Time calculate_dur(WorkHoursVO wh) {
        int start_date = convert_to_milliseconds(wh.getStart_date().getHours(), wh.getStart_date().getMinutes());
        int end_date = convert_to_milliseconds(wh.getEnd_date().getHours(), wh.getEnd_date().getMinutes());
        Time duration = new Time(end_date-start_date);
        return duration;
    }

    public void createSchedule (){
        List<TaskVO> tasks_list = new ArrayList<>();
        tasks_list = getScheludedTaskList();
        List<WorkHoursVO> workhours = new ArrayList<>();
        workhours = CalculateDurationOfWorkingHours();


    }
    private void matchStartdates(TaskVO task, WorkHoursVO workhour){
            
    }

}
