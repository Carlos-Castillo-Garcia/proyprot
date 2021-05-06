package com.mycompany.models;

import java.util.ArrayList;


/**
 *
 * @author CARLOS
 */
public class Users {
    private int id;
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
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "nombre" + nombre + "\n contrasena" + contrasena + "\n email" + email;
    }
    
    /**
     * Es el metodo que te permite comprobar la contraseña que introduce el usuario
     * @param c
     * @return
     */
    public boolean Compcontrasena (String c){
        boolean comprobante = false;
        if(c.length()>=8 && c.matches(".*[A-Z].*")){
           comprobante= true;
        }
        return comprobante;
    }

    /**
     * Es el metodo que te permite comprobar el nombre que introduce el usuario
     * @param n
     * @return
     */
    public boolean Compnombre(String n){
        boolean comprobante = false;
        if(n.length()>= 6){
            comprobante = true;
        }
        return comprobante;
    }

    /**
     * Es el metodo que te permite comprobar el email que introduce el usuario
     * @param e
     * @return
     */
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
