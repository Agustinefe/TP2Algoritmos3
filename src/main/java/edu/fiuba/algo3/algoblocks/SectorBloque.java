package edu.fiuba.algo3.algoblocks;

public class SectorBloque {

    public BloqueMovimiento crearBloqueDeMovimiento(DireccionDeMovimiento direccion) {

        return new BloqueMovimiento(direccion);

    }

    public BloqueSubirLapiz crearBloqueSubirLapiz(){

        return new BloqueSubirLapiz();

    }

    public BloqueBajarLapiz crearBloqueBajarLapiz(){

        return new BloqueBajarLapiz();

    }

}
