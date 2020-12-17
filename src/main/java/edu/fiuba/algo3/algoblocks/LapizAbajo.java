package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class LapizAbajo implements EstadoDeLapiz{

    public LapizArriba subirLapiz(){

        return (new LapizArriba());

    }

    public LapizAbajo bajarLapiz(){

        return this;

    }

    public boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada){

        celdaDeInicio.dibujar();
        celdaDeLlegada.dibujar();
        return true;

    }

}
