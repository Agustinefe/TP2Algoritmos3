package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.eventos.BotonGenerarBloqueNuevoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaBotoneraDeBloques extends VBox {

    public VistaBotoneraDeBloques(SectorBloque sectorBloque, SectorAlgoritmo sectorAlgoritmo){

        super();

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

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
            botonDeBloque.setText(listaDeNombres.get(i));
            BotonGenerarBloqueNuevoEventHandler evento = new BotonGenerarBloqueNuevoEventHandler(sectorBloque,
                    sectorAlgoritmo, i);
            botonDeBloque.setOnAction(evento);
            this.getChildren().add(botonDeBloque);

        }

    }

}
