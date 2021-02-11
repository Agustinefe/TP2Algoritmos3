package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueBajarLapiz implements Bloque{

    private Bloque bloqueSiguiente;

    public BloqueBajarLapiz(){

        bloqueSiguiente = new BloqueTerminal();

    }

    @Override
    public String ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.bajarLapiz();
        return "Sube Lapiz";

    }


}
