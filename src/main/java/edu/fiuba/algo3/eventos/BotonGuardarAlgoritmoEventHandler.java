package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 27/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.vista.VistaBotoneraDeBloques;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonGuardarAlgoritmoEventHandler implements EventHandler<ActionEvent> {

    private SectorAlgoritmo sectorAlgoritmo;
    private SectorBloque sectorBloque;
    private VistaBotoneraDeBloques vistaBotoneraDeBloques;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private TextField nombreIngresado;

    public BotonGuardarAlgoritmoEventHandler(SectorAlgoritmo sectorAlgoritmo,
                                             SectorBloque sectorBloque,
                                             VistaBotoneraDeBloques vistaBotoneraDeBloques,
                                             VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                             TextField nombreIngresado){

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloque = sectorBloque;
        this.vistaBotoneraDeBloques = vistaBotoneraDeBloques;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.nombreIngresado = nombreIngresado;

    }

    @Override
    public void handle(ActionEvent actionEvent){



        if(this.nombreIngresado.getText().trim().equals("")){

            //TODO manejar como indicar al usuario que no debe ingresar texto vacio
            this.nombreIngresado.setText("");

        } else {

            this.sectorAlgoritmo.crearNuevoAlgoritmoPersonalizado(sectorBloque, this.nombreIngresado.getText());

            this.vistaBotoneraDeBloques.agregarBloquePersonalizado(this.nombreIngresado.getText());
            this.nombreIngresado.setText("");

        }




    }

}
