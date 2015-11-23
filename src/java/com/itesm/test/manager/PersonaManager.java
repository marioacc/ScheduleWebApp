/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.manager;

import com.itesm.test.dao.PersonaDAO;
import com.itesm.test.vo.PersonaVO;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Dave
 */
public class PersonaManager {
    public List<PersonaVO> listar(){
        PersonaDAO listaPersonas = new PersonaDAO();
        return listaPersonas.findAll();
    }

    public PersonaVO consultar(final String idConsulta){
        PersonaDAO consultaPersona = new PersonaDAO();
        return consultaPersona.findById(idConsulta);
    }
    
    public void eliminar(final String idEliminar){
        PersonaDAO eliminarPersona = new PersonaDAO();
        eliminarPersona.delete(idEliminar);
    }
    
    public void actualizar(final PersonaVO persona){
        //TODO invocat al dao.update(persona);
        PersonaDAO dao = new PersonaDAO();
        dao.update(persona);
    }
    
    public void agregar(final PersonaVO persona){
         PersonaDAO dao = new PersonaDAO();
         dao.insert(persona.getNombre(), persona.getPassword(),
                 persona.getMail(), persona.getAgenda_id());
    }
    
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        PersonaDAO dao = new PersonaDAO();
        System.out.println(dao.findAll());
        System.out.println("Give me an Id to search: ");
        String toId = reader.nextLine();
        System.out.println(dao.findById(toId));
    }
}
