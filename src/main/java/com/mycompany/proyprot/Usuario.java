/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import java.util.ArrayList;


/**
 *
 * @author PORTATIL 2
 */
public class Usuario {
    private String nombre;
    private String passwd;
    private String email;
    
    /**
     *  @
     */
    public Usuario(){
    }

    /**
     *
     * @param n
     * @param pass
     * @param em
     * @param permisos
     */
    public Usuario(String n, String pass, String em){
        this.nombre = n;
        this.email = em;
        this.passwd = pass;
    }

    /**
     * @return the contraseña
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nombre the contraseña to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Metodo para el login, comprueba el usuario y contraseña que se introducen.
     * @param log un arraylist para el guardado de datos.
     * @param user el nombre de usuario a comparar
     * @param pass la contraseña asociada al nombre de usuario
     * @return un boleano que dice si se puede loguear o no.
     */
    public boolean login(ArrayList <Usuario> log, String user, String pass){
        boolean comprobante = false;
        for(Usuario i: log){
            if(i.getNombre().equals(user)){
                if(i.getPasswd().equals(pass)){
                    comprobante = true;
                }
            }
        } 
        return comprobante;
    }
    
    /**
     * Metodo para evitar introduccion de caracteres raros en la contraseña.
     * @param c la contraseña que se quiere comprobar.
     * @return un boleano que dice si la contraseña esta bien o no.
     */
    public boolean Compcontrasena (String c){
        boolean comprobante = false;
        if(c.matches(".*[A-Z].*")){
            if(c.length()>=8){
                comprobante= true;
            }else{
                comprobante = false;
            }
        }else{
            comprobante = false;
        }

        return comprobante;
    }
    
    /**
     * Metodo para evitar introduccion de caracteres raros en el nombre de ususario.
     * @param n el nombre de usuario que se quiere comprobar.
     * @return un boleano que dice si el nombre de usuario esta bien o no.
     */
    public boolean Compnombre(String n){
        boolean comprobante = false;
        if(n.length()>= 6){
            comprobante = true;
        }
        return comprobante;
    }
    
    /**
     * Metodo para evitar introduccion de caracteres raros en el email.
     * @param e la direccion de correo que se quiere comprobar.
     * @return un boleano que dice si el email esta bien o no.
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
