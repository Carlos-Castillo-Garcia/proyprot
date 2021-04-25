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
    
        
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    
    public void desplegable() throws SQLException {
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
