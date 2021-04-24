/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MeterpisoController {   
    @FXML
    private Label labelusu;
    
    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
    public void prueba() throws IOException{
        labelusu.setText(App.user.getNombre());
    }

}
