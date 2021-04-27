/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.GastosDAO;
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
public class GastostotalController{ 
    @FXML
    private ComboBox seleccion;
    @FXML
    private Label gat;
    @FXML
    private Label glt;
    @FXML
    private Label ggt;
    @FXML
    private Label grft;
    @FXML
    private Label grpt;
    @FXML
    private Label gct;
    @FXML
    private Label gtt;
    @FXML
    private Label gac;
    @FXML
    private Label glc;
    @FXML
    private Label ggc;
    @FXML
    private Label grfc;
    @FXML
    private Label grpc;
    @FXML
    private Label gcc;
    @FXML
    private Label gtc;
    Inmuebles casaselc = new Inmuebles();
    private InmuebleDAO listcasas;
    private GastosDAO gastos;
    private static Connection con;
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    @FXML
    private void selectcasa(Event event){
       casaselc = (Inmuebles)seleccion.getSelectionModel().getSelectedItem();      
       cargardatos(casaselc);
    }
    
    public void desplegable() {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
            cargardatostotal();
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargardatostotal(){
        gastos= new GastosDAO();
        try {
            gat.setText(String.valueOf(gastos.gastoaguatotal(con)));
            glt.setText(String.valueOf(gastos.gastoluztotal(con)));
            ggt.setText(String.valueOf(gastos.gastogastotal(con)));
            grft.setText(String.valueOf(gastos.gastoreformatotal(con)));
            grpt.setText(String.valueOf(gastos.gastoreparaciontotal(con)));
            gct.setText(String.valueOf(gastos.gastocomunidadtotal(con)));
            gtt.setText(String.valueOf(gastos.gastototaltotal(con)));
        } catch (SQLException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargardatos(Inmuebles casa){
        gastos= new GastosDAO();
        try {
            gac.setText(String.valueOf(gastos.gastoaguacasa(casa.getId_casa(), con)));
            glc.setText(String.valueOf(gastos.gastoluzcasa(casa.getId_casa(), con)));
            ggc.setText(String.valueOf(gastos.gastogascasa(casa.getId_casa(), con)));
            grfc.setText(String.valueOf(gastos.gastoreformacasa(casa.getId_casa(), con)));
            grpc.setText(String.valueOf(gastos.gastoreparacioncasa(casa.getId_casa(), con)));
            gcc.setText(String.valueOf(gastos.gastocomunidadcasa(casa.getId_casa(), con)));
            gtc.setText(String.valueOf(gastos.gastototalcasa(casa.getId_casa(), con)));
        } catch (SQLException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GastostotalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
