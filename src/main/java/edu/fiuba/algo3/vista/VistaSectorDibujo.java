package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.algoblocks.Pizarra;
import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.eventos.BotonEjecutarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaSectorDibujo extends VBox{


    public VistaSectorDibujo(Personaje dibujantePrincipal, SectorAlgoritmo sectorAlgoritmo){

        super();
        this.setSpacing(10);

        StackPane contenedorPrincipal = new StackPane();

        Label titulo = new Label();
        titulo.setText("Sector Dibujo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);


        VistaPizarraDeDibujo pizarraDeDibujo = new VistaPizarraDeDibujo(dibujantePrincipal);
        Button botonDeEjecucion = new Button();

        BotonEjecutarEventHandler eventoDeBotonDeEjecucion = new BotonEjecutarEventHandler(botonDeEjecucion, pizarraDeDibujo, dibujantePrincipal, sectorAlgoritmo);
        botonDeEjecucion.setOnAction(eventoDeBotonDeEjecucion);
        this.setBackground(new Background(new BackgroundFill(Color.LEMONCHIFFON.saturate(), CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorPrincipal.getChildren().addAll(pizarraDeDibujo.obtenerPizarraDeDibujo());

        this.getChildren().addAll(cajaDeTitulo, contenedorPrincipal, botonDeEjecucion);


    }

}
