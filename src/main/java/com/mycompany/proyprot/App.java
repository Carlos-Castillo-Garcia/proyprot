package com.mycompany.proyprot;

import com.mycompany.models.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     *
     */
    public static Users user = new Users();

    /**
     *
     * @param stage
     * @throws IOException
     */
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
    
    static void loadModPisoWindow() throws IOException, SQLException {
        String fxml = "modificarpiso";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        ModificarpisoController controller = new ModificarpisoController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegable(); 
    }
    
    static void loadverpisoWindow() throws IOException, SQLException {
        String fxml = "verpisos";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        VerpisosController controller = new VerpisosController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegable();
    }
    
    static void loadgastostotalWindow() throws IOException, SQLException {
        String fxml = "gastostotal";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        GastostotalController controller = new GastostotalController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegable();
    }
    
    static void loadMeterGastoWindow() throws IOException, SQLException {
        String fxml = "metergastos";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        MetergastosController controller = new MetergastosController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegablecasa();
        controller.desplegablegasto();
    }
    
    static void loadingresostotalWindow() throws IOException, SQLException {
        String fxml = "ingresostotal";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        IngresostotalController controller = new IngresostotalController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.desplegable();
    }
    
}
