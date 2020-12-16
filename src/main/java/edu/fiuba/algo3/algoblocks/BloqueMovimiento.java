package edu.fiuba.algo3.algoblocks;

public class BloqueMovimiento implements Bloque {

    private DireccionDeMovimiento direccion;

    public BloqueMovimiento(DireccionDeMovimiento nuevaDireccion){

        this.direccion = nuevaDireccion;

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.moversePorLaPizarraHacia(pizarraDeDibujo, this.direccion);

    }
}
