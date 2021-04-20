package com.mycompany.proyprot;

import com.mycompany.DAO.UserDAO;
import com.mycompany.models.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InicioController {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    
    private static UserDAO compuser;
    
    @FXML
    private void switchToregistro() throws IOException {
        
    }
    
    @FXML
    private void login() throws IOException, ClassNotFoundException{
        boolean tokenuser = false;
        boolean tokenpass = false;
        try {
            compuser = new UserDAO();
            compuser.conectar();
            ArrayList <Users> users = new ArrayList(compuser.username());
            for(int i = 0; i <= users.size();i++){
                if(user.getText().equals(users.get(i).getNombre())){
//                    tokenuser = true;
                    if(password.getText().equals(users.get(i).getContrasena())){
//                        tokenpass = true;
                        App.setRoot("menu");
                    }
                }
            }
//            if(tokenuser == true && tokenpass == true){
//                App.setRoot("menu");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
