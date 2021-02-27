package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 27/2/21*/

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConfiguracionDeRectangulo {

    private String nombre;
    private Color color;
    private int width;
    private int height;

    public ConfiguracionDeRectangulo(String nombre, Color color, int height, int width){

        this.nombre = nombre;
        this.color = color;
        this.width = width;
        this.height = height;

    }

    public StackPane generarBloque(){

        StackPane bloque = new StackPane();
        bloque.setPrefWidth(this.width);
        bloque.setPrefHeight(this.height);
        bloque.setAlignment(Pos.CENTER_LEFT);

        Rectangle rectanguloDeFondo = new Rectangle();

        rectanguloDeFondo.setWidth(this.width);
        rectanguloDeFondo.setHeight(this.height);
        rectanguloDeFondo.setStroke(Color.TRANSPARENT);
        rectanguloDeFondo.setFill(this.color);

        bloque.getChildren().addAll(rectanguloDeFondo, new Label(this.nombre));

        return bloque;

    }


}
