package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public interface Bloque {

    void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje);

    void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje);

    int tamanio();

    void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion);

    SecuenciaDeBloques separarLaSecuenciaEn(int posicion);

    Bloque duplicar();



}

