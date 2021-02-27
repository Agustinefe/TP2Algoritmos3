package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.algoblocks.SecuenciaDeBloques;
import edu.fiuba.algo3.eventos.BotonGenerarBloqueSimpleNuevoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VistaBotoneraDeBloques extends VBox {

    private SectorBloque sectorBloque;
    private SectorAlgoritmo sectorAlgoritmo;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private TextField posicionDeIngresoDeBloque;

    public VistaBotoneraDeBloques(SectorBloque sectorBloque, SectorAlgoritmo sectorAlgoritmo, VistaEspacioDeTrabajo vistaEspacioDeTrabajo){

        super();

        this.sectorBloque = sectorBloque;
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;

        this.posicionDeIngresoDeBloque = new TextField();
        posicionDeIngresoDeBloque.setPromptText("Posicion en secuencia");
        this.getChildren().add(posicionDeIngresoDeBloque);

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

        this.crearBoton("Derecha", "derecha");
        this.crearBoton("Izquierda", "izquierda");
        this.crearBoton("Arriba", "arriba");
        this.crearBoton("Abajo", "abajo");
        this.crearBoton("Bajar lapiz", "bajar lapiz");
        this.crearBoton("Subir lapiz", "subir lapiz");
        this.crearBoton("Repetir 2 veces", "repeticion x2");
        this.crearBoton("Repetir 3 veces", "repeticion x3");
        this.crearBoton("Invertir comportamiento", "inversor");

    }

    public void crearBoton(String nombreBoton, String nombreBloque){

        Button botonDeBloque = new Button();
        botonDeBloque.setText(nombreBoton);
        BotonGenerarBloqueSimpleNuevoEventHandler evento = new BotonGenerarBloqueSimpleNuevoEventHandler(
                this.sectorBloque,
                this.sectorAlgoritmo,
                nombreBloque,
                this.vistaEspacioDeTrabajo,
                this.posicionDeIngresoDeBloque);
        botonDeBloque.setOnAction(evento);
        this.getChildren().add(botonDeBloque);

    }

    void update(SecuenciaDeBloques nuevaSecuencia, String nombre){

        Button nuevoBotonPersonalizado = new Button();
        nuevoBotonPersonalizado.setText(nombre);
        BotonGenerarBloqueSimpleNuevoEventHandler evento = new BotonGenerarBloqueSimpleNuevoEventHandler(
                this.sectorBloque,
                this.sectorAlgoritmo,
                nombre,
                vistaEspacioDeTrabajo,
                this.posicionDeIngresoDeBloque);
        nuevoBotonPersonalizado.setOnAction(evento);
        this.getChildren().add(nuevoBotonPersonalizado);

    }

}
