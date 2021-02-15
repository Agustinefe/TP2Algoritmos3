package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueSubirLapiz implements Bloque{

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.subirLapiz();

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.bajarLapiz();

    }

}
