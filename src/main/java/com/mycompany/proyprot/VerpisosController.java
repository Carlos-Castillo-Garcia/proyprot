/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Ismael m
 */
public class VerpisosController{

    @FXML
    private void switchTomenu() throws IOException{
         App.setRoot("menu");
    }
    
}
