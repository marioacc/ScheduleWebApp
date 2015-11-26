package com.itesm.test.manager;

import com.itesm.test.dao.TaskDAO;
import com.itesm.test.vo.TaskVO;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mario on 11/21/2015.
 */
public class TaskManager {

    public List<TaskVO> listar(){
        TaskDAO listaPersonas = new TaskDAO();
        return listaPersonas.findAll();
    }

    public TaskVO consultar(final String idConsulta){
        TaskDAO consultaPersona = new TaskDAO();
        return consultaPersona.findById(idConsulta);
    }

    public void eliminar(final String idEliminar){
        TaskDAO eliminarPersona = new TaskDAO();
        eliminarPersona.delete(idEliminar);
    }

    public void actualizar(final TaskVO persona){
        //TODO invocat al dao.update(persona);
        TaskDAO dao = new TaskDAO();
        dao.update(persona);
    }

    public void agregar(final TaskVO persona){
        TaskDAO dao = new TaskDAO();
        dao.insert(persona.getDay(), persona.getStart_date(),
                persona.getEnd_date(), persona.getPriority(),persona.getDuration(),persona.getDescription(),persona.getWork_hours_id(), persona.getAgenda_id());
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        TaskDAO dao = new TaskDAO();
        System.out.println(dao.findAll());
        System.out.println("Give me an Id to search: ");
        String toId = reader.nextLine();
        System.out.println(dao.findById(toId));
    }
}
