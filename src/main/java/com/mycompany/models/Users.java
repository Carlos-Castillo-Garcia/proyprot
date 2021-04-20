package com.mycompany.models;

import java.util.ArrayList;


/**
 *
 * @author CARLOS
 */
public class Users {
    private String nombre;
    private String contrasena;
    private String email;

    public Users() {
    }

    public Users(String nombre, String contrasena, String email) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
    }

    public Users(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nombre" + nombre + "\n contrasena" + contrasena + "\n email" + email;
    }
    
    public boolean Compcontrasena (String c){
        boolean comprobante = false;
        comprobante = c.matches(".*[A-Z].*");
        if(c.length()>=8){
           comprobante= true;
        }
        return comprobante;
    }

    public boolean Compnombre(String n){
        boolean comprobante = false;
        if(n.length()>= 6){
            comprobante = true;
        }
        return comprobante;
    }

    public boolean Compemail(String e){
        boolean comprobante = false;
        if(e.matches("[-\\w\\.]+@[a-z]+\\.[a-z]+")){
            comprobante = true;
        }else{
            return comprobante;
        }
        return comprobante;
    }
    
}
