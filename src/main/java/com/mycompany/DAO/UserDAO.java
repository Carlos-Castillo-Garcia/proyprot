/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Users;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CARLOS
 */
public class UserDAO {
    
    /**
     *
     * @param user
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insertar(Users user, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO casa_expres.user (username, password, email) VALUES (?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, user.getNombre());
        sentencia.setString(2, user.getContrasena());
        sentencia.setString(3, user.getEmail());
        sentencia.executeUpdate();
    }
    
    /**
     *
     * @param conexion
     * @return
     * @throws SQLException
     */
    public ArrayList<Users> username(Connection conexion) throws SQLException {
        ArrayList<Users> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM user";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Users a = new Users();
            a.setId(resultado.getInt(1));
            a.setNombre(resultado.getString(2));
            a.setContrasena(resultado.getString(3));
            a.setEmail(resultado.getString(4));
            usuarios.add(a);
        }
        return usuarios;
    }    

    /**
     *
     * @param user
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void borrar(Users user, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "DELETE FROM actor WHERE nombre = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, user.getNombre());
        sentencia.execute();
    }
}
