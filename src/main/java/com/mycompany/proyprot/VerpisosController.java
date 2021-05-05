/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.GastosDAO;
import com.mycompany.DAO.IngresosDAO;
import com.mycompany.DAO.InmuebleDAO;
import com.mycompany.models.Inmuebles;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ismael m
 */
public class VerpisosController{
    
    @FXML
    private ComboBox seleccion;
    @FXML
    private Label fc;
    @FXML
    private Label mc;
    @FXML
    private Label nh;
    @FXML
    private Label ni;
    @FXML
    private Label pa;
    @FXML
    private Label gastos;
    @FXML
    private Label ingresos;
    @FXML
    private Label beneficios;
    private InmuebleDAO listcasas;
    private GastosDAO gastototal;
    private IngresosDAO ingresostotal;
    private static Connection con;
    Inmuebles casaselc = new Inmuebles();
    Inmuebles casadel = new Inmuebles();

    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    @FXML
    private void selectcasa(Event event){
       casaselc = (Inmuebles)seleccion.getSelectionModel().getSelectedItem();      
       cargardatos(casaselc);
    }
    
    /**
     *
     */
    public void desplegable() {
        listcasas = new InmuebleDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Inmuebles> casas = FXCollections.observableArrayList(listcasas.listaInmuebles(con));
            seleccion.setItems(casas);
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (IOException ex) {
            AlertaUtil.mostrarError("boton no relleno");
        } catch (SQLException ex) {
            Logger.getLogger(ModificarpisoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param casa
     */
    public void cargardatos(Inmuebles casa){
        gastototal= new GastosDAO();
        ingresostotal= new IngresosDAO();
        try {
            fc.setText(String.valueOf(casa.getFecha_compra()));
            mc.setText(String.valueOf(casa.getM_cuadrados()));
            nh.setText(String.valueOf(casa.getN_habitaciones()));
            ni.setText(String.valueOf(casa.getN_inquilinos()));
            pa.setText(String.valueOf(casa.getPrecio_alquiler()));
            gastos.setText(String.valueOf(gastototal.gastocasasuma(casa.getId_casa(), con)));
            ingresos.setText(String.valueOf(ingresostotal.ingresocasasuma(casa.getId_casa(), con)));
            beneficios.setText(String.valueOf((ingresostotal.ingresocasasuma(casa.getId_casa(), con))-(gastototal.gastocasasuma(casa.getId_casa(), con))));
        } catch (SQLException ex) {
            Logger.getLogger(VerpisosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerpisosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerpisosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void borrar_piso(){
            casadel = (Inmuebles)seleccion.getSelectionModel().getSelectedItem(); 
            if (casadel == null) {
                AlertaUtil.mostrarError("No se ha seleccionado ningun piso");
                return;
                }
        try {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar Ruta");
            confirmacion.setContentText("¿Estás seguro de querer eliminar este piso?");
            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if (respuesta.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE)
                return;
            listcasas.del_piso(casaselc, con);
            desplegable();
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("Error al eliminar el piso seleccionada. " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerpisosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerpisosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
