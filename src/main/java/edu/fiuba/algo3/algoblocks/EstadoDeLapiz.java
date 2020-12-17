package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public interface EstadoDeLapiz {

    public abstract LapizArriba subirLapiz();

    public abstract LapizAbajo bajarLapiz();

    public abstract boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada);

}
