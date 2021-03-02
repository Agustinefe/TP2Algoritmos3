package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaSectorBloque extends VBox{


    public VistaSectorBloque(VistaBotoneraDeBloques vistaBotoneraDeBloques){

        super();

        this.setSpacing(10);
        this.setAlignment(Pos.TOP_CENTER);
        this.setBackground(new Background(new BackgroundFill(Color.LEMONCHIFFON.saturate(), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox cajaDeTitulo = new HBox();

        Label titulo = new Label();
        titulo.setText("Sector Bloque");

        cajaDeTitulo.getChildren().add(titulo);
        cajaDeTitulo.setAlignment(Pos.CENTER);

        this.getChildren().add(cajaDeTitulo);

        this.getChildren().add(vistaBotoneraDeBloques);

        ScrollPane scrollPane = new ScrollPane(vistaBotoneraDeBloques);
        scrollPane.setFitToHeight(false);
        scrollPane.setFitToWidth(true);

        BorderPane root = new BorderPane(scrollPane);
        root.setPadding(new Insets(15));
        this.getChildren().add(root);

    }
}
