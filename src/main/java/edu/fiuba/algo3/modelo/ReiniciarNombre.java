package edu.fiuba.algo3.modelo;/* Author: firmapaz ;created on 15/2/21*/

public class ReiniciarNombre implements DadorDeNombreDeBoton{

    private String nombre = "Reiniciar";

    @Override
    public String retornarNombre(){

        return this.nombre;

    }

    @Override
    public DadorDeNombreDeBoton cambiarDador(){

        return new EjecutarNombre();

    }

}
