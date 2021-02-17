package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 17/2/21*/

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaSectorAlgoritmo {

    private VBox sectorAlgoritmo;

    public VistaSectorAlgoritmo(){

        this.sectorAlgoritmo = new VBox();
        this.sectorAlgoritmo.setSpacing(10);

        Label titulo = new Label();
        titulo.setText("Sector Algoritmo");

        HBox cajaDeTitulo = new HBox(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        Button botonVolverAEmpezar = new Button();
        botonVolverAEmpezar.setText("Volver a empezar");

        HBox tituloYBoton = new HBox(cajaDeTitulo, botonVolverAEmpezar);
        tituloYBoton.setAlignment(Pos.CENTER_RIGHT);

        Rectangle espacioDeTrabajo = new Rectangle();
        espacioDeTrabajo.setWidth(1000);
        espacioDeTrabajo.setHeight(600);
        espacioDeTrabajo.setStroke(Color.TRANSPARENT);
        espacioDeTrabajo.setFill(Color.GREY);

        Label labelEspacioDeTrabajo = new Label();
        labelEspacioDeTrabajo.setText("Aca va el espacio de trabajo");

        StackPane contenedorEspacioDeTrabajo = new StackPane(espacioDeTrabajo, labelEspacioDeTrabajo);

        this.sectorAlgoritmo.getChildren().addAll(tituloYBoton, contenedorEspacioDeTrabajo);

    }

    public VBox obtenerSectorAlgoritmo(){

        return this.sectorAlgoritmo;

    }

}
