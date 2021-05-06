/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.InmuebleDAO;
import com.mycompany.models.Inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MeterpisoController{   
    @FXML
    private TextField direcion;
    @FXML
    private TextField metros;
    @FXML
    private TextField habitaciones;
    @FXML
    private TextField precio_compra;
    @FXML
    private TextField precio_alquiler;
    @FXML
    private DatePicker fecha_compra;
    
    private static InmuebleDAO inmueble; 
    private static Connection con;
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    /**
     * Este es el metodo que recoge los datos para ingresar un nuevo piso
     */
    @FXML
    private void ingreso_piso() throws IOException, SQLException{
        inmueble = new InmuebleDAO();
        Inmuebles casa = new Inmuebles();
        try {
                con = ConnDAO.conectar();
            } catch (ClassNotFoundException ex) {
                AlertaUtil.mostrarError("Conexion erronea");
            }
        Date date = Date.valueOf(fecha_compra.getValue());
        int habitaciones_value = Integer.parseInt(habitaciones.getText());
        int metros_value = Integer.parseInt(metros.getText());
        int precio_compra_value = Integer.parseInt(precio_compra.getText());
        int precio_alquiler_value = Integer.parseInt(precio_alquiler.getText());
        String direccion = direcion.getText();
        
        try {
            casa = new Inmuebles(-1, direccion, metros_value,habitaciones_value, precio_compra_value, precio_alquiler_value, -1, date);
            inmueble.insert_piso(casa, con);
            AlertaUtil.mostrarInfo("Piso ingresado");
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Error mirar en la consola");
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error en la sentencia sql");
        }finally{
            ConnDAO.desconexion(con);
        }
    }

}
