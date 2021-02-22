package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

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

    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion){

        //NADA, ACA DEBERIA TIRAR ERROR

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicion) throws RuntimeException{

        return new SecuenciaDeBloques();

    }

    @Override
    public Bloque duplicar(){
        return new BloqueBajarLapiz();
    }
}
