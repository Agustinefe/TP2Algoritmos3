package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public interface EstadoDeLapiz {

    LapizArriba subirLapiz();

    LapizAbajo bajarLapiz();

    boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada);

}
