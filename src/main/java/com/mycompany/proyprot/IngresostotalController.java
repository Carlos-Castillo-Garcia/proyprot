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
        try {
            cargardatos(casaselc);
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("1. Fallo en la recarga de datos\n" + ex.getMessage());
        }
    }
    
    /**
     * este es el metodo que rellena un combobox
     */
    public void desplegable() throws SQLException {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
            seleccion.setValue(casas.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo al rellenar el comboBox\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("2. Fallo al rellenar el comboBox\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("3. Fallo al rellenar el comboBox\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    /**
     * este es el metodo que carga la informacion del piso seleccionado
     * @param casa
     */
    public void cargardatos(Inmuebles casa) throws SQLException{
        ingreso = new IngresosDAO();
        try {
            con = ConnDAO.conectar();
            ingresomuestra.setText(String.valueOf(ingreso.ingresocasasuma(casa.getId_casa(), con)));
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("1. Fallo al mostra los datos de los label\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("2. Fallo al mostra los datos de los label\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo al mostra los datos de los label\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
}
