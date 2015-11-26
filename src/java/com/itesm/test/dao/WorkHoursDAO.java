package com.itesm.test.dao;
import com.itesm.test.vo.WorkHoursVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by mario on 11/21/2015.
 */
public class WorkHoursDAO {
    public List<WorkHoursVO> findAll(){
        List<WorkHoursVO> workhourss = new ArrayList<WorkHoursVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, nombre, "
                    + "password, mail, agenda_id FROM workhours "
                    + "ORDER BY id");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                WorkHoursVO workhours = new WorkHoursVO();
                workhours.setId(rs.getString(1));
                workhours.setDay(rs.getInt(2));
                workhours.setStart_date(rs.getTime(3));
                workhours.setEnd_date(rs.getTime(4));
                workhours.setAgenda_id(rs.getString(5));

                workhourss.add(workhours);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return workhourss;
    }

    public List<WorkHoursVO> findByAgendaId(String givenId){
        List<WorkHoursVO> workhours = new ArrayList<WorkHoursVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, day, "
                    + "start_time, end_time, agenda_id FROM work_hours "
                    + "WHERE agenda_id =" +givenId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                WorkHoursVO wh = new WorkHoursVO();
                wh.setId(""+rs.getInt(1));
                wh.setDay(rs.getInt(2));
                wh.setStart_date(rs.getTime(3));
                wh.setEnd_date(rs.getTime(4));
                wh.setAgenda_id(""+rs.getInt(5));

                workhours.add(wh);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return workhours;
    }

    public WorkHoursVO findById(String givenId){
        WorkHoursVO workhourssPorId = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, nombre, "
                    + "apellido_paterno, apellido_materno, alias FROM work_hours "
                    + "WHERE id="+givenId);
            ResultSet rs = pstmt.executeQuery();

            //if when we only wait for one
            if(rs.next()){
                WorkHoursVO workhours = new WorkHoursVO();
                workhours.setId(rs.getString(1));
                workhours.setDay(rs.getInt(2));
                workhours.setStart_date(rs.getTime(3));
                workhours.setEnd_date(rs.getTime(4));
                workhours.setAgenda_id(rs.getString(5));

            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return workhourssPorId;
    }

    public void delete(final String givenId){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM work_hours WHERE id="+givenId);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }


    public void update(final WorkHoursVO workhours){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            if(null != workhours){

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/DB?user=root&password=admin");
                PreparedStatement pstmt = conn.prepareStatement("UPDATE work_hours " +
                        "SET day=?, start_date=?, end_date=?, agenda_id=? " + "WHERE id=?");
                pstmt.setInt(1, workhours.getDay());
                pstmt.setTime(2, workhours.getStart_date());
                pstmt.setTime(3, workhours.getEnd_date());
                pstmt.setString(4, workhours.getAgenda_id());
                pstmt.setString(5, workhours.getId());

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }



    public WorkHoursVO insert(final int day, final Time start_date, final Time end_date, final String agenda_id){
        WorkHoursVO workhours = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO work_hours (day, start_time, end_time,"
                    + "agenda_id)" + "VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, day);
            pstmt.setTime(2, start_date);
            pstmt.setTime(3, end_date);
            pstmt.setString(4, agenda_id);

            pstmt.executeUpdate();
            pstmt.close();

            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                workhours = new WorkHoursVO();
                workhours.setId(rs.getString(1));
                workhours.setDay(day);
                workhours.setStart_date(start_date);
                workhours.setEnd_date(end_date);
                workhours.setAgenda_id(agenda_id);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(WorkHoursDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return workhours;
    }
}
