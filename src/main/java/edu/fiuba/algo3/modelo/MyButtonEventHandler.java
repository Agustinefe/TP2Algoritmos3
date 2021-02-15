package edu.fiuba.algo3.modelo;/* Author: firmapaz ;created on 14/2/21*/

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MyButtonEventHandler implements EventHandler<ActionEvent> {

    private Button miBoton;

    public MyButtonEventHandler (Button miBoton){

        this.miBoton = miBoton;

    }

    @Override
    public void handle(ActionEvent actionEvent){

        String textoClickeado = "Me han clickeado";
        System.out.println(textoClickeado);
        this.miBoton.setText(textoClickeado);

    }

}
