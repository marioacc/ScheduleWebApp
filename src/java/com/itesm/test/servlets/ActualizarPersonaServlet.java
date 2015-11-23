/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.servlets;

import com.itesm.test.dao.PersonaDAO;
import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.PersonaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dave
 */
@WebServlet(name = "ActualizarPersonaServlet", urlPatterns = {"/persona/actualizar"})
public class ActualizarPersonaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String personaId = request.getParameter("id");
       String nombre = request.getParameter("nombre");
       String apellidoPaterno = request.getParameter("apellido_paterno");
       String apellidoMaterno = request.getParameter("apellido_materno");
       String alias = request.getParameter("alias");
       PersonaManager persona = new PersonaManager();
       
       PersonaVO personaV = new PersonaVO();
       personaV.setId(personaId);
       personaV.setNombre(nombre);

       
       if(personaId != null && personaId.trim().length() > 0){
       persona.actualizar(personaV);    
       } else{
           persona.agregar(personaV);
       }
       
       response.sendRedirect("/persona/listar");
        }
    }