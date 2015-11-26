package com.itesm.test.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.itesm.test.helpers.GsonDateDeSerializer;
import com.itesm.test.manager.PersonaManager;
import com.itesm.test.manager.WorkHoursManager;
import com.itesm.test.vo.PersonaVO;
import com.itesm.test.vo.TaskVO;
import com.itesm.test.vo.WorkHoursVO;
import com.sun.net.httpserver.HttpsServer;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by mario on 11/22/2015.
 */
@WebServlet(name = "NewWorkHoursServlet", urlPatterns = {"/newworkhours"})
public class NewWorkHoursServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String start_time[]  = request.getParameterValues("start_time");
        String[] end_time  = request.getParameterValues("end_time");
        String[] day  = request.getParameterValues("day");
        PersonaVO personavo=(PersonaVO) request.getSession().getAttribute("persona");
        WorkHoursManager workHoursManager = new WorkHoursManager();
        for (int i = 0; i < (start_time.length); i++) {
            WorkHoursVO wh= new WorkHoursVO();
            String day_num = day[i];
            wh.setDay(Integer.parseInt(day[i]));
            System.out.println(wh.getDay());
            SimpleDateFormat sdf= new SimpleDateFormat("hh:mm");
            try{
                Date start_date= sdf.parse(start_time[i]);
                Date end_date=sdf.parse(end_time[i]);
                wh.setStart_date(new Time(start_date.getTime()));
                wh.setEnd_date(new Time(end_date.getTime()));
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
            wh.setAgenda_id(personavo.getAgenda_id());
            System.out.println(wh.toString());
            workHoursManager.agregar(wh);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/tasks.jsp");
        rd.forward(request, response);

//            response.getWriter().write("{ 'success': true, 'location': 'tasks.jsp' }");

//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


    }

    private void setSession(List<WorkHoursVO> workHours, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("workHours",workHours);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String workHoursJson = request.getParameter("workHours");
//        System.out.println(workHoursJson);
//        try {
//            JSONObject jsonObject= new JSONObject(workHoursJson);
//            JSONArray jsonArray =jsonObject.getJSONArray("hours");
//            PersonaVO personavo=(PersonaVO) request.getSession().getAttribute("persona");
//            WorkHoursManager workHoursManager= new WorkHoursManager();
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonO = jsonArray.getJSONObject(i);
//                WorkHoursVO wh= new WorkHoursVO();
//                wh.setDay(Integer.parseInt(jsonO.getString("day")));
//                System.out.println(wh.getDay());
//                SimpleDateFormat sdf= new SimpleDateFormat("hh:mm");
//                Date start_date= sdf.parse(jsonO.getString("start_time"));
//                Date end_date=sdf.parse(jsonO.getString("end_time"));
//                wh.setStart_date(new Time(start_date.getTime()));
//                wh.setEnd_date(new Time(end_date.getTime()));
//                wh.setAgenda_id(personavo.getAgenda_id());
//                System.out.println(wh.toString());
//                workHoursManager.agregar(wh);
//            }
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/tasks.jsp");
//            rd.forward(request, response);
//            System.out.println("gg dude");
//            response.setContentType("application/json");
//            response.getWriter().write("{ 'success': true, 'location': 'tasks.jsp' }");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/workhours.jsp");
        rd.forward(req,resp);
    }
}
