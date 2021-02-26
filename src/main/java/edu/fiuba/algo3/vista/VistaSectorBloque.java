package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.eventos.BotonGenerarBloqueNuevoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaSectorBloque {

    private VBox contenedorPrincipal;

    public VistaSectorBloque(SectorBloque sectorBloque, SectorAlgoritmo sectorAlgoritmo){

        this.contenedorPrincipal = new VBox();
        this.contenedorPrincipal.setSpacing(10);
        this.contenedorPrincipal.setAlignment(Pos.TOP_CENTER);
        this.contenedorPrincipal.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox cajaDeTitulo = new HBox();

        Label titulo = new Label();
        titulo.setText("Sector Bloque");

        cajaDeTitulo.getChildren().add(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        this.contenedorPrincipal.getChildren().add(cajaDeTitulo);

        this.contenedorPrincipal.getChildren().add(new VistaBotoneraDeBloques(sectorBloque, sectorAlgoritmo));


    }

    private void inicializarBotones(SectorBloque sectorBloque, SectorAlgoritmo sectorAlgoritmo){

        Button botonDeBloque;

        ArrayList<String> listaDeNombres = new ArrayList<String>();
        listaDeNombres.add("Derecha");
        listaDeNombres.add("Izquierda");
        listaDeNombres.add("Arriba");
        listaDeNombres.add("Abajo");
        listaDeNombres.add("Bajar Lapiz");
        listaDeNombres.add("Subir Lapiz");
        listaDeNombres.add("Repetir 2 veces");
        listaDeNombres.add("Repetir 3 veces");
        listaDeNombres.add("Invertir Comportamiento");


        for(int i = 0; i < 9; i++){

            botonDeBloque = new Button();
            BotonGenerarBloqueNuevoEventHandler evento = new BotonGenerarBloqueNuevoEventHandler(sectorBloque,
                    sectorAlgoritmo, i);
            botonDeBloque.setOnAction(evento);
            this.contenedorPrincipal.getChildren().addAll(botonDeBloque);

        }

    }

    public VBox obtenerSectorBloque(){

        return this.contenedorPrincipal;

    }

}
