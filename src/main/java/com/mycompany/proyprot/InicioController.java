package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InicioController {

    @FXML
    private void switchToregistro() throws IOException {
        App.setRoot("registros");
    }
    
    @FXML
    private void switchTomenu() throws IOException{
        TextField user;
        TextField Password;
        
        //Label correcto = " ";
    }
}
