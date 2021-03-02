package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.algoblocks.SecuenciaDeBloques;
import edu.fiuba.algo3.vista.GeneradorDeBloques;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonGenerarBloqueSimpleNuevoEventHandler implements EventHandler<ActionEvent> {

    private SectorBloque sectorBloque;
    private SectorAlgoritmo sectorAlgoritmo;
    private String nombreBloque;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private TextField posicionTextField;
    private Label mensajeDeError;

    public BotonGenerarBloqueSimpleNuevoEventHandler(SectorBloque sectorBloque,
                                                     SectorAlgoritmo sectorAlgoritmo,
                                                     String nombreBloque,
                                                     VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                                     TextField posicionTextField,
                                                     Label mensajeDeError){

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloque = sectorBloque;
        this.nombreBloque = nombreBloque;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.posicionTextField = posicionTextField;
        this.mensajeDeError = mensajeDeError;

    }

    @Override
    public void handle(ActionEvent actionEvent){

        try {

            int posicion = this.obtenerPosicion();

            SecuenciaDeBloques nuevoBloque = this.sectorBloque.nuevoBloque(this.nombreBloque);
            this.sectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(nuevoBloque, 0, posicion);
            this.vistaEspacioDeTrabajo.agregarNuevoBloque(GeneradorDeBloques.getInstance().generarNuevoBloque(this.nombreBloque), posicion);
            this.posicionTextField.setText("");
            this.mensajeDeError.setText("");
        } catch (NumberFormatException e){

            this.mensajeDeError.setText("Ingrese SOLO\nnumeros");

        }

    }

    private int obtenerPosicion(){

        int posicionDada;

        if(this.posicionTextField.getText().trim().equals("")){

            posicionDada = this.vistaEspacioDeTrabajo.cantidadDeBloques();

        } else {

            posicionDada = this.evaluarPosicionNegativa(Integer.parseInt(this.posicionTextField.getText()));
            posicionDada = Math.max(0, Math.min(posicionDada, this.vistaEspacioDeTrabajo.cantidadDeBloques()));

        }

        return posicionDada;

    }

    private int evaluarPosicionNegativa(int numero){

        if(numero < 0){

            numero = this.vistaEspacioDeTrabajo.cantidadDeBloques() + numero + 1;

        }

        return numero;

    }

}
