package com.itesm.test.manager;

import com.itesm.test.dao.WorkHoursDAO;
import com.itesm.test.dao.WorkHoursDAO;
import com.itesm.test.vo.WorkHoursVO;
import com.itesm.test.vo.WorkHoursVO;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mario on 11/21/2015.
 */
public class WorkHoursManager {
    public List<WorkHoursVO> listar(){
        WorkHoursDAO listaWorkHours = new WorkHoursDAO();
        return listaWorkHours.findAll();
    }

    public WorkHoursVO consultar(final String idConsulta){
        WorkHoursDAO consultaWorkHours = new WorkHoursDAO();
        return consultaWorkHours.findById(idConsulta);
    }

    public WorkHoursVO consultarPorAgenda(final String idConsulta){
        WorkHoursDAO consultaWorkHours = new WorkHoursDAO();
        return consultaWorkHours.findByAgendaId(idConsulta);
    }

    public void eliminar(final String idEliminar){
        WorkHoursDAO eliminarWorkHours = new WorkHoursDAO();
        eliminarWorkHours.delete(idEliminar);
    }

    public void actualizar(final WorkHoursVO persona){
        //TODO invocat al dao.update(persona);
        WorkHoursDAO dao = new WorkHoursDAO();
        dao.update(persona);
    }

    public void agregar(final WorkHoursVO workhours){
        WorkHoursDAO dao = new WorkHoursDAO();
        dao.insert(workhours.getDay(), workhours.getStart_date(),
                workhours.getEnd_date(), workhours.getAgenda_id());
    }
}
