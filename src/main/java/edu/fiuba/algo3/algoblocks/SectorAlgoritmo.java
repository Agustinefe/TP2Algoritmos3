package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import edu.fiuba.algo3.playground.OrganizadorDeObjetos;
import edu.fiuba.algo3.excepciones.OrganizadorOcupadoException;

import java.util.ArrayList;

public class SectorAlgoritmo {

    private ArrayList<Bloque> secuenciaDeEjecucion;
    private OrganizadorDeObjetos<Bloque> manito;
    private ArrayList<ArrayList<Bloque>> espacioDeTrabajo;

    public SectorAlgoritmo(){

        this.secuenciaDeEjecucion = new ArrayList<Bloque>();
        this.espacioDeTrabajo = new ArrayList<ArrayList<Bloque>>();
        this.manito = new OrganizadorDeObjetos<Bloque>();

    }

    /*BLOQUE --> EJECUCION*/
    public void aniadirBloqueASecuenciaDeEjecucion(Bloque esteBloque){


        this.secuenciaDeEjecucion.add(esteBloque);

    }

    public void aniadirBloqueASecuenciaDeEjecucion(Bloque esteBloque, int posicion){

        this.secuenciaDeEjecucion.add(posicion, esteBloque);

    }

    public void aniadirBloqueAEspacioDeTrabajo(Bloque esteBloque){

        ArrayList<Bloque> nuevoBloque = new ArrayList<Bloque>();
        nuevoBloque.add(esteBloque);
        this.espacioDeTrabajo.add(nuevoBloque);

    }

    public void aniadirBloqueASucesionDeBloquesDelEspacioDeTrabajoEnPosicion( Bloque esteBloque,
                                                                              int posicionDeSucesionEnEspacioDeTrabajo,
                                                                              int posicionDentroDeLaSucesion){

        this.espacioDeTrabajo.get(posicionDeSucesionEnEspacioDeTrabajo).add(posicionDentroDeLaSucesion, esteBloque);

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

        ArrayList<Bloque> nuevaSublistaDeBloquesLibres = new ArrayList<Bloque>();
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

    public void ejecutarAlgoritmoEn(SectorDibujo pizarra){

        this.secuenciaDeEjecucion.stream().forEach(pizarra::ejecutarBloque);

    }

}