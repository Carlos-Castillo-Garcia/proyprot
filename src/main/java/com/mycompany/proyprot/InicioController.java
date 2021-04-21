package com.mycompany.proyprot;

import com.mycompany.DAO.UserDAO;
import com.mycompany.DAO.ConnDAO;
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
        App.setRoot("registros");
    }
    
    @FXML
    private void login() throws IOException, ClassNotFoundException{
        boolean tokenuser = false;
        boolean tokenpass = false;
        try {
            compuser = new UserDAO();
            ArrayList <Users> users = new ArrayList(compuser.username(ConnDAO.conectar()));
            for(int i = 0; i < users.size();i++){
                if(user.getText().equals(users.get(i).getNombre())){
                    tokenuser = true;
                    if(password.getText().equals(users.get(i).getContrasena())){
                        tokenpass = true;
                        App.setUsuario(users.get(i));
                        App.setRoot("menu");
                    }
                }
            }
            if(tokenuser == false || tokenpass == false){
                AlertaUtil.mostrarError("Los datos son erroneos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
