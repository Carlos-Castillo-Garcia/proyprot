package com.mycompany.DAO;

import com.mycompany.models.Inmuebles;
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
    
    public void insert_ingresos(Inmuebles casa, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO ingresos (cantida_ingreso, idinmueble_ingreso) VALUES (?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, casa.getPrecio_alquiler());
        sentencia.setInt(2, casa.getId_casa());
        sentencia.executeUpdate();
    }
    
}
