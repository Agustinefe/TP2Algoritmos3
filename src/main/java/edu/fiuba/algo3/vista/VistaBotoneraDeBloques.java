package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import edu.fiuba.algo3.eventos.BotonGenerarBloqueSimpleNuevoEventHandler;
import edu.fiuba.algo3.eventos.BotonMeterSecuenciaEnContenedorEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaBotoneraDeBloques extends VBox {

    private SectorBloque sectorBloque;
    private SectorAlgoritmo sectorAlgoritmo;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private TextField posicionDeIngresoDeBloque;
    private Label mensajeDeError;

    public VistaBotoneraDeBloques(SectorBloque sectorBloque, SectorAlgoritmo sectorAlgoritmo, VistaEspacioDeTrabajo vistaEspacioDeTrabajo){

        super();

        this.sectorBloque = sectorBloque;
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        this.mensajeDeError = new Label();
        this.mensajeDeError.setTextFill(Color.RED);

        this.posicionDeIngresoDeBloque = new TextField();
        posicionDeIngresoDeBloque.setPromptText("Posicion en secuencia");
        this.getChildren().addAll(this.mensajeDeError, this.posicionDeIngresoDeBloque);

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

        this.crearBotonDeBloqueSimple("Derecha", "Derecha");
        this.crearBotonDeBloqueSimple("Izquierda", "Izquierda");
        this.crearBotonDeBloqueSimple("Arriba", "Arriba");
        this.crearBotonDeBloqueSimple("Abajo", "Abajo");
        this.crearBotonDeBloqueSimple("Bajar lapiz", "Bajar lapiz");
        this.crearBotonDeBloqueSimple("Subir lapiz", "Subir lapiz");
        this.crearBotonDeBloqueContenedor("Repetir\n2 veces", "x2", new BloqueRepeticionPor2());
        this.crearBotonDeBloqueContenedor("Repetir\n3 veces", "x3", new BloqueRepeticionPor3());
        this.crearBotonDeBloqueContenedor("Invertir\ncomportamiento", "Inv.", new BloqueInvertirComportamiento());

    }

    private void crearBotonDeBloqueSimple(String nombreBoton, String nombreBloqueEnModelo){

        Button botonDeBloque = new Button();
        botonDeBloque.setText(nombreBoton);
        BotonGenerarBloqueSimpleNuevoEventHandler evento = new BotonGenerarBloqueSimpleNuevoEventHandler(
                this.sectorBloque,
                this.sectorAlgoritmo,
                nombreBloqueEnModelo,
                this.vistaEspacioDeTrabajo,
                this.posicionDeIngresoDeBloque,
                this.mensajeDeError);
        botonDeBloque.setOnAction(evento);
        this.getChildren().add(botonDeBloque);

    }

    private void crearBotonDeBloqueContenedor(String nombreBoton, String nombreBloqueEnVista, BloqueContenedor contenedor){


        Button botonDeBloque = new Button();
        botonDeBloque.setText(nombreBoton);
        BotonMeterSecuenciaEnContenedorEventHandler evento = new BotonMeterSecuenciaEnContenedorEventHandler(
                this.sectorAlgoritmo,
                contenedor,
                this.vistaEspacioDeTrabajo,
                nombreBloqueEnVista);
        botonDeBloque.setOnAction(evento);
        this.getChildren().add(botonDeBloque);


    }

    public void agregarBloquePersonalizado(String nombre){

        Button nuevoBotonPersonalizado = new Button();
        nuevoBotonPersonalizado.setText(nombre);
        BotonGenerarBloqueSimpleNuevoEventHandler evento = new BotonGenerarBloqueSimpleNuevoEventHandler(
                this.sectorBloque,
                this.sectorAlgoritmo,
                nombre,
                vistaEspacioDeTrabajo,
                this.posicionDeIngresoDeBloque,
                this.mensajeDeError);
        nuevoBotonPersonalizado.setOnAction(evento);
        this.getChildren().add(nuevoBotonPersonalizado);

        GeneradorDeBloques.getInstance().agregarNombreBloquePersonalizado(nombre);
    }

}
