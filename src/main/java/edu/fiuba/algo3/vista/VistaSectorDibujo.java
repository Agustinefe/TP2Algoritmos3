package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.algoblocks.Pizarra;
import edu.fiuba.algo3.eventos.BotonEjecutarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaSectorDibujo {

    private VBox sectorDibujo;

    public VistaSectorDibujo(Personaje dibujantePrincipal){

        sectorDibujo = new VBox();
        sectorDibujo.setSpacing(10);

        StackPane contenedorPrincipal = new StackPane();

        Label titulo = new Label();
        titulo.setText("Sector Dibujo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);


        VistaPizarraDeDibujo pizarraDeDibujo = new VistaPizarraDeDibujo(dibujantePrincipal);
        Button botonDeEjecucion = new Button();

        BotonEjecutarEventHandler eventoDeBotonDeEjecucion = new BotonEjecutarEventHandler(botonDeEjecucion, pizarraDeDibujo, dibujantePrincipal);
        botonDeEjecucion.setOnAction(eventoDeBotonDeEjecucion);
        this.sectorDibujo.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorPrincipal.getChildren().addAll(pizarraDeDibujo.obtenerPizarraDeDibujo());

        sectorDibujo.getChildren().addAll(cajaDeTitulo, contenedorPrincipal, botonDeEjecucion);


    }

    public VBox obtenerSectorDibujo(){

        return this.sectorDibujo;

    }

}
