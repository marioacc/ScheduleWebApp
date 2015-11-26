/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.servlets;

import com.itesm.test.Schedulizer.CreateSchedule;
import com.itesm.test.dao.TaskDAO;
import com.itesm.test.manager.TaskManager;
import com.itesm.test.manager.WorkHoursManager;
import com.itesm.test.vo.PersonaVO;
import com.itesm.test.vo.TaskVO;
import com.itesm.test.vo.WorkHoursVO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Dave
 */
@WebServlet(name = "TasksServlet", urlPatterns = {"/addtasks"})
public class TasksServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String []description = request.getParameterValues("description");
            String[] priority = request.getParameterValues("priority");
            String[] task_time=request.getParameterValues("task_time");
            String[] end_time=request.getParameterValues("end_time");
        PersonaVO personavo=(PersonaVO) request.getSession().getAttribute("persona");
        TaskManager taskManager = new TaskManager();
        for (int i = 0; i < priority.length; i++) {
            TaskVO wh= new TaskVO();
            SimpleDateFormat sdf= new SimpleDateFormat("hh:mm");
            SimpleDateFormat sdfTimeStamp= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date durationDate= null;
            Date end_date=null;
            try {
                durationDate = sdf.parse(task_time[i]);
                end_date=sdfTimeStamp.parse(end_time[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            wh.setDuration(new Time(durationDate.getTime()));
            wh.setEnd_date(new Timestamp(end_date.getTime()));
            wh.setDescription(description[i]);
            wh.setPriority(Integer.parseInt(priority[i]));
            wh.setAgenda_id(personavo.getAgenda_id());
            System.out.println(wh.toString());
            taskManager.agregar(wh);
        }
        CreateSchedule createSchedule= new CreateSchedule(personavo);
        createSchedule.createSchedule();
        TaskDAO taskDAO= new TaskDAO();
        List<TaskVO> task_list = taskDAO.findByAgenda(personavo.getAgenda_id());
        ListIterator listIterator= task_list.listIterator();
        while (listIterator.hasNext()){
            TaskVO task= (TaskVO) listIterator.next();
            if (task.getWork_hours_id() == null){
                listIterator.remove();
            }
        }

        WorkHoursManager workHoursManager= new WorkHoursManager();
        List<WorkHoursVO> worksHours_list= workHoursManager.consultarPorAgenda(personavo.getAgenda_id());
        request.setAttribute("tasks",task_list);
        request.setAttribute("works",worksHours_list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/schedule.jsp");
        rd.forward(request,response);


    }

    private void setSession(PersonaVO personaVO, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("persona",personaVO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/tasks.jsp");
        rd.forward(req,resp);
    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String workHoursJson = request.getParameter("tasks");
//        System.out.println(workHoursJson);
//        PersonaVO personavo=(PersonaVO) request.getSession().getAttribute("persona");
//        try {
//            JSONObject jsonObject= new JSONObject(workHoursJson);
//            JSONArray jsonArray =jsonObject.getJSONArray("tasks");
//
//            TaskManager taskManager= new TaskManager();
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonO = jsonArray.getJSONObject(i);
//                TaskVO wh= new TaskVO();
//                SimpleDateFormat sdf= new SimpleDateFormat("hh:mm");
//                SimpleDateFormat sdfTimeStamp= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//                Date durationDate= sdf.parse(jsonO.getString("duration"));
//                Date end_date=sdfTimeStamp.parse(jsonO.getString("end_time"));
//                wh.setDuration(new Time(durationDate.getTime()));
//                wh.setEnd_date(new Timestamp(end_date.getTime()));
//                wh.setDescription(jsonO.getString("description"));
//                wh.setPriority(jsonO.getInt("priority"));
//                wh.setAgenda_id(personavo.getAgenda_id());
//                System.out.println(wh.toString());
//                taskManager.agregar(wh);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        CreateSchedule createSchedule= new CreateSchedule(personavo);
//        createSchedule.createSchedule();
//
//
//    }
}
