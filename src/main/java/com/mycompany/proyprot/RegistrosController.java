package com.mycompany.proyprot;

import com.mycompany.DAO.UserDAO;
import com.mycompany.models.Users;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrosController {

    @FXML
    private TextField newuser;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    
    private static UserDAO user;
    
    @FXML
    private void switchToinicio() throws IOException {
        App.setRoot("inicio");
    }
    @FXML
    private void registrarse() throws IOException{
       user = new UserDAO();
       boolean compuser; 
       boolean compemail;
       boolean comppass;
       /*inicio de registro de usuarios*/
    }
}