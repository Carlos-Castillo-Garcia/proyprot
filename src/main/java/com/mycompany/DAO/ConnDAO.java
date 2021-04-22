/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PORTATIL 2
 */
public class ConnDAO {
    
    public static Connection conectar() throws ClassNotFoundException, SQLException, IOException {
        Connection conexion;
        String host = "LocalHost";
        String port = "3306";
        String dbname = "casa_expres";
        String username = "root";
        String password = 
//                "123456"
              "Rowl3t1005"
                ;
        
        conexion = DriverManager.getConnection("jdbc:mariadb://"+
                                                host + ":" + port + "/" + dbname
                + "?serverTimezone=UTC",username,password);
        
        return conexion;
    }
    
    public static void desconexion (Connection conexion) throws SQLException{
        conexion.close();
    }
}
