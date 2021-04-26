/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.sql.Date;

/**
 *
 * @author PORTATIL 2
 */
public class Inmuebles extends Casa {
    private int n_habitaciones;
    private int precio_compra;
    private int precio_alquiler;
    private int n_inquilinos;
    private Date fecha_compra;

    public Inmuebles() {
    }

    public Inmuebles(int id_casa, String calle, int M_cuadrados, int n_habitaciones, int precio_compra, int precio_alquiler, int n_inquilinos, Date fecha_compra) {
        super(id_casa, calle, M_cuadrados);
        this.n_habitaciones = n_habitaciones;
        this.precio_compra = precio_compra;
        this.precio_alquiler = precio_alquiler;
        this.n_inquilinos = n_inquilinos;
        this.fecha_compra = fecha_compra;
    }

    public int getN_habitaciones() {
        return n_habitaciones;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }
    
    public int getPrecio_alquiler() {
        return precio_alquiler;
    }

    public int getN_inquilinos() {
        return n_inquilinos;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }
    
    public void setN_habitaciones(int n_habitaciones) {
        this.n_habitaciones = n_habitaciones;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }
    
    public void setPrecio_alquiler(int precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    public void setN_inquilinos(int n_inquilinos) {
        this.n_inquilinos = n_inquilinos;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("n_habitaciones=").append(n_habitaciones);
//        sb.append(", precio_compra=").append(precio_compra);
//        sb.append(", precio_alquiler=").append(precio_alquiler);
//        sb.append(", n_inquilinos=").append(n_inquilinos);
//        sb.append(", fecha_compra=").append(fecha_compra);
        return calle;
    }
    
    public String cont_desp(){
        return calle;
    }

    
    
}
