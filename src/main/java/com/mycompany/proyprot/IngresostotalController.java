/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.IngresosDAO;
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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class IngresostotalController {
    @FXML
    private ComboBox seleccion;
    @FXML
    private Label ingresomuestra;
    Inmuebles casaselc = new Inmuebles();
    private InmuebleDAO listcasas;
    private IngresosDAO ingreso;
    private static Connection con;
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    /**
     * Este es el metodo que recarga la informacion segun se selecciona la casa
     */
    @FXML
    private void selectcasa(Event event){
       casaselc = (Inmuebles)seleccion.getSelectionModel().getSelectedItem();      
       cargardatos(casaselc);
    }
    
    /**
     * este es el metodo que rellena un combobox
     */
    public void desplegable() {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
            seleccion.setValue(casas.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * este es el metodo que carga la informacion del piso seleccionado
     * @param casa
     */
    public void cargardatos(Inmuebles casa){
        ingreso = new IngresosDAO();
        try {
            ingresomuestra.setText(String.valueOf(ingreso.ingresocasasuma(casa.getId_casa(), con)));
        } catch (SQLException ex) {
            Logger.getLogger(IngresostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IngresostotalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
