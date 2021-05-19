/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Usuario
 */
public class GastosDAOTest {

    public GastosDAOTest() {}
    /*
     * Test of selectgastos method, of class GastosDAO.
     */
    @Test
    public void testSelectgastos() throws Exception {
        GastosDAO prueba = new GastosDAO();
        Connection con = ConnDAO.conectar();
        assertEquals(0, prueba.selectgastos(con).size());
    }

    /*
     * Test of gastocasasuma method, of class GastosDAO.
     */
    @Test
    public void testGastocasasuma() throws Exception {
        GastosDAO prueba = new GastosDAO();
        Connection con = ConnDAO.conectar();
        assertEquals(0, prueba.gastocasasuma(1, con));
    }

    /**
     * Test of gastogascasa method, of class GastosDAO.
     */
    @Test
    public void testGastocasa() throws Exception {
        GastosDAO prueba = new GastosDAO();
        Connection con = ConnDAO.conectar();
        assertEquals(0, prueba.gastocasa(15, con, 5));
    }
}
