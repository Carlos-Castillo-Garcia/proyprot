package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasena;
    @FXML
    private Label resultado;
    
    @FXML
    private void logok() throws IOException {
        
        String user = usuario.getText();
        String pass = contrasena.getText();
        Usuario u = new Usuario();
        boolean comp = u.Compnombre(user);
        boolean comppass = u.Compcontrasena(pass);
        if(comp){
           if(comppass){
               App.setRoot("menuprot");
           }else{
               resultado.setText("Login incorrecto");
           }
        }else{
            resultado.setText("Login erroreno");
        }
    }
        @FXML
    private void registrarse() throws IOException{
        App.setRoot("registro");
    }
}
