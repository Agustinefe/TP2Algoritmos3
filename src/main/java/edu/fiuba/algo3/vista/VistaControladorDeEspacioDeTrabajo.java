package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 26/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.eventos.BotonGenerarBloqueSimpleNuevoEventHandler;
import edu.fiuba.algo3.eventos.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.eventos.BotonRemoverEventHandler;
import edu.fiuba.algo3.eventos.BotonVolverAEmpezarEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaControladorDeEspacioDeTrabajo extends HBox {

    public VistaControladorDeEspacioDeTrabajo(VistaBotoneraDeBloques vistaBotoneraDeBloques,
                                              VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                              SectorBloque sectorBloque,
                                              SectorAlgoritmo sectorAlgoritmo){


        this.setSpacing(10);
        this.setTranslateX(this.getTranslateX() + 15);

        TextField posicionEnSecuencia = new TextField();
        posicionEnSecuencia.setPromptText("Posicion");

        TextField nombreParaNuevoAlgoritmo = new TextField();
        nombreParaNuevoAlgoritmo.setPromptText("Nombre");

        Label mensajeDeError = new Label();
        mensajeDeError.setTextFill(Color.RED);

        Button botonRemover = this.crearBoton("Remover",
                new BotonRemoverEventHandler(posicionEnSecuencia, sectorAlgoritmo, vistaEspacioDeTrabajo, mensajeDeError));
        Button botonVolverAEmpezar = this.crearBoton("Volver a empezar",
                new BotonVolverAEmpezarEventHandler(vistaEspacioDeTrabajo, sectorAlgoritmo));

        botonVolverAEmpezar.setTranslateX(botonVolverAEmpezar.getTranslateX() - 17);

        Button botonGuardarAlgoritmo = this.crearBoton("Guardar algoritmo",
                new BotonGuardarAlgoritmoEventHandler(
                        sectorAlgoritmo,
                        sectorBloque,
                        vistaBotoneraDeBloques,
                        vistaEspacioDeTrabajo,
                        nombreParaNuevoAlgoritmo,
                        mensajeDeError));

        HBox contenedorRemover = new HBox(posicionEnSecuencia, botonRemover);
        contenedorRemover.setAlignment(Pos.CENTER_LEFT);
        contenedorRemover.setSpacing(20);
        HBox contenedorGuardar = new HBox(nombreParaNuevoAlgoritmo, botonGuardarAlgoritmo);
        contenedorGuardar.setAlignment(Pos.CENTER_LEFT);
        contenedorGuardar.setSpacing(20);

        VBox contenedorGeneralRemoverYGuardar = new VBox(contenedorRemover, contenedorGuardar);
        HBox contenedorBotonVolverAEmpezar = new HBox(botonVolverAEmpezar);
        contenedorBotonVolverAEmpezar.setAlignment(Pos.CENTER_RIGHT);
        contenedorBotonVolverAEmpezar.setPrefWidth(400);


        this.getChildren().addAll(contenedorGeneralRemoverYGuardar, mensajeDeError, contenedorBotonVolverAEmpezar);


    }

    private Button crearBoton(String nombreBoton, EventHandler<ActionEvent> evento){

        Button boton = new Button();
        boton.setText(nombreBoton);
        boton.setOnAction(evento);
        return boton;

    }

}
