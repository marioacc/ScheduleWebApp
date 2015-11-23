package com.itesm.test.servlets;

import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.PersonaVO;
import com.sun.net.httpserver.HttpsServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by mario on 11/22/2015.
 */
@WebServlet(name = "NewWorkHoursServlet", urlPatterns = {"/neworkhours"})
public class NewWorkHoursServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("username");
        String password= request.getParameter("password");
        PersonaManager manager = new PersonaManager();
        List<PersonaVO> personas = manager.listar();
        for (PersonaVO persona: personas){
            if(persona.getMail().equals(mail) && persona.getPassword().equals(password)){
                if (persona.getAgenda_id()!=null){
                    setSession(persona,request);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/schedule.jsp");
                    request.setAttribute("persona",persona);
                    rd.forward(request, response);
                }else{
                    setSession(persona,request);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
                    request.setAttribute("persona",persona);
                    rd.forward(request, response);
                }

            }
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

        rd.forward(request, response);

    }

    private void setSession(PersonaVO personaVO, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("persona",personaVO);
    }

}
