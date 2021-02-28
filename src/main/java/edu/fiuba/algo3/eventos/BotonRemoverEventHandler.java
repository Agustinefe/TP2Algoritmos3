package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonRemoverEventHandler implements EventHandler<ActionEvent> {

    private TextField posicionTextField;
    private SectorAlgoritmo sectorAlgoritmo;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;

    public BotonRemoverEventHandler(TextField posicionIngresada, SectorAlgoritmo sectorAlgoritmo, VistaEspacioDeTrabajo vistaEspacioDeTrabajo) {

        this.posicionTextField = posicionIngresada;
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;

    }

    public void handle(ActionEvent actionEvent) {

        if(!this.posicionTextField.getText().trim().equals("")){

            this.remover();

        }

    }

    private void remover(){

        int posicion = Integer.parseInt(this.posicionTextField.getText());

        if(posicion < this.vistaEspacioDeTrabajo.cantidadDeBloques()) {

            //TODO indicar al usuario que debe ingresar una posicion valida para la secuencia actual
            this.sectorAlgoritmo.removerBloqueParticular(0, posicion);
            this.vistaEspacioDeTrabajo.removerBloque(posicion);

        }
        this.posicionTextField.setText("");

    }

    private int obtenerPosicion(){

        int numero;

        if (this.posicionTextField.getText().trim().equals("")) {

            numero = this.vistaEspacioDeTrabajo.cantidadDeBloques();

        } else {

            numero = Integer.parseInt(this.posicionTextField.getText());

        }

        return numero;

    }

}
