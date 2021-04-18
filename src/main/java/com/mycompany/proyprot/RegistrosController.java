package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegistrosController {

    @FXML
    private void switchToinicio() throws IOException {
        App.setRoot("inicio");
    }
}