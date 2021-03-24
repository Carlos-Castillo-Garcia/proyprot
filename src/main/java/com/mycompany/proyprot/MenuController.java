/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MenuController extends LoginController{
    @FXML
    private Label usuariologeado;
    
    private void prueba(){
        usuariologeado.setText("EL ususario");
    }
}
