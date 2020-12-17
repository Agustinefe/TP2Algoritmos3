package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class LapizArriba implements EstadoDeLapiz{

    public LapizArriba subirLapiz(){

        return this;

    }

    public LapizAbajo bajarLapiz(){

        return (new LapizAbajo());

    }

    public boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada){

        return false;

    }

}
