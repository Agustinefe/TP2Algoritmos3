package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.MyButtonEventHandler;
import edu.fiuba.algo3.vista.VistaSectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaSectorBloque;
import edu.fiuba.algo3.vista.VistaSectorDibujo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        Button miBoton = new Button();
        MyButtonEventHandler eventoDeBoton = new MyButtonEventHandler(miBoton);
        miBoton.setOnAction(eventoDeBoton);

        TextField cuadroDeTexto = new TextField();
        cuadroDeTexto.setPromptText("Ingrese un texto");

        VistaSectorDibujo sectorDibujo = new VistaSectorDibujo();
        VistaSectorBloque sectorBloque = new VistaSectorBloque();
        VistaSectorAlgoritmo sectorAlgoritmo = new VistaSectorAlgoritmo();

        HBox contenedorHorizontal = new HBox(
                sectorDibujo.obtenerSectorDibujo(),
                sectorBloque.obtenerSectorBloque(),
                sectorAlgoritmo.obtenerSectorAlgoritmo());

        contenedorHorizontal.setSpacing(10);

        var scene = new Scene(contenedorHorizontal, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Hola");
        stage.show();


    }

    private Circle createRectangle(String strokeColor, String fillColor, double x) {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(200);
        circle.setRadius(50);
        circle.setStroke(Color.valueOf(strokeColor));
        circle.setStrokeWidth(5);
        circle.setFill(Color.valueOf(fillColor));
        return circle;
    }

    public static void main(String[] args) {
        launch();
    }

}