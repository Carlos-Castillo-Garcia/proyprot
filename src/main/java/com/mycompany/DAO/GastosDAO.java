/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Gastos;
import com.mycompany.models.Tipo_Gasto;
import com.mycompany.proyprot.App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CARLOS
 */
public class GastosDAO {
    
    public void insertgasto(Gastos gasto, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO gastos (NºFACTURA, PROVEEDOR, CANTIDAD, FECHA, TIPO_GASTO_ID, IDINMUEBLE_GASTO) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, gasto.getN_factura());
        sentencia.setString(2, gasto.getProveedor());
        sentencia.setInt(3, gasto.getCantidad());
        sentencia.setDate(4, gasto.getFecha());
        sentencia.setInt(5, gasto.getId_tipo_gasto());
        sentencia.setInt(6, gasto.getId_inmueble());
        sentencia.executeUpdate();
    }
    

    public ArrayList<Tipo_Gasto> selectgastos(Connection conexion) throws SQLException {
        ArrayList<Tipo_Gasto> tipo_gastos = new ArrayList<>();
        String sql = "SELECT * FROM tipos_gastos";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            Tipo_Gasto a = new Tipo_Gasto();
            a.setId_tipo_gasto(resultado.getInt(1));
            a.setDetalles(resultado.getString(2));
            tipo_gastos.add(a);
        }
        return tipo_gastos;
    } 
    
    public int gastocasasuma(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoaguatotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoluztotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=2";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastogastotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=3";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoreformatotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=4";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoreparaciontotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=5";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastocomunidadtotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=? and g.TIPO_GASTO_ID=6";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastototaltotal(Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(g.CANTIDAD) from gastos g inner join casa c on g.IDINMUEBLE_GASTO=c.IDINMUEBLE where c.IDUSUARIO=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, App.user.getId());
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoaguacasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoluzcasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=2";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastogascasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=3";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoreformacasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=4";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastoreparacioncasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=5";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastocomunidadcasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=? and TIPO_GASTO_ID=6";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
    public int gastototalcasa(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDAD) from gastos where IDINMUEBLE_GASTO=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
}
