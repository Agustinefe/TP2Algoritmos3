package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class VistaEspacioDeTrabajo extends HBox {

    private VBox contenedorSecuencia;

    public VistaEspacioDeTrabajo(){

        super();

        this.setPrefWidth(1000);
        this.setPrefHeight(600);

        this.inicializarSecuencia();

    }

    private void inicializarSecuencia(){

        this.contenedorSecuencia = new VBox();
        this.contenedorSecuencia.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        this.contenedorSecuencia.getChildren().addAll(new Label("Secuencia de ejecucion"));
        StackPane bloque = this.bloqueInicialDeSecuenciaDeEjecucion();
        this.contenedorSecuencia.getChildren().add(bloque);
        this.getChildren().addAll(contenedorSecuencia);

    }

    private StackPane bloqueInicialDeSecuenciaDeEjecucion(){

        return (new ConfiguracionDeRectangulo("Inicio", Color.GOLD, 50, 75)).generarBloque();

    }

    public void agregarNuevoBloque(StackPane nuevoBloque, int posicion){

        this.contenedorSecuencia.getChildren().add(Math.min(posicion + 2, this.cantidadDeBloques()), nuevoBloque);

    }

    public int cantidadDeBloques(){

        return this.contenedorSecuencia.getChildren().size();

    }

    public void removerBloque(int posicionDelBloque){

        this.contenedorSecuencia.getChildren().remove(Math.min(posicionDelBloque + 2, this.cantidadDeBloques()));

    }

    public void reiniciar(){

        this.contenedorSecuencia.getChildren().clear();
        this.inicializarSecuencia();

    }

}
