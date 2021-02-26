package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 25/2/21*/

import edu.fiuba.algo3.algoblocks.Bloque;
import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.algoblocks.SecuenciaDeBloques;
import edu.fiuba.algo3.vista.VistaEspacioDeTrabajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonGenerarBloqueNuevoEventHandler implements EventHandler<ActionEvent> {

    private SectorBloque sectorBloque;
    private SectorAlgoritmo sectorAlgoritmo;
    private int posicionDeBloque;

    public BotonGenerarBloqueNuevoEventHandler(SectorBloque sectorBloque,
                                               SectorAlgoritmo sectorAlgoritmo,
                                               int posicionDeBloque
                                               ){

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloque = sectorBloque;
        this.posicionDeBloque = posicionDeBloque;


    }

    @Override
    public void handle(ActionEvent actionEvent){

        //SecuenciaDeBloques nuevoBloque = this.sectorBloque.nuevoBloque(this.posicionDeBloque);
        //this.sectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(nuevoBloque, 0);



    }

}
