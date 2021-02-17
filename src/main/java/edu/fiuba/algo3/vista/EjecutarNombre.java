package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 15/2/21*/

public class EjecutarNombre implements DadorDeNombreDeBoton{

    private String nombre = "Ejecutar";

    @Override
    public String retornarNombre(){

        return this.nombre;

    }

    @Override
    public DadorDeNombreDeBoton cambiarDador(){

        return new ReiniciarNombre();

    }

}
