package edu.fiuba.algo3.algoblocks;

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
