/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.proyprot.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
                "123456"
//                  "Rowl3t1005"
                ;
        
        conexion = DriverManager.getConnection("jdbc:mariadb://"+
                                                host + ":" + port + "/" + dbname
                + "?serverTimezone=UTC",username,password);
        
        return conexion;
//            Connection conexion;
//            Properties configuration = new Properties();
//            InputStream input = new FileInputStream(new File(App.class.getResource("conexiondb1.properties").getPath()));
//            configuration.load(input);
//            String host = configuration.getProperty("host");
//            String port = configuration.getProperty("port");
//            String name = configuration.getProperty("name");
//            String username = configuration.getProperty("username");
//            String password = configuration.getProperty("password");
//
//            conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
//                    username, password);
//            return conexion;
    }
    
    public static void desconexion (Connection conexion) throws SQLException{
        conexion.close();
    }
}
