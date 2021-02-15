package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueBajarLapiz implements Bloque{


    public BloqueBajarLapiz(){

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.bajarLapiz();

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.subirLapiz();

    }
}
