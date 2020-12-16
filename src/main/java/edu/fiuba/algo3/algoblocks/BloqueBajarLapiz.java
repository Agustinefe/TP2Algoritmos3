package edu.fiuba.algo3.algoblocks;

public class BloqueBajarLapiz implements Bloque{

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        estePersonaje.bajarLapiz();

    }

}
