package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 17/2/21*/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class VistaSectorAlgoritmo extends VBox {


    public VistaSectorAlgoritmo(VistaEspacioDeTrabajo vistaEspacioDeTrabajo, VistaControladorDeEspacioDeTrabajo vistaControladorDeEspacioDeTrabajo){

        super();

        this.setSpacing(10);
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        Label titulo = new Label();
        titulo.setText("Sector Algoritmo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        HBox espacioDeTrabajo = vistaEspacioDeTrabajo;

        HBox contenedorIngresoUsuario = vistaControladorDeEspacioDeTrabajo;

        this.getChildren().addAll(cajaDeTitulo, espacioDeTrabajo, contenedorIngresoUsuario);

    }


    private HBox inicializarContenedoresDeBloques(){

        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.setPrefWidth(1000);
        contenedorPrincipal.setPrefHeight(600);

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

        contenedorPrincipal.getChildren().addAll(
                contenedorSecuencia,
                contenedorLibre1,
                contenedorLibre2,
                contenedorLibre3,
                contenedorLibre4);

        return contenedorPrincipal;
    }

    private HBox inicializarControladorDelUsuario(){

        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.setSpacing(10);

        TextField numeroDeContenedor = new TextField("Numero de contenedor");
        TextField posicionEnSecuencia = new TextField("Posicion del bloque");

        Button botonInsertarSeparar = new Button();
        botonInsertarSeparar.setText("Insertar");

        Button botonLimpiarSectorAlgoritmo = new Button();
        botonLimpiarSectorAlgoritmo.setText("Volver a empezar");

        contenedorPrincipal.getChildren().addAll(
                new Label("Contenedor: "),
                numeroDeContenedor,
                new Label("Posicion: "),
                posicionEnSecuencia,
                botonInsertarSeparar,
                botonLimpiarSectorAlgoritmo);

        return contenedorPrincipal;

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
