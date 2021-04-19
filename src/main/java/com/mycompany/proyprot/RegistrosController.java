package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.UserDAO;
import com.mycompany.models.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private static ConnDAO con;
    private static UserDAO user;
    
    @FXML
    private void switchToinicio() throws IOException {
        App.setRoot("inicio");
    }
    @FXML
    private void registrarse() throws IOException, SQLException{
            con = new ConnDAO();
            Users reguser = new Users();
            boolean compuser = false;
            boolean compemail = false;
            boolean comppass = false;
                if(reguser.Compnombre(newuser.getText())) {
                      compuser = true;
                }else{
                    compuser = false;
                }
                if(compuser == true){
                    if(reguser.Compemail(email.getText())){
                        comppass = true;
                    }else{
                        comppass = false;
                    }
                }                
                if(compuser == true && comppass == true){
                    if(reguser.Compcontrasena(pass1.getText())){
                            comppass = true;
                    }else{
                        comppass = false;
                    }
                }
                if(compuser == true && comppass == true && compemail == true) {
                    try {
                        reguser = new Users(newuser.getText(), email.getText(), pass1.getText());
                        con.conectar();
                        user.insertar(reguser);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RegistrosController.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
    }
}