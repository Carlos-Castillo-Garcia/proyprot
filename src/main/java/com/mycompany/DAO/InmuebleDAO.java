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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PORTATIL 2
 */
public class InmuebleDAO {
    
    /**
     * Es el metodo que te permite ingresar un nuevo inmueble en la base de datos
     * @param casa
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insert_piso(Inmuebles casa, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO casa (calle, m2, n_habitaciones, precio_compra, precio_alquiler, fecha_compra, idusuario) VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, casa.getCalle());
        sentencia.setInt(2, casa.getM_cuadrados());
        sentencia.setInt(3, casa.getN_habitaciones());
        sentencia.setInt(4, casa.getPrecio_compra());
        sentencia.setInt(5, casa.getPrecio_alquiler());
        sentencia.setDate(6, casa.getFecha_compra());
        sentencia.setInt(7, App.user.getId());
        sentencia.executeUpdate();
    }
    
    /**
     * Es el metodo que te permite consultar todos los inmuebles de la base de datos
     * @param conexion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public List<Inmuebles> listaInmuebles(Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        List<Inmuebles> pisos = new ArrayList<>();
        String sql = "SELECT * FROM casa WHERE idusuario = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        
       
        while(resultado.next()){
            Inmuebles casa = new Inmuebles();
            casa.setId_casa(resultado.getInt(1));
            casa.setCalle(resultado.getString(2));
            casa.setM_cuadrados(resultado.getInt(3));
            casa.setN_habitaciones(resultado.getInt(4));
            casa.setPrecio_compra(resultado.getInt(5));
            casa.setPrecio_alquiler(resultado.getInt(6));
            casa.setN_inquilinos(resultado.getInt(7));
            casa.setFecha_compra(resultado.getDate(8));
            pisos.add(casa);
        }
        return pisos;
    }
    
    /**
     * Es el metodo que te permite modificar cualquier piso de la base de datos
     * @param casa
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void modpiso(Inmuebles casa, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "UPDATE casa SET n_habitaciones = ?, n_inquilinos = ?, precio_alquiler = ? WHERE idinmueble = ?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, casa.getN_habitaciones());
        sentencia.setInt(2, casa.getN_inquilinos());
        sentencia.setInt(3, casa.getPrecio_alquiler());
        sentencia.setInt(4, casa.getId_casa());
        sentencia.executeUpdate();
    }
    
    /**
     * Es el metodo que te permite borrar cualquier piso de la base de datos
     * @param casa
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void del_piso(Inmuebles casa, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "DELETE FROM casa WHERE idinmueble=?";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, casa.getId_casa());
        sentencia.executeUpdate();
    }
    
    
    
}
