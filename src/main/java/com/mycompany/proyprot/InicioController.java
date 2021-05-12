package com.mycompany.proyprot;

import com.mycompany.DAO.ConnDAO;
import com.mycompany.DAO.UserDAO;
import com.mycompany.models.Users;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author PORTATIL 2
 */
public class InicioController {

    @FXML
    private TextField user;
    @FXML
    private TextField password;

    private static Connection con;
    private static UserDAO compuser;

    @FXML
    private void switchToregistro() throws IOException {
        App.setRoot("registros");
    }

    /**
     * Este es el metodo que compruba los datos del usuario con la base de datos
     * para que pueda loggearse
     */
    @FXML
    private void login() throws SQLException {
        boolean tokenuser = false;
        boolean tokenpass = false;
        try {
            con = ConnDAO.conectar();
            compuser = new UserDAO();
            ArrayList<Users> users = new ArrayList(compuser.username(con));
            for (int i = 0; i < users.size(); i++) {
                if (user.getText().equals(users.get(i).getNombre())) {
                    tokenuser = true;
                    if (password.getText().equals(users.get(i).getContrasena())) {
                        tokenpass = true;
                        App.setUsuario(users.get(i));
                        App.setRoot("menu");
                        AlertaUtil.mostrarInfo("Has iniciado sesion con: " + App.user.getNombre());
                    }
                }
            }
            if (tokenuser == false || tokenpass == false) {
                AlertaUtil.mostrarError("Los datos son erroneos");
            }
        } catch (SQLException ex) {
            AlertaUtil.mostrarError("1. Fallo en el inicio de sesion\n" + ex.getMessage());
        } catch (IOException ex) {
            AlertaUtil.mostrarError("2. Fallo en el inicio de sesion\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertaUtil.mostrarError("3. Fallo en el inicio de sesion\n" + ex.getMessage());
            
            
        } finally {
            ConnDAO.desconexion(con);
        }
    }
}
