package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.MyButtonEventHandler;
import edu.fiuba.algo3.vista.VistaSectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaSectorBloque;
import edu.fiuba.algo3.vista.VistaSectorDibujo;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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



/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(1000, 1000);
        Group root = new Group(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillText("Hello JavaFX Canvas", 20, 40);

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5.0);

        gc.beginPath();

        gc.lineTo(500, 500);
        gc.lineTo(500, 400);
        gc.moveTo(400, 400);
        gc.lineTo(400, 300);

        gc.closePath();
        gc.stroke();

        primaryStage.setTitle("JavaFX Canvas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

 */
}