package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaEspacioDeTrabajo extends HBox {

    private VBox contenedorSecuencia;
    private VBox secuenciaDeBloques;


    public VistaEspacioDeTrabajo(){

        super();

        this.setPrefWidth(1000);
        this.setPrefHeight(600);
        this.inicializarSecuencia();

    }

    private void inicializarSecuencia(){

        this.contenedorSecuencia = new VBox();
        this.secuenciaDeBloques = new VBox();
        this.contenedorSecuencia.setPrefWidth(1000);
        this.contenedorSecuencia.setPrefHeight(600);
        this.contenedorSecuencia.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        this.contenedorSecuencia.getChildren().addAll(new Label("Secuencia de ejecucion"));
        StackPane bloque = this.bloqueInicialDeSecuenciaDeEjecucion();
        this.contenedorSecuencia.getChildren().addAll(bloque, this.secuenciaDeBloques);
        this.getChildren().addAll(this.contenedorSecuencia);

        ScrollPane scrollPane = new ScrollPane(this.contenedorSecuencia);
        scrollPane.setFitToHeight(false);
        scrollPane.setFitToWidth(true);

        BorderPane root = new BorderPane(scrollPane);
        root.setPadding(new Insets(15));
        this.getChildren().add(root);


    }

    private StackPane bloqueInicialDeSecuenciaDeEjecucion(){

        return (new ConfiguracionDeRectangulo("Inicio", Color.GOLD, 50, 75)).generarBloque();

    }

    public void agregarNuevoBloque(StackPane nuevoBloque, int posicion){

        this.secuenciaDeBloques.getChildren().add(posicion, nuevoBloque);

    }

    public int cantidadDeBloques(){

        return this.secuenciaDeBloques.getChildren().size();

    }

    public void removerBloque(int posicionDelBloque){

        this.secuenciaDeBloques.getChildren().remove(posicionDelBloque);

    }

    public void meterSecuenciaEnContenedor(String nombre){

        double alturaDelContenedor = this.secuenciaDeBloques.getHeight() + 50;
        double anchoDelContenedor = 75;

        StackPane bloqueContenedor = (new ConfiguracionDeRectangulo(nombre, Color.LIGHTGREEN, alturaDelContenedor, anchoDelContenedor)).generarBloque();
        VBox secuenciaInterna = (VBox) this.contenedorSecuencia.getChildren().remove(2);
        secuenciaInterna.setTranslateX(37.5);
        secuenciaInterna.setTranslateY(25);

        StackPane contenedorPrincipal = new StackPane();

        contenedorPrincipal.getChildren().addAll(bloqueContenedor, secuenciaInterna);

        VBox nuevaSecuenciaDeBloques = new VBox(contenedorPrincipal);
        this.contenedorSecuencia.getChildren().add(nuevaSecuenciaDeBloques);
        this.secuenciaDeBloques = nuevaSecuenciaDeBloques;

    }

    public void reiniciar(){

        this.secuenciaDeBloques.getChildren().clear();
        //this.inicializarSecuencia();

    }

}
