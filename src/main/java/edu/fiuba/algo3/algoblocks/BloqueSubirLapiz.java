package edu.fiuba.algo3.algoblocks;

public class BloqueSubirLapiz implements Bloque{

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.subirLapiz();

    }

}
