package edu.fiuba.algo3.modelo;/* Author: firmapaz ;created on 14/2/21*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MyButtonEventHandler implements EventHandler<ActionEvent> {

    private Button miBoton;
    private NombreMyButtonEventHandler proximoNombre;

    public MyButtonEventHandler (Button miBoton){

        this.miBoton = miBoton;
        miBoton.setText("Ejecutar");
        this.proximoNombre = new NombreMyButtonEventHandler();

    }

    @Override
    public void handle(ActionEvent actionEvent){

        String textoClickeado = this.proximoNombre.actualizarNombreBoton();
        System.out.println(textoClickeado);
        this.miBoton.setText(textoClickeado);

    }

}
