package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class BloqueMovimiento implements Bloque {

    private DireccionDeMovimiento direccion;

    public BloqueMovimiento(DireccionDeMovimiento nuevaDireccion){

        this.direccion = nuevaDireccion;

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.moversePorLaPizarraHacia(pizarraDeDibujo, this.direccion);

    }

    @Override
    public boolean equals(Object o){

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloqueMovimiento otroBloque = (BloqueMovimiento) o;
        return otroBloque.apuntaALaMismaDireccion(direccion);

    }

    private boolean apuntaALaMismaDireccion(DireccionDeMovimiento direccion){

        return this.direccion.equals(direccion);

    }
}
