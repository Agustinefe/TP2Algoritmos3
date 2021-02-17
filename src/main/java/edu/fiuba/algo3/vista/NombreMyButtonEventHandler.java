package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 15/2/21*/

public class NombreMyButtonEventHandler {

    private DadorDeNombreDeBoton dadorActual;

    public NombreMyButtonEventHandler(){

        this.dadorActual = new ReiniciarNombre();

    }

    public String actualizarNombreBoton(){

        String nombre = this.dadorActual.retornarNombre();
        this.dadorActual = this.dadorActual.cambiarDador();
        return nombre;

    }

}
