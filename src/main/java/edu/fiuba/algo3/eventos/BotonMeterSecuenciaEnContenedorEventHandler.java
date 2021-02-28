package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 27/2/21*/

import edu.fiuba.algo3.algoblocks.BloqueContenedor;
import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonMeterSecuenciaEnContenedorEventHandler implements EventHandler<ActionEvent> {

    private SectorAlgoritmo sectorAlgoritmo;
    private BloqueContenedor bloqueContenedor;
    private VistaEspacioDeTrabajo vistaEspacioDeTrabajo;
    private String nombreBloque;

    public BotonMeterSecuenciaEnContenedorEventHandler(SectorAlgoritmo sectorAlgoritmo,
                                                       BloqueContenedor bloqueContenedor,
                                                       VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                                        String nombreBloque){

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.bloqueContenedor = bloqueContenedor;
        this.vistaEspacioDeTrabajo = vistaEspacioDeTrabajo;
        this.nombreBloque = nombreBloque;

    }


    @Override
    public void handle(ActionEvent actionEvent){

        //TODO este casteo esta raro
        this.sectorAlgoritmo.meterSecuenciaEnContenedor((BloqueContenedor) this.bloqueContenedor.duplicar(), 0);
        this.vistaEspacioDeTrabajo.meterSecuenciaEnContenedor(nombreBloque);

    }

}
