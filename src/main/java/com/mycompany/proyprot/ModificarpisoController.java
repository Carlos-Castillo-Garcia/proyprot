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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ModificarpisoController{
    
    @FXML
    private ComboBox seleccion;
    @FXML
    private TextField NHabitaciones;
    @FXML
    private TextField NInquilinos;
    @FXML
    private TextField alquiler;
    
    private InmuebleDAO listcasas;
    private static Connection con;
    Inmuebles casaselc = new Inmuebles();
    Inmuebles casainsert = new Inmuebles();
        
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    public void desplegable() {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
            cargardatos(casas.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void insertarpiso(){
        casainsert = casaselc;
        
        try {
            con = ConnDAO.conectar();
            casainsert.setN_habitaciones(Integer.parseInt(NHabitaciones.getText()));
            casainsert.setN_inquilinos(Integer.parseInt(NInquilinos.getText()));
            casainsert.setPrecio_alquiler(Integer.parseInt(alquiler.getText()));
            listcasas.modpiso(casainsert, con);
            AlertaUtil.mostrarInfo("Piso modificado");
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error en la sentencia sql, piso no modificado");
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Error mirar en la consola");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("Error mirar en la consola");
        }
    }
    
    @FXML
    private void selectcasa(Event event){
       casaselc = (Inmuebles)seleccion.getSelectionModel().getSelectedItem();      
       cargardatos(casaselc);
    }
    
    public void cargardatos(Inmuebles casa){
        NHabitaciones.setText(String.valueOf(casa.getN_habitaciones()));
        NInquilinos.setText(String.valueOf(casa.getN_inquilinos()));
        alquiler.setText(String.valueOf(casa.getPrecio_alquiler()));
    }
}
