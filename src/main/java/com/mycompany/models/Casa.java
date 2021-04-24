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

    private String calle;
    public int M_cuadrados;

    public Casa(String calle, int M_cuadrados) {
        this.calle = calle;
        this.M_cuadrados = M_cuadrados;
    }

    public Casa() {
    }

    public String getCalle() {
        return calle;
    }

    public int getM_cuadrados() {
        return M_cuadrados;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setM_cuadrados(int M_cuadrados) {
        this.M_cuadrados = M_cuadrados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("calle=").append(calle);
        sb.append(", M_cuadrados=").append(M_cuadrados);
        return sb.toString();
    }
    
    
    
}
