/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CARLOS
 */
public class IngresosDAO {
    public int ingresocasasuma(int id,Connection conexion)throws SQLException, ClassNotFoundException, IOException{
        int salida=0;
        String sql = "select sum(CANTIDA_INGRESO) from ingresos where IDINMUEBLE_INGRESO=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        
        while(resultado.next()){
            salida = resultado.getInt(1);
        }
        return salida;
    }
    
}
