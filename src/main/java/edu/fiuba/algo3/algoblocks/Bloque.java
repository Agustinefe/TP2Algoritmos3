package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public interface Bloque {

    public abstract void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje);

    @Override
    public abstract boolean equals(Object o);
}

