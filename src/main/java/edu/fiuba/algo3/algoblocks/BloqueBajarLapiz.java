package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.excepciones.AccesoNoPermitidoException;

public class BloqueBajarLapiz implements Bloque{


    public BloqueBajarLapiz(){

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje) {

        estePersonaje.bajarLapiz();

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje) {

        estePersonaje.subirLapiz();

    }

    @Override
    public int tamanio(){

        return 1;

    }

    /*
    //Rompe el principio de segregacion de interfaz
    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion) throws AccesoNoPermitidoException {

        throw new AccesoNoPermitidoException();

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicion) throws AccesoNoPermitidoException{

        throw new AccesoNoPermitidoException();

    }
     */

    @Override
    public Bloque duplicar(){
        return new BloqueBajarLapiz();
    }
}
