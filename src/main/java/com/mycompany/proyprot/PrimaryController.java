package com.mycompany.proyprot;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToregistro() throws IOException {
        App.setRoot("registro");
    }
}
