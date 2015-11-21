package com.itesm.test.dao;

import com.itesm.test.vo.AgendaVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by mario on 11/18/2015.
 */
public class AgendaDAO {
    public AgendaVO findById(String givenId){
        AgendaVO personasPorId = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, "
                    + "start_date, end_date, hours_left FROM agenda "
                    + "WHERE id="+givenId);
            ResultSet rs = pstmt.executeQuery();

            //if when we only wait for one
            if(rs.next()){
                personasPorId = new AgendaVO();
                personasPorId.setId(rs.getString(1));
                personasPorId.setStart_date(rs.getString(2));
                personasPorId.setEnd_date(rs.getString(3));
                personasPorId.setHours_left(rs.getString(4));

            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return personasPorId;
    }

    public AgendaVO insert(final String start_date, final String end_date, final String hours_left){
        AgendaVO persona = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO agenda (start_date, end_date,"
                    + " hours_left)" + "VALUES (?, ?, ?)");
            pstmt.setString(1, start_date);
            pstmt.setString(2, end_date);
            pstmt.setString(3, hours_left);
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = conn.prepareStatement("SELECT_LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                persona = new AgendaVO();
                persona.setId(rs.getString(1));
                persona.setStart_date(start_date);
                persona.setEnd_date(end_date);
                persona.setHours_left(hours_left);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return persona;
    }
    public void delete(final String givenId){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM agenda WHERE id="+givenId);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    public List<AgendaVO> findAll() {
        List<AgendaVO> personas = new ArrayList<AgendaVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, start_date, "
                    + "end_date, hours_left FROM agenda"
                    + "ORDER BY id");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                AgendaVO agenda = new AgendaVO();
                agenda.setId(rs.getString(1));
                agenda.setStart_date(rs.getString(2));
                agenda.setEnd_date(rs.getString(3));
                agenda.setHours_left(rs.getString(4));

                personas.add(agenda);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return personas;
    }

    public void update(final AgendaVO agenda){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            if(null != agenda){

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
                PreparedStatement pstmt = conn.prepareStatement("UPDATE persona " +
                        "SET start_date=?, end_date=?, hours_left=?, agenda_id=? " + "WHERE id=?");
                pstmt.setString(1, agenda.getStart_date());
                pstmt.setString(2, agenda.getEnd_date());
                pstmt.setString(3, agenda.getHours_left());
                pstmt.setString(5, agenda.getId());

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
}
