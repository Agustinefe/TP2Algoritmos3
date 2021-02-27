package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 27/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.algoblocks.Pizarra;
import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.vista.VistaPizarraDeDibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent> {

    private Button miBoton;
    private VistaPizarraDeDibujo vista;
    private Personaje personaje;
    private SectorAlgoritmo sectorAlgoritmo;

    public BotonReiniciarEventHandler(Button miBoton, VistaPizarraDeDibujo vista, Personaje personaje, SectorAlgoritmo sectorAlgoritmo){

        this.miBoton = miBoton;
        this.vista = vista;
        this.personaje = personaje;
        this.sectorAlgoritmo = sectorAlgoritmo;

        miBoton.setText("Reiniciar");

    }

    @Override
    public void handle(ActionEvent actionEvent){

        Pizarra.getInstance().blanquearTodo();
        personaje.regresarAlCentro();
        this.vista.clear();
        miBoton.setOnAction(new BotonEjecutarEventHandler(this.miBoton, this.vista, this.personaje, this.sectorAlgoritmo));

    }

}
