/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import com.mycompany.models.Users;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MenuController{
    
    @FXML
    private Label labelid;
    
    @FXML
    private Label labeluser;
    
    
   @FXML
    private void switchTometerpiso() throws IOException {
        App.setRoot("meterpiso");
        App.loadMeterPisoWindow();
    }
    
    @FXML
    private void switchToverpisos() throws IOException {
        App.setRoot("verpisos");
    }
    
    @FXML
    private void switchTomodificarpiso() throws IOException {
        App.setRoot("modificarpiso");
    }
    
    @FXML
    private void switchTometergastos() throws IOException {
        App.setRoot("metergastos");
    }
    
    @FXML
    private void switchTogastostotal() throws IOException {
        App.setRoot("gastostotal");
    }
    
    public void prueba() throws IOException{
        labelid.setText(String.valueOf(App.user.getId()));
        labeluser.setText(App.user.getNombre());
    }

    @FXML
    private void switchToingresostotal() throws IOException {
        App.setRoot("ingresostotal");
    }
    
}
