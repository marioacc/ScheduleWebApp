/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.servlets;

import com.itesm.test.manager.AgendaManager;
import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.AgendaVO;
import com.itesm.test.vo.PersonaVO;

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
 *
 * @author Dave
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        String email = request.getParameter("email");
        PersonaManager manager = new PersonaManager();
        PersonaManager personaManager= new PersonaManager();
        PersonaVO personaVO= new PersonaVO();
        personaVO.setMail(email);
        personaVO.setNombre(username);
        personaVO.setPassword(password);
        List <PersonaVO> personaVOs= personaManager.listar();
        for (PersonaVO persona: personaVOs){
            if(persona.getMail().equals(email) || persona.getMail().equals(email)){
                setSession(persona,request);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        }
        AgendaVO ag= new AgendaVO();
        AgendaManager agendaManager = new AgendaManager();
        AgendaVO agenda=agendaManager.agregar(ag);
        personaVO.setAgenda_id(agenda.getId());
        setSession(personaManager.agregar(personaVO),request);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
        rd.forward(request, response);

    }

    private void setSession(PersonaVO personaVO, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("persona",personaVO);
    }
}
