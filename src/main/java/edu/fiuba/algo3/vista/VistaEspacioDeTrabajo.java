package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaEspacioDeTrabajo extends HBox {

    public VistaEspacioDeTrabajo(){

        super();

        this.setPrefWidth(1000);
        this.setPrefHeight(600);

        VBox contenedorSecuencia = new VBox();
        VBox contenedorLibre1 = new VBox();
        VBox contenedorLibre2 = new VBox();
        VBox contenedorLibre3 = new VBox();
        VBox contenedorLibre4 = new VBox();

        contenedorSecuencia.setPrefWidth(200);
        contenedorSecuencia.setPrefHeight(600);

        contenedorSecuencia.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorLibre1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorLibre2.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorLibre3.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        contenedorLibre4.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorSecuencia.getChildren().addAll(new Label("Secuencia de ejecucion"));
        contenedorLibre1.getChildren().addAll(new Label("Espacio de trabajo 1"));
        contenedorLibre2.getChildren().addAll(new Label("Espacio de trabajo 2"));
        contenedorLibre3.getChildren().addAll(new Label("Espacio de trabajo 3"));
        contenedorLibre4.getChildren().addAll(new Label("Espacio de trabajo 4"));

        StackPane bloque = this.bloqueInicialDeSecuenciaDeEjecucion();

        contenedorSecuencia.getChildren().add(bloque);

    }

    private StackPane bloqueInicialDeSecuenciaDeEjecucion(){

        StackPane bloqueInicioDeSecuencia = new StackPane();
        bloqueInicioDeSecuencia.setPrefWidth(75);
        bloqueInicioDeSecuencia.setPrefHeight(50);
        bloqueInicioDeSecuencia.setAlignment(Pos.CENTER_LEFT);

        Rectangle rectanguloDeFondo = new Rectangle();

        rectanguloDeFondo.setWidth(75);
        rectanguloDeFondo.setHeight(50);
        rectanguloDeFondo.setStroke(Color.TRANSPARENT);
        rectanguloDeFondo.setFill(Color.GOLD);

        bloqueInicioDeSecuencia.getChildren().addAll(rectanguloDeFondo, new Label("Inicio de\nsecuencia"));

        return bloqueInicioDeSecuencia;

    }

}
