/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import com.mycompany.models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class UsersTest {
    
    public UsersTest() {
    }

    /**
     * Test of Compcontrasena method, of class Users.
     */
    @Test
    public void testCompcontrasena() {
        Users prueba = new Users();
        boolean resultado = prueba.Compcontrasena("Password");
        assertTrue(resultado);
    }
    @Test
    public void testCompcontrasena1() {
        Users prueba = new Users();
        boolean resultado = prueba.Compcontrasena("password");
        assertFalse(resultado);
    }
    @Test
    public void testCompcontrasena2() {
        Users prueba = new Users();
        boolean resultado = prueba.Compcontrasena("Pass");
        assertFalse(resultado);
    }

    /**
     * Test of Compnombre method, of class Users.
     */
    @Test
    public void testCompnombre() {
        Users prueba = new Users();
        boolean resultado = prueba.Compnombre("Ismael");
        assertTrue(resultado);
    }
    @Test
    public void testCompnombre1() {
        Users prueba = new Users();
        boolean resultado = prueba.Compnombre("Isma");
        assertFalse(resultado);
    }

    /**
     * Test of Compemail method, of class Users.
     */
    @Test
    public void testCompemail() {
        Users prueba = new Users();
        boolean resultado = prueba.Compemail("ismael@hola.com");
        assertTrue(resultado);
    }
    @Test
    public void testCompemail1() {
        Users prueba = new Users();
        boolean resultado = prueba.Compemail("ismaelhola.com");
        assertFalse(resultado);
    }
    @Test
    public void testCompemail2() {
        Users prueba = new Users();
        boolean resultado = prueba.Compemail("ismael@hola");
        assertFalse(resultado);
    }
    
}
