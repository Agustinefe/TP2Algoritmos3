package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 27/2/21*/

public class BloquePersonalizado implements BloqueContenedor{

    private SecuenciaDeBloques secuenciaPersonalizada;

    public BloquePersonalizado(SecuenciaDeBloques secuenciaPersonalizada){

        this.secuenciaPersonalizada = secuenciaPersonalizada;

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje){

        this.secuenciaPersonalizada.ejecutarComportamientoSobrePizarraEn(estePersonaje);

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje){

        this.secuenciaPersonalizada.ejecutarComportamientoInversoSobrePizarraEn(estePersonaje);

    }

    @Override
    public Bloque duplicar(){

        return (new BloquePersonalizado(this.secuenciaPersonalizada.duplicar()));

    }

    @Override
    public void juntar(SecuenciaDeBloques nuevaSecuencia, int posicion){

        this.secuenciaPersonalizada.juntar(nuevaSecuencia, posicion);

    }

    @Override
    public SecuenciaDeBloques separar(int posicion){

        return this.secuenciaPersonalizada.separar(posicion);

    }

}
