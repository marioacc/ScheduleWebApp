/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.vo;

import java.io.Serializable;

/**
 *
 * @author Dave
 */
public class PersonaVO implements Serializable{
    private String id;
    private String nombre;
    private String password;
    private String mail;
    private String agenda_id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(String agenda_id) {
        this.agenda_id = agenda_id;
    }



    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido_paterno
     */
    @Override
    public String toString(){
        return this.id + " " + this.nombre + " " + this.mail;
    }
    
    @Override
    public boolean equals(Object otro){
        if(otro instanceof PersonaVO){
            return this.id.equals(((PersonaVO)otro).id);
        } else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}
