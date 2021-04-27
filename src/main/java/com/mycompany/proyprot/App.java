package com.mycompany.proyprot;

import com.mycompany.models.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Users user = new Users();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"), 960, 540);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    static void setUsuario(Users u) {       
        user = u;
    }
    
    static void loadMeterPisoWindow() throws IOException {
        String fxml = "meterpiso";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        MeterpisoController controller = new MeterpisoController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
    }
    
    static void loadModPisoWindow() throws IOException {
        String fxml = "modificarpiso";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        ModificarpisoController controller = new ModificarpisoController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegable(); 
    }
    
    static void loadverpisoWindow() throws IOException {
        String fxml = "verpisos";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        VerpisosController controller = new VerpisosController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
    }
}
