package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

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


    }

    private StackPane bloqueInicialDeSecuenciaDeEjecucion(){

        return (new ConfiguracionDeRectangulo("Inicio", Color.GOLD, 50, 75)).generarBloque();

    }

    public void agregarNuevoBloque(StackPane nuevoBloque, int posicion){

        this.secuenciaDeBloques.getChildren().add(Math.min(posicion, this.cantidadDeBloques()), nuevoBloque);

    }

    public int cantidadDeBloques(){

        return this.secuenciaDeBloques.getChildren().size();

    }

    public void removerBloque(int posicionDelBloque){

        this.secuenciaDeBloques.getChildren().remove(Math.min(posicionDelBloque, this.cantidadDeBloques()));

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
