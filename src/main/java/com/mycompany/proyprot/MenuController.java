/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MenuController extends LoginController{
    @FXML
    private Label usuariologeado;
    
    @FXML
    private void prueba(){
        usuariologeado.setText("EL ususario");
    }
    
    @FXML
    private void atras() throws IOException{
        App.setRoot("login");
    }
    @FXML
    private void ingreso() throws IOException{
        App.setRoot("ingreso");
    }
    
    @FXML
    private void gasto() throws IOException{
        App.setRoot("gastos");
    }
    @FXML
    private void newpiso() throws IOException{
        App.setRoot("newpiso");
    }
}
