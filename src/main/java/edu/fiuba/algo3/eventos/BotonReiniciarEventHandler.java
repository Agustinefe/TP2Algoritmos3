package edu.fiuba.algo3.eventos;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.vista.VistaPizarraDeDibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent> {

    private Button miBoton;
    private VistaPizarraDeDibujo vista;
    private Personaje personaje;

    public BotonReiniciarEventHandler(Button miBoton, VistaPizarraDeDibujo vista, Personaje personaje){

        this.miBoton = miBoton;
        this.vista = vista;
        this.personaje = personaje;
        miBoton.setText("Reiniciar");

    }

    public void handle(ActionEvent actionEvent){

        vista.clear();
        this.miBoton.setOnAction(new BotonEjecutarEventHandler(miBoton, vista, personaje));

    }

}
