/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.DAO.GastosDAO;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class GastosDAOTest {
    
    public GastosDAOTest() {
    }
    
    /**
     * Test of selectgastos method, of class GastosDAO.
     */
    @Test
    public void testSelectgastos() throws Exception {
        GastosDAO prueba = new GastosDAO();
        Connection con = ConnDAO.conectar();
        assertEquals(6, prueba.gastocasa(1, con).size());
    }

    /**
     * Test of gastocasasuma method, of class GastosDAO.
     */
    @Test
    public void testGastocasasuma() throws Exception {
        GastosDAO prueba = new GastosDAO();
        Connection con = ConnDAO.conectar();
        assertEquals(135, prueba.gastocasasuma(1, con));
    }    
}
