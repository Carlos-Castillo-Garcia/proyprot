/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyprot;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MenuController {

    @FXML
    private Label labelid;

    @FXML
    private Label labeluser;

    @FXML
    private void switchTometerpiso() throws IOException {
        App.loadMeterPisoWindow();
    }

    @FXML
    private void switchToverpisos() throws IOException, SQLException {
        App.loadverpisoWindow();
    }

    @FXML
    private void switchTomodificarpiso() throws IOException, SQLException {
        App.loadModPisoWindow();
    }

    @FXML
    private void switchTometergastos() throws IOException, SQLException {
        App.loadMeterGastoWindow();
    }

    @FXML
    private void switchTogastostotal() throws IOException, SQLException {
        App.loadgastostotalWindow();
    }

    @FXML
    private void switchToingresostotal() throws IOException, SQLException {
        App.loadingresostotalWindow();
    }

}
