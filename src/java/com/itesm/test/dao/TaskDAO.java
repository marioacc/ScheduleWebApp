package com.itesm.test.dao;

import com.itesm.test.vo.TaskVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mario on 11/21/2015.
 */
public class TaskDAO {

    public List<TaskVO> findAll(){
        List<TaskVO> tasks = new ArrayList<TaskVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, day, start_time"
                    + ", end_time, priority, work_hours_id, description, agenda_id FROM task "
                    + "ORDER BY id");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                TaskVO task = new TaskVO();
                task.setId(rs.getString(1));
                task.setDay(rs.getInt(2));
                task.setEnd_date(rs.getTimestamp(4));
                task.setPriority(rs.getInt(5));
                task.setWork_hours_id(rs.getString(6));
                task.setDescription(rs.getString(7));
                task.setAgenda_id(rs.getString(8));
                task.setStart_date();

                tasks.add(task);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return tasks;
    }

    public TaskVO findById(String givenId){
        TaskVO tasksPorId = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, day, start_time"
                    + ", end_time, priority, work_hours_id, description, agenda_id FROM task "
                    + "WHERE id=" + givenId);
            ResultSet rs = pstmt.executeQuery();

            //if when we only wait for one
            if(rs.next()){
                tasksPorId = new TaskVO();
                tasksPorId.setId(rs.getString(1));
                tasksPorId.setDay(rs.getInt(2));
                tasksPorId.setEnd_date(rs.getTimestamp(4));
                tasksPorId.setPriority(rs.getInt(5));
                tasksPorId.setWork_hours_id(rs.getString(6));
                tasksPorId.setDescription(rs.getString(7));
                tasksPorId.setAgenda_id(rs.getString(8));
                tasksPorId.setStart_date();

            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return tasksPorId;
    }
    public List<TaskVO> findByWorkhoursId (String givenId){
        List<TaskVO> tasks = new ArrayList<TaskVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, day, start_time"
                    + ", end_time, priority, work_hours_id,description,agenda_id FROM task "
                    + "WHERE work_hours_id=" + givenId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                TaskVO task = new TaskVO();
                task.setId(rs.getString(1));
                task.setDay(rs.getInt(2));
                task.setEnd_date(rs.getTimestamp(4));
                task.setPriority(rs.getInt(5));
                task.setWork_hours_id(rs.getString(6));
                task.setDescription(rs.getString(7));
                task.setAgenda_id(rs.getString(8));
                task.setStart_date();

                tasks.add(task);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return tasks;
    }
    public List<TaskVO> findByAgenda(String givenId){
        List<TaskVO> tasks = new ArrayList<TaskVO>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, day, start_time"
                    + ", end_time, priority, work_hours_id,description,agenda_id FROM task "
                    + "WHERE agenda_id=" + givenId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                TaskVO task = new TaskVO();
                task.setId(rs.getString(1));
                task.setDay(rs.getInt(2));
                task.setEnd_date(rs.getTimestamp(4));
                task.setPriority(rs.getInt(5));
                task.setWork_hours_id(rs.getString(6));
                task.setDescription(rs.getString(7));
                task.setAgenda_id(rs.getString(8));
                task.setStart_date();

                tasks.add(task);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return tasks;
    }

    public void delete(final String givenId){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM task WHERE id="+givenId);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }


    public void update(final TaskVO task){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            if(null != task){

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost/DB?user=root&password=admin");
                PreparedStatement pstmt = conn.prepareStatement("UPDATE task " +
                        "SET day=?, start_time=?, end_time=?, priority=?, work_hours_id=? " + "WHERE id=?");
                pstmt.setInt(1, task.getDay());
                pstmt.setTimestamp(2, task.getStart_date());
                pstmt.setTimestamp(3, task.getEnd_date());
                pstmt.setInt(4, task.getPriority());
                pstmt.setString(5, task.getWork_hours_id());

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }


    public TaskVO insert(final int day, final Timestamp start_date, final Timestamp end_date,
                         final int priority, final Time duration,final String description,final String work_hours_id){
        TaskVO task = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DB?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO task (day, start_time, end_time,priority"
                    + ",duration,work_hours_id)" + "VALUES (?, ?, ?, ?, ?,?)");
            pstmt.setInt(1, day);
            pstmt.setTimestamp(2, start_date);
            pstmt.setTimestamp(3, end_date);
            pstmt.setInt(4, priority);
            pstmt.setTime(5, duration);
            pstmt.setString(6,work_hours_id);
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                task = new TaskVO();
                task.setId(rs.getString(1));
                task.setDay(day);
                task.setEnd_date(end_date);
                task.setPriority(priority);
                task.setWork_hours_id(work_hours_id);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
        catch(SQLException sqle){
            Logger.getLogger(TaskDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return task;
    }
}
