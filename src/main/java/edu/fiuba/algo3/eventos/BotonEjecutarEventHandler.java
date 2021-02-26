package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 14/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.vista.VistaPizarraDeDibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public class BotonEjecutarEventHandler implements EventHandler<ActionEvent> {

    private Button miBoton;
    private VistaPizarraDeDibujo vista;
    private Personaje personaje;

    public BotonEjecutarEventHandler(Button miBoton, VistaPizarraDeDibujo vista, Personaje personaje){

        this.miBoton = miBoton;
        this.vista = vista;
        this.personaje = personaje;
        miBoton.setText("Ejecutar");

    }

    @Override
    public void handle(ActionEvent actionEvent){

        vista.update();
        miBoton.setOnAction(new BotonReiniciarEventHandler(miBoton, vista, personaje));

    }

}
