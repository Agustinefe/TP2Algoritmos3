package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class SectorAlgoritmo {

    private ArrayList<Bloque> secuenciaDeEjecucion;
    private ArrayList<ArrayList<Bloque>> bloquesIndependientes;

    public SectorAlgoritmo(){

        this.secuenciaDeEjecucion = new ArrayList<Bloque>();
        this.bloquesIndependientes = new ArrayList<ArrayList<Bloque>>();

    }

    public void aniadirBloqueAlFinal(Bloque esteBloque){

        this.secuenciaDeEjecucion.add(esteBloque);

    }

    public void aniadirBloqueEnPosicion(Bloque esteBloque, int posicion){

        this.secuenciaDeEjecucion.add(posicion, esteBloque);

    }

    public void aniadirSecuenciaDeBloquesEnPosicion(ArrayList<Bloque> secuenciaDeBloques, int posicion){

        this.secuenciaDeEjecucion.addAll(posicion, secuenciaDeBloques);

    }

    public void eliminarBloquesDeLaSecuenciaDeEjecucionDesdePosicion(int posicion){

        while(posicion < this.secuenciaDeEjecucion.size()){

            this.secuenciaDeEjecucion.remove(posicion);

        }

    }

    public void removerBloquesDeLaSecuenciaDeEjecucionDesdePosicion(int posicion){



        while(posicion < this.secuenciaDeEjecucion.size()){



        }

    }

    public void ejecutarAlgoritmoEn(SectorDibujo pizarra){

        this.secuenciaDeEjecucion.stream().forEach(pizarra::ejecutarBloque);

    }

}