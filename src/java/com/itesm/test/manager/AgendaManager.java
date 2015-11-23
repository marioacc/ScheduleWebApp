package com.itesm.test.manager;

import com.itesm.test.dao.AgendaDAO;
import com.itesm.test.vo.AgendaVO;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mario on 11/19/2015.
 */
public class AgendaManager {

    public List<AgendaVO> listar(){
        AgendaDAO listaAgendas = new AgendaDAO();
        return listaAgendas.findAll();
    }

    public AgendaVO consultar(final String idConsulta){
        AgendaDAO consultaAgenda = new AgendaDAO();
        return consultaAgenda.findById(idConsulta);
    }

    public void eliminar(final String idEliminar){
        AgendaDAO eliminarAgenda = new AgendaDAO();
        eliminarAgenda.delete(idEliminar);
    }

    public void actualizar(final AgendaVO persona){
        //TODO invocat al dao.update(persona);
        AgendaDAO dao = new AgendaDAO();
        dao.update(persona);
    }

    public AgendaVO agregar(final AgendaVO agenda){
        AgendaDAO dao = new AgendaDAO();
        return dao.insert(agenda.getStart_date(), agenda.getEnd_date(),
                agenda.getHours_left());
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        AgendaDAO dao = new AgendaDAO();
        System.out.println(dao.findAll());
        System.out.println("Give me an Id to search: ");
        String toId = reader.nextLine();
        System.out.println(dao.findById(toId));
    }
}
