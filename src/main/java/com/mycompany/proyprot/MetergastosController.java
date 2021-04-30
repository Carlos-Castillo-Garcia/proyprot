/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.GastosDAO;
import com.mycompany.DAO.InmuebleDAO;
import com.mycompany.models.Gastos;
import com.mycompany.models.Inmuebles;
import com.mycompany.models.Tipo_Gasto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MetergastosController{
    
    @FXML
    private ComboBox seleccion;
    @FXML
    private ComboBox seleccion_gasto;
    @FXML
    private TextField nf;
    @FXML
    private DatePicker fg;
    @FXML
    private TextField pro;
    @FXML
    private TextField pre;
    
    private InmuebleDAO listcasas;
    private GastosDAO listgastos;
    private static Connection con;
    Inmuebles casaselc = new Inmuebles();
    Tipo_Gasto gastoselec = new Tipo_Gasto();

    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    public void desplegablecasa() {
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
    
    @FXML
    private void selectcasa(Event event){
       casaselc = (Inmuebles)seleccion.getSelectionModel().getSelectedItem();      
    }
    
    public void desplegablegasto() {
        listgastos = new GastosDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Tipo_Gasto> tipos_gastos = FXCollections.observableArrayList(listgastos.selectgastos(con));
            seleccion_gasto.setItems(tipos_gastos);
            seleccion_gasto.setValue(tipos_gastos.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void selectgasto(Event event){
       gastoselec = (Tipo_Gasto)seleccion_gasto.getSelectionModel().getSelectedItem();  
    }
    
    @FXML
    private void ingresargasto(){
            listgastos = new GastosDAO();
            Gastos isrtgasto = new Gastos();
        try {
            con = ConnDAO.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MetergastosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MetergastosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MetergastosController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            Date date = Date.valueOf(fg.getValue());
        try {
            isrtgasto = new Gastos(Integer.parseInt(nf.getText()), pro.getText(), Integer.parseInt(pre.getText()), date, gastoselec.getId_tipo_gasto(), casaselc.getId_casa());
            listgastos.insertgasto(isrtgasto, con);
            AlertaUtil.mostrarInfo("Gasto metido");
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error SQL");
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("Mirar en consola");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("Mirar en consola");
        }
            
    }
    
}
