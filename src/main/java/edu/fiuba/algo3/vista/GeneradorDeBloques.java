package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GeneradorDeBloques {

    private static GeneradorDeBloques miGenerador = new GeneradorDeBloques();

    private GeneradorDeBloques(){


    }

    public static GeneradorDeBloques getInstance(){

        return miGenerador;

    }

    public StackPane generarNuevoBloque(String nombreDelBloque){

        StackPane bloque = new StackPane();

        Label labelBloque = new Label();
        labelBloque.setText(nombreDelBloque);

        Rectangle rectangle = new Rectangle();
        //rectangle.setX(200);
        //rectangle.setY(200);
        rectangle.setWidth(75);
        rectangle.setHeight(50);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.RED);

        bloque.getChildren().addAll(rectangle, labelBloque);

        return bloque;

    }

}
