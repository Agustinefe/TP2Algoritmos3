package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 17/2/21*/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaSectorAlgoritmo extends VBox {


    public VistaSectorAlgoritmo(VistaEspacioDeTrabajo vistaEspacioDeTrabajo, VistaControladorDeEspacioDeTrabajo vistaControladorDeEspacioDeTrabajo){

        super();

        this.setSpacing(10);
        this.setBackground(new Background(new BackgroundFill(Color.LEMONCHIFFON.saturate(), CornerRadii.EMPTY, Insets.EMPTY)));

        Label titulo = new Label();
        titulo.setText("Sector Algoritmo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        HBox espacioDeTrabajo = vistaEspacioDeTrabajo;

        HBox contenedorIngresoUsuario = vistaControladorDeEspacioDeTrabajo;

        this.getChildren().addAll(cajaDeTitulo, espacioDeTrabajo, contenedorIngresoUsuario);

    }

}
