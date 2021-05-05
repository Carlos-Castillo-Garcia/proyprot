/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import javafx.scene.control.Alert;

/**
 *
 * @author CARLOS
 */
public class AlertaUtil {
    
    /**
     *
     * @param mensaje
     */
    public static void mostrarError(String mensaje){
        Alert alerta = new Alert (Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje
     */
    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje
     */
    public static void mostrarWarning(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje
     */
    public static void mostrarConfirmation(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     *
     * @param mensaje
     */
    public static void mostrarCabecera(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
