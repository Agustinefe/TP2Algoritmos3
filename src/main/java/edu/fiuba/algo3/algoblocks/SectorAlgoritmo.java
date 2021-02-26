package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;

public class SectorAlgoritmo {

    
    private ArrayList<SecuenciaDeBloques> espacioDeTrabajo;

    public SectorAlgoritmo() {

        this.espacioDeTrabajo = new ArrayList<SecuenciaDeBloques>();
        this.espacioDeTrabajo.add(new SecuenciaDeBloques());

    }

    public void insertarSecuenciaEnEspacioDeTrabajo(SecuenciaDeBloques nuevaSecuencia, int posicionEnEspacioDeTrabajo) throws RuntimeException{

        try{

            this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo).juntar(nuevaSecuencia);

        } catch (IndexOutOfBoundsException error){

            this.espacioDeTrabajo.add(nuevaSecuencia);

        }

    }

    public void insertarSecuenciaEnEspacioDeTrabajo(SecuenciaDeBloques nuevaSecuencia, int posicionEnEspacioDeTrabajo,
                                                    int posicionDentroDeSecuenciaReceptora) throws RuntimeException{
        try{
            this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo).juntar(nuevaSecuencia,
                    posicionDentroDeSecuenciaReceptora);
        } catch (IndexOutOfBoundsException error){

            this.espacioDeTrabajo.add(nuevaSecuencia);

        }


    }

    public SecuenciaDeBloques separarSecuenciaEnEspacioDeTrabajo(int posicionEnEspacioDeTrabajo,
                                                   int posicionDentroDeSecuenciaReceptora) throws RuntimeException{

        SecuenciaDeBloques secuenciaObtenida = this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo)
                .separar(posicionDentroDeSecuenciaReceptora);

        //¿Que hago si la secuencia queda vacia? ¿Como la elimino del arraylist sin preguntarle si se encuentra vacia?

        return secuenciaObtenida;

    }

    public SecuenciaDeBloques removerBloqueParticular(int posicionEnEspacioDeTrabajo,
                                                      int posicionDentroDeSecuenciaReceptora){

        return this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo).removerBloque(posicionDentroDeSecuenciaReceptora);

    }

    public void crearNuevoAlgoritmoPersonalizado(SectorBloque sectorBloqueReceptor, String nombre){

       sectorBloqueReceptor.crearAlgoritmoPersonalizado(this.espacioDeTrabajo.get(0).duplicar(), nombre);

    }

    public void vaciar(){

        this.espacioDeTrabajo.clear();
        this.espacioDeTrabajo.add(new SecuenciaDeBloques());

    }

    public void meterSecuenciaEnContenedor(BloqueContenedor contenedor, int posicionEnEspacioDeTrabajo){

        contenedor.juntar(this.espacioDeTrabajo.get(posicionEnEspacioDeTrabajo), 0);
        ArrayList<Bloque> contenedorEnLista = new ArrayList<>();
        contenedorEnLista.add(contenedor);
        this.espacioDeTrabajo.set(posicionEnEspacioDeTrabajo, new SecuenciaDeBloques(contenedorEnLista));

    }


    public void ejecutarSecuenciaDeEjecucion(Personaje dibujante){

        this.espacioDeTrabajo.get(0).ejecutarComportamientoSobrePizarraEn(dibujante);

    }



}