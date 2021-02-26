package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.*;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {

        HBox contenedorPrincipal = new HBox();

        this.inicializarModelo(contenedorPrincipal);

        contenedorPrincipal.setSpacing(10);

        var scene = new Scene(contenedorPrincipal, 1700, 680);
        stage.setScene(scene);
        stage.setTitle("Hola");
        stage.show();

    }

    private void inicializarModelo(HBox contenedorPrincipal){

        Personaje dibujantePrincipal = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
        SectorBloque sectorBloque = new SectorBloque();

        VistaSectorDibujo vistaSectorDibujo = new VistaSectorDibujo(dibujantePrincipal);
        VistaSectorBloque vistaSectorBloque = new VistaSectorBloque(sectorBloque, sectorAlgoritmo);
        VistaSectorAlgoritmo vistaSectorAlgoritmo = new VistaSectorAlgoritmo();

        contenedorPrincipal.getChildren().addAll(
                vistaSectorDibujo.obtenerSectorDibujo(),
                vistaSectorBloque.obtenerSectorBloque(),
                vistaSectorAlgoritmo.obtenerSectorAlgoritmo());

    }


/*
    private Point2D dragVector = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        Pane node = new Pane();
        node.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        node.setPrefWidth(100);
        node.setPrefHeight(50);
        node.setTranslateX(500);
        node.setTranslateY(500);

        node.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("odDragDetected");

                double x = event.getX();
                double y = event.getY();
                dragVector = node.localToParent(x, y).subtract(node.getTranslateX(), node.getTranslateY());
                node.startFullDrag();
            }
        });

        node.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("onDragOver");

                Point2D parentCoords = node.localToParent(event.getX(), event.getY());
                //System.out.println("(", node.getLayoutX(), ", ", node.getLayoutY(), ")");

                node.setTranslateX(parentCoords.getX() -dragVector.getX());
                node.setTranslateY(parentCoords.getY() -dragVector.getY());
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse released");
                dragVector = null;
            }
        });

        root.getChildren().add(node);
        root.getChildren().removeAll(node);
        root.getChildren().add(node);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("DragTry");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


 */

}