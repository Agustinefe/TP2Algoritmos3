package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.Bloque;
import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.algoblocks.SecuenciaDeBloques;
import edu.fiuba.algo3.vista.GeneradorDeBloques;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonGenerarBloqueSimpleNuevoEventHandler implements EventHandler<ActionEvent> {

    private SectorBloque sectorBloque;
    private SectorAlgoritmo sectorAlgoritmo;
    private String nombreBloque;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private TextField posicionTextField;

    public BotonGenerarBloqueSimpleNuevoEventHandler(SectorBloque sectorBloque,
                                                     SectorAlgoritmo sectorAlgoritmo,
                                                     String nombreBloque,
                                                     VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                                     TextField posicionTextField
                                                    ){

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloque = sectorBloque;
        this.nombreBloque = nombreBloque;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.posicionTextField = posicionTextField;

    }

    @Override
    public void handle(ActionEvent actionEvent){

        int posicion = this.obtenerPosicion();
        SecuenciaDeBloques nuevoBloque = this.sectorBloque.nuevoBloque(this.nombreBloque);
        this.sectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(nuevoBloque, 0, posicion);

        this.vistaEspacioDeTrabajo.agregarNuevoBloque(GeneradorDeBloques.getInstance().generarNuevoBloque(this.nombreBloque), posicion);


    }

    private int obtenerPosicion(){

        int numero;

        if(this.posicionTextField.getText().trim().equals("")){

            numero = this.vistaEspacioDeTrabajo.cantidadDeBloques() - 2;

        } else {

            numero = Integer.parseInt(this.posicionTextField.getText());

        }

        return numero;

    }

}
