package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueMovimiento implements Bloque {

    private DireccionDeMovimiento direccion;

    public BloqueMovimiento(DireccionDeMovimiento nuevaDireccion){

        this.direccion = nuevaDireccion;

    }

    @Override
    public String ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.moversePorLaPizarraHacia(pizarraDeDibujo, this.direccion);
        return ("Mueve " + this.direccion.nombre());

    }


}
