package edu.fiuba.algo3.algoblocks;

public interface ICelda {

    public abstract Celda obtenerCeldaQueEstaALa(DireccionDeMovimiento direccionALaQueSeMueveElPersonaje, Pizarra estaPizarra);

    public abstract boolean dibujar();

    public boolean esIgualA(Celda otraCelda);

}
