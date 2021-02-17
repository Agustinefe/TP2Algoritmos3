package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaSectorBloque {

    private VBox sectorBloque;

    public VistaSectorBloque(){

        sectorBloque = new VBox();
        sectorBloque.setSpacing(10);

        HBox cajaDeTitulo = new HBox();

        Label titulo = new Label();
        titulo.setText("Sector Bloque");

        cajaDeTitulo.getChildren().add(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        sectorBloque.getChildren().addAll(
                cajaDeTitulo,
                GeneradorDeBloques.getInstance().generarNuevoBloque("Arriba"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Abajo"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Izquierda"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Derecha"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Subir Lapiz"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Bajar Lapiz"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Repetir"),
                GeneradorDeBloques.getInstance().generarNuevoBloque("Invertir\nComportamiento")
        );

    }

    public VBox obtenerSectorBloque(){

        return this.sectorBloque;

    }

}
