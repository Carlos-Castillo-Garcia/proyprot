/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Inmuebles;
import com.mycompany.proyprot.App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PORTATIL 2
 */
public class InmuebleDAO {
    
    public void insert_piso(Inmuebles casa, String direccion, int m_cuadrados,  Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO casa (calle, m2, nºhabitaciones, precio_compra, precio_alquiler, fecha_compra, idusuario) VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, direccion);
        sentencia.setInt(2, m_cuadrados);
        sentencia.setInt(3, casa.getN_habitaciones());
        sentencia.setInt(4, casa.getPrecio_compra());
        sentencia.setInt(5, casa.getPrecio_alquiler());
        sentencia.setDate(6, casa.getFecha_compra());
        sentencia.setInt(7, App.user.getId());
        sentencia.executeUpdate();
    }
}
