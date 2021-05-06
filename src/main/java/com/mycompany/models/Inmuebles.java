/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private Inmuebles(String[] importcasas) {
        super(Integer.parseInt(importcasas[0]), importcasas[1],Integer.parseInt(importcasas[2]));
        this.n_habitaciones = Integer.parseInt(importcasas[3]);
        this.precio_compra = Integer.parseInt(importcasas[4]);
        this.precio_alquiler = Integer.parseInt(importcasas[5]);
        this.n_inquilinos = Integer.parseInt(importcasas[6]);
        this.fecha_compra = Date.valueOf(importcasas[7]);
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

    @Override
    public boolean comprobar() {
            boolean compfich = false;
            ArrayList <Inmuebles> casaimport = new ArrayList <Inmuebles>();
            File fichero = null;
            FileReader lector = null;
            BufferedReader buffer = null;
        try {
            fichero = new File("Importcasas.txt");
            lector = new FileReader(fichero);
            buffer = new BufferedReader(lector);
            String linea = null;
            String[] importcasas;
            while((linea = buffer.readLine()) != null){
                    importcasas = linea.split(",");
                    casaimport.add(new Inmuebles(importcasas));
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        //comprobar el array list
        return compfich;
    }

    @Override
    public void importar() {
        if(comprobar() != false){
            ArrayList <Inmuebles> casaimport = new ArrayList <Inmuebles>();
            File fichero = null;
            FileReader lector = null;
            BufferedReader buffer = null;
        try {
            fichero = new File("Importcasas.txt");
            lector = new FileReader(fichero);
            buffer = new BufferedReader(lector);
            String linea = null;
            String[] importcasas;
            while((linea = buffer.readLine()) != null){
                    importcasas = linea.split(",");
                    casaimport.add(new Inmuebles(importcasas));
                }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Inmuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
