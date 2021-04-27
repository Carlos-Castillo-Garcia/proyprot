/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author CARLOS
 */
public class Tipo_Gasto {
    
    private int id_tipo_gasto;
    private String detalles;

    public Tipo_Gasto() {
    }

    public Tipo_Gasto(int id_tipo_gasto, String detalles) {
        this.id_tipo_gasto = id_tipo_gasto;
        this.detalles = detalles;
    }

    /**
     * @return the id_tipo_gasto
     */
    public int getId_tipo_gasto() {
        return id_tipo_gasto;
    }

    /**
     * @return the detalles
     */
    public String getDetalles() {
        return detalles;
    }

    /**
     * @param id_tipo_gasto the id_tipo_gasto to set
     */
    public void setId_tipo_gasto(int id_tipo_gasto) {
        this.id_tipo_gasto = id_tipo_gasto;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(detalles);
        return sb.toString();
    }
    
    
}
