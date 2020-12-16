package edu.fiuba.algo3.algoblocks;

public class Lapiz {

    private EstadoDeLapiz estado;

    public Lapiz(){

        this.estado = new LapizArriba();
    }

    public void subirLapiz(){

        this.estado = this.estado.subirLapiz();

    }

    public void bajarLapiz(){

        this.estado = this.estado.bajarLapiz();

    }

    public boolean dibujar(Celda celdaDeInicio, Celda celdaDeLlegada){

        return this.estado.dibujar(celdaDeInicio, celdaDeLlegada);

    }

}
