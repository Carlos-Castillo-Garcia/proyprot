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
     * Este es un alert que muestra los errores
     * @param mensaje
     */
    public static void mostrarError(String mensaje){
        Alert alerta = new Alert (Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     * Este es un alert que muestra informacion
     * @param mensaje
     */
    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     * Este es un alert que muestra los avisos
     * @param mensaje
     */
    public static void mostrarWarning(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /**
     * Este es un alert que muestra las confirmaciones
     * @param mensaje
     */
    public static void mostrarConfirmation(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
