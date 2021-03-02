package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonRemoverEventHandler implements EventHandler<ActionEvent> {

    private TextField posicionTextField;
    private SectorAlgoritmo sectorAlgoritmo;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private Label mensajeDeError;

    public BotonRemoverEventHandler(TextField posicionIngresada, SectorAlgoritmo sectorAlgoritmo, VistaEspacioDeTrabajo vistaEspacioDeTrabajo, Label mensajeDeError) {

        this.posicionTextField = posicionIngresada;
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.mensajeDeError = mensajeDeError;

    }

    public void handle(ActionEvent actionEvent) {

        this.remover();

    }

    private void remover(){

        try {

            int posicion = this.obtenerPosicion();
            this.sectorAlgoritmo.removerBloqueParticular(0, posicion);
            this.vistaEspacioDeTrabajo.removerBloque(posicion);
            this.posicionTextField.setText("");
            this.mensajeDeError.setText("");

        } catch(Exception e) {

            this.mensajeDeError.setText("Ingrese un\nnumero valido");

        }

    }

    private int obtenerPosicion(){

        int posicionDada;

        if(this.posicionTextField.getText().trim().equals("")){

            posicionDada = this.vistaEspacioDeTrabajo.cantidadDeBloques() - 1;

        } else {

            posicionDada = this.evaluarPosicionNegativa(Integer.parseInt(this.posicionTextField.getText()));
            posicionDada = Math.max(0, Math.min(posicionDada, this.vistaEspacioDeTrabajo.cantidadDeBloques() - 1));
        }

        return posicionDada;

    }

    private int evaluarPosicionNegativa(int numero){

        if(numero < 0){

            numero = this.vistaEspacioDeTrabajo.cantidadDeBloques() + numero;

        }

        return numero;

    }

}
