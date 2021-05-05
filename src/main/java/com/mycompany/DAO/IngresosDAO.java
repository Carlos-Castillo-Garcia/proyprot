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

    /**
     * Es el metodo que te permite consultar la suma de todos los ingresos de una casa
     * @param id
     * @param conexion
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
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
    
    /**
     * Es el metodo que te permite ingresar ingresos nuevos de un piso en la base de datos
     * @param casa
     * @param conexion
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void insert_ingresos(Inmuebles casa, Connection conexion) throws SQLException, ClassNotFoundException, IOException{
        String sql = "INSERT INTO ingresos (cantida_ingreso, idinmueble_ingreso) VALUES (?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, casa.getPrecio_alquiler());
        sentencia.setInt(2, casa.getId_casa());
        sentencia.executeUpdate();
    }
    
}
