package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.MyButtonEventHandler;
import edu.fiuba.algo3.vista.VistaSectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaSectorBloque;
import edu.fiuba.algo3.vista.VistaSectorDibujo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        VistaSectorDibujo sectorDibujo = new VistaSectorDibujo();
        VistaSectorBloque sectorBloque = new VistaSectorBloque();
        VistaSectorAlgoritmo sectorAlgoritmo = new VistaSectorAlgoritmo();

        HBox contenedorHorizontal = new HBox(
                sectorDibujo.obtenerSectorDibujo(),
                sectorBloque.obtenerSectorBloque(),
                sectorAlgoritmo.obtenerSectorAlgoritmo());

        contenedorHorizontal.setSpacing(10);

        var scene = new Scene(contenedorHorizontal, 1400, 680);
        stage.setScene(scene);
        stage.setTitle("Hola");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}