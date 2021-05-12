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
public class MetergastosController {

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
    private void switchTomenu() throws IOException {
        App.setRoot("menu");
    }

    /**
     * este es el metodo que rellena un combobox con las casas
     */
    public void desplegablecasa() throws SQLException {
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
        } finally {
            ConnDAO.desconexion(con);
        }
    }

    /**
     * Este es el metodo que seleccina la informacion segun se selecciona la
     * casa
     */
    @FXML
    private void selectcasa(Event event) {
        casaselc = (Inmuebles) seleccion.getSelectionModel().getSelectedItem();
    }

    /**
     * este es el metodo que rellena un combobox con los gastos
     */
    public void desplegablegasto() throws SQLException {
        listgastos = new GastosDAO();
        try {
            con = ConnDAO.conectar();
            ObservableList<Tipo_Gasto> tipos_gastos = FXCollections.observableArrayList(listgastos.selectgastos(con));
            seleccion_gasto.setItems(tipos_gastos);
            seleccion_gasto.setValue(tipos_gastos.get(0));
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo en el rellenado del comboBox\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("2. Fallo en el rellenado del comboBox\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("3. Fallo en el rellenado del comboBox\n" + ex.getMessage());
        } finally {
            ConnDAO.desconexion(con);
        }
    }

    /**
     * Este es el metodo que selecciona la informacion segun se selecciona el
     * tipo de gasto
     */
    @FXML
    private void selectgasto(Event event) {
        gastoselec = (Tipo_Gasto) seleccion_gasto.getSelectionModel().getSelectedItem();
    }

    /**
     * Este es el metodo que ingresa un gasto de la casa seleccionada
     */
    @FXML
    private void ingresargasto() throws SQLException {
        listgastos = new GastosDAO();
        Gastos isrtgasto = new Gastos();
        try {
            con = ConnDAO.conectar();
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("1. Fallo en la Conexion a la base de datos\n" + ex.getMessage());
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("2. Fallo en la Conexion a la base de datos\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo en la Conexion a la base de datos\n" + ex.getMessage());
        }

        Date date = Date.valueOf(fg.getValue());
        try {
            isrtgasto = new Gastos(Integer.parseInt(nf.getText()), pro.getText(), Integer.parseInt(pre.getText()), date, gastoselec.getId_tipo_gasto(), casaselc.getId_casa());
            listgastos.insertgasto(isrtgasto, con);
            AlertaUtil.mostrarInfo("Gasto metido");
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("1. Fallo en la insercion de datos\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("2. Fallo en la insercion de datos\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("3. Fallo en la insercion de datos\n" + ex.getMessage());
        } finally {
            ConnDAO.desconexion(con);
        }

    }
}
