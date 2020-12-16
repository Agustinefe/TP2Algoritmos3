package edu.fiuba.algo3.algoblocks;

public interface EstadoDeLapiz {

    public abstract LapizArriba subirLapiz();

    public abstract LapizAbajo bajarLapiz();

    public abstract boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada);

}
