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
    private IngresosDAO ingreso;
    private static Connection con;
    Inmuebles casaselc = new Inmuebles();
    Inmuebles casainsert = new Inmuebles();
        
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    /**
     * Este es el metodo que rellena el combobox
     */
    public void desplegable() throws SQLException {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
            seleccion.setValue(casas.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo en el relleno del comboBox\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("2. Fallo en el relleno del comboBox\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("3. Fallo en el relleno del comboBox\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
    }
    
    /**
     * Este es el metodo que recoge toda la informacion modificada del piso seleccionado
     */
    @FXML
    private void insertarpiso() throws SQLException{
        casainsert = casaselc;

        try {
            con = ConnDAO.conectar();
            ingreso = new IngresosDAO();
            casainsert.setN_habitaciones(Integer.parseInt(NHabitaciones.getText()));
            casainsert.setN_inquilinos(Integer.parseInt(NInquilinos.getText()));
            casainsert.setPrecio_alquiler(Integer.parseInt(alquiler.getText()));
            listcasas.modpiso(casainsert, con);
            ingreso.insert_ingresos(casainsert, con);
            AlertaUtil.mostrarInfo("Piso modificado e ingreso insertado");
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("1. Fallo en la insercion del piso\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("2. Fallo en la insercion del piso\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo en la insercion del piso\n" + ex.getMessage());
        }finally{
            ConnDAO.desconexion(con);
        }
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
     * Este es el metodo que inserta la informacion del piso seleccionado en los campos a visualizar
     * @param casa
     */
    public void cargardatos(Inmuebles casa){
        NHabitaciones.setText(String.valueOf(casa.getN_habitaciones()));
        NInquilinos.setText(String.valueOf(casa.getN_inquilinos()));
        alquiler.setText(String.valueOf(casa.getPrecio_alquiler()));
    }
}
