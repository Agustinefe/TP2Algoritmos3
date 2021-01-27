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

    @Override
    public void aniadirBloqueAdelante(Bloque nuevoBloque){

        this.bloqueSiguiente = nuevoBloque;

    }

    @Override
    public Bloque obtenerBloqueFinal(){

        return this.obtenerBloqueFinal(this);

    }

    private Bloque obtenerBloqueFinal(Bloque siMismo){

        return bloqueSiguiente.obtenerBloqueFinal(bloqueSiguiente);

    }

    private void cambiarSiguienteDelFinal(Bloque bloqueA){}

}
