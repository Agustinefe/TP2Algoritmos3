package edu.fiuba.algo3.playground;/* Author: firmapaz ;created on 15/12/20*/

import edu.fiuba.algo3.excepciones.OrganizadorOcupadoException;

import java.util.ArrayList;

public class ManejoDeListas {

    private ArrayList<Integer> secuenciaDeEjecucion;
    private OrganizadorDeObjetos<Integer> manito;
    private ArrayList<ArrayList<Integer>> espacioDeTrabajo;

    public ManejoDeListas(){

        this.secuenciaDeEjecucion = new ArrayList<Integer>();
        this.espacioDeTrabajo = new ArrayList<ArrayList<Integer>>();
        this.manito = new OrganizadorDeObjetos<Integer>();

    }

    /*BLOQUE --> EJECUCION*/
    public void aniadirBloqueASecuenciaDeEjecucion(Integer esteEntero){


        this.secuenciaDeEjecucion.add(esteEntero);

    }

    public void aniadirBloqueASecuenciaDeEjecucion(Integer esteEntero, int posicion){

        this.secuenciaDeEjecucion.add(posicion, esteEntero);

    }

    public void aniadirBloqueAEspacioDeTrabajo(Integer esteEntero){

        ArrayList<Integer> nuevoBloque = new ArrayList<Integer>();
        nuevoBloque.add(esteEntero);
        this.espacioDeTrabajo.add(nuevoBloque);

    }

    public void aniadirBloqueASucesionDeBloquesDelEspacioDeTrabajoEnPosicion( Integer esteEntero,
            int posicionDeSucesionEnEspacioDeTrabajo,
            int posicionDentroDeLaSucesion){

        this.espacioDeTrabajo.get(posicionDeSucesionEnEspacioDeTrabajo).add(posicionDentroDeLaSucesion, esteEntero);

    }

    public void arrojarBloquesALaBasura(){

        this.manito.soltarSucesionDeObjetosEnLaBasura();

    }


    public void agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(int posicion)
            throws OrganizadorOcupadoException {

        this.manito.agarrarSucesionDeObjetosDe(this.secuenciaDeEjecucion, posicion);

    }


    public void soltarSucesionDeBloquesEnLaSecuenciaDeEjecucionEnPosicion(int posicion) {

        this.manito.soltarSucesionDeObjetosEn(this.secuenciaDeEjecucion, posicion);

    }

    public void agarrarSucesionDeBloquesLibresDeEspacioDeTrabajo(int posicionDeSucesionEnEspacioDeTrabajo) throws OrganizadorOcupadoException{

        this.manito.agarrarSucesionDeObjetosDe(
                this.espacioDeTrabajo.remove(posicionDeSucesionEnEspacioDeTrabajo), 0);

    }

    public void soltarSucesionDeBloquesLibresEnEspacioDeTrabajo(){

        ArrayList<Integer> nuevaSublistaDeBloquesLibres = new ArrayList<Integer>();
        this.espacioDeTrabajo.add(nuevaSublistaDeBloquesLibres);
        this.manito.soltarSucesionDeObjetosEn(nuevaSublistaDeBloquesLibres, 0);

    }

    public void agarrarSucesionDeBloquesDeOtraSucesionDelEspacioDeTrabajoEnPosicion(
            int posicionDeSucesionEnEspacioDeTrabajo,
            int posicionDentroDeLaSucesion) throws OrganizadorOcupadoException{

        this.manito.agarrarSucesionDeObjetosDe(this.espacioDeTrabajo.get(posicionDeSucesionEnEspacioDeTrabajo),
                posicionDentroDeLaSucesion);

    }

    public void soltarSucesionDeBloquesEnOtraSucesionDelEspacioDeTrabajoEnPosicion(
            int posicionDeSucesionEnEspacioDeTrabajo,
            int posicionDentroDeLaSucesion){

        this.manito.soltarSucesionDeObjetosEn(this.espacioDeTrabajo.get(posicionDeSucesionEnEspacioDeTrabajo),
                posicionDentroDeLaSucesion);


    }


    public ArrayList<Integer> obtenerSecuenciaDeEjecucion(){

        return this.secuenciaDeEjecucion;

    }



    public ArrayList<ArrayList<Integer>> obtenerBloquesIndependientes(){

        return this.espacioDeTrabajo;

    }

}
