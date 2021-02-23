package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;

public class SectorAlgoritmo {

    private ArrayList<SecuenciaDeBloques> espacioDeTrabajo;

    public SectorAlgoritmo() {

        this.espacioDeTrabajo = new ArrayList<SecuenciaDeBloques>();
        this.espacioDeTrabajo.add(new SecuenciaDeBloques());

    }
    /*Lanza una excepcion si la la posicion en alguna de las listas se encuentra fuera de rango*/
    public void insertarSecuenciaEnEspacioDeTrabajo(SecuenciaDeBloques nuevaSecuencia, int posicionEnEspacioDeTrabajo,
                                                    int posicionDentroDeSecuenciaReceptora) throws RuntimeException{
        try{
            this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo).insertarSecuenciaEn(nuevaSecuencia,
                    posicionDentroDeSecuenciaReceptora);
        } catch (IndexOutOfBoundsException error){

            this.espacioDeTrabajo.add(nuevaSecuencia);

        }


    }

    /*Lanza una excepcion si la la posicion en alguna de las listas se encuentra fuera de rango*/
    public SecuenciaDeBloques separarSecuenciaEnEspacioDeTrabajo(int posicionEnEspacioDeTrabajo,
                                                   int posicionDentroDeSecuenciaReceptora) throws RuntimeException{

        SecuenciaDeBloques secuenciaObtenida = this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo)
                .separarLaSecuenciaEn(posicionDentroDeSecuenciaReceptora);

        //¿Que hago si la secuencia queda vacia? ¿Como la elimino del arraylist sin preguntarle si se encuentra vacia?

        return secuenciaObtenida;

    }

    /*Lanza una excepcion si la la posicion en alguna de las listas se encuentra fuera de rango*/
    public void eliminarSecuenciaEnEspacionDeTrabajo(int posicionEnEspacioDeTrabajo,
                                                     int posicionDentroDeSecuenciaReceptora) throws RuntimeException{

        this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo).separarLaSecuenciaEn(posicionDentroDeSecuenciaReceptora);

    }

    public void crearNuevoAlgoritmoPersonalizado(SectorBloque sectorBloqueReceptor){

       sectorBloqueReceptor.crearAlgoritmoPersonalizado(this.espacioDeTrabajo.get(0).duplicar());

    }

    public void vaciar(){

        this.espacioDeTrabajo.clear();

    }


    public void ejecutarSecuenciaDeEjecucion(Personaje dibujante){

        this.espacioDeTrabajo.get(0).ejecutarComportamientoSobrePizarraEn(dibujante);

    }



}