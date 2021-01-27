package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueSubirLapiz implements Bloque{

    @Override
    public String ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.subirLapiz();
        return "Sube Lapiz";

    }

}
