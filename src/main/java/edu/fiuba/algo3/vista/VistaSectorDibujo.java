package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaSectorDibujo {

    private VBox sectorDibujo;

    public VistaSectorDibujo(){

        sectorDibujo = new VBox();
        sectorDibujo.setSpacing(10);

        StackPane pizarraDeDibujo = new StackPane();

        Label titulo = new Label();
        titulo.setText("Sector Dibujo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        Label labelPizarra = new Label();
        labelPizarra.setText("Aca va la pizarra");

        Rectangle pizarra = new Rectangle();
        pizarra.setWidth(300);
        pizarra.setHeight(400);
        pizarra.setStroke(Color.TRANSPARENT);
        pizarra.setFill(Color.GREY);

        Button botonDeEjecucion = new Button();
        MyButtonEventHandler eventoDeBotonDeEjecucion = new MyButtonEventHandler(botonDeEjecucion);
        botonDeEjecucion.setOnAction(eventoDeBotonDeEjecucion);

        pizarraDeDibujo.getChildren().addAll(pizarra, labelPizarra);

        sectorDibujo.getChildren().addAll(cajaDeTitulo, pizarraDeDibujo, botonDeEjecucion);


    }

    public VBox obtenerSectorDibujo(){

        return this.sectorDibujo;

    }

}
