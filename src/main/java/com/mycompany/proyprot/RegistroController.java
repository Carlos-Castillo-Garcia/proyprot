package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController {


    @FXML
    private TextField reguser;
    
    @FXML
    private TextField regemail;
    
    @FXML
    private PasswordField regpass1;
    
    @FXML
    private PasswordField regpass2;
    
    @FXML
    private Label erroresreg;
    
    @FXML
    private void register(){
        Usuario temp = new Usuario();
        String user = reguser.getText();
        String email = regemail.getText();
        String pass1 = regpass1.getText();
        String pass2 = regpass2.getText();
        boolean compuser = temp.Compnombre(user);
        boolean compemail = temp.Compemail(email);
        boolean comppass = temp.Compcontrasena(pass1);
        
        if(compuser){
            if(compemail){
                if(comppass){
                    if(pass2.equals(pass1)){
                        erroresreg.setText("Usuario registrado");
                    }else{
                        erroresreg.setText("Las contraseña no coinciden");
                    }
                }else{
                    erroresreg.setText("La contraseña no cumplea las caracteristicas");
                }
            }else{
                erroresreg.setText("Email incorrecto");
            }
        }else{
            erroresreg.setText("El nombre de usuario no cumple los requisitos");
        }
    }
    
    @FXML
    private void goback() throws IOException{
        App.setRoot("login");
    }
}