/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author PORTATIL 2
 */
public abstract class Casa {
    
    private int id_casa;
    public String calle;
    private int M_cuadrados;

    public Casa() {
     
    }
    public Casa(int id_casa, String calle, int M_cuadrados) {
        this.id_casa = id_casa;
        this.calle = calle;
        this.M_cuadrados = M_cuadrados;
    }
    
    public String getCalle() {
        return calle;
    }
    public int getM_cuadrados() {
        return M_cuadrados;
    }
    public int getId_casa() {
        return id_casa;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setM_cuadrados(int M_cuadrados) {
        this.M_cuadrados = M_cuadrados;
    }
    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("calle=").append(calle);
        sb.append(", M_cuadrados=").append(M_cuadrados);
        return sb.toString();
    }
    
}
