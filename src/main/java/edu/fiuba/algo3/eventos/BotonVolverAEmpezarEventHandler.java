package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 27/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVolverAEmpezarEventHandler implements EventHandler<ActionEvent> {

    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private SectorAlgoritmo sectorAlgoritmo;

    public BotonVolverAEmpezarEventHandler(VistaEspacioDeTrabajo vistaEspacioDeTrabajo, SectorAlgoritmo sectorAlgoritmo){

        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.sectorAlgoritmo = sectorAlgoritmo;

    }

    public void handle(ActionEvent actionEvent){

        this.sectorAlgoritmo.vaciar();
        this.vistaEspacioDeTrabajo.reiniciar();

    }


}
