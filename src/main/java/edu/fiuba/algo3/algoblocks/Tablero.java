package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;

public class Tablero {

    Personaje dibujante;
    private SectorAlgoritmo sectorDeAlgoritmos;
    private SectorBloque sectorDeBloques;

    public Tablero(){

        this.dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        this.sectorDeAlgoritmos = new SectorAlgoritmo();
        this.sectorDeBloques = new SectorBloque();

    }

    public SecuenciaDeBloques crearNuevoBloque(int posicionDelTipoDeBloque){

        return this.sectorDeBloques.nuevoBloque(posicionDelTipoDeBloque);

    }

    public void insertarBloqueEnEspacioDeTrabajo(SecuenciaDeBloques nuevaSecuencia, int posEspacioDeTrabajo, int posDentroDeLaSecuencia){

        this.sectorDeAlgoritmos.insertarSecuenciaEnEspacioDeTrabajo(nuevaSecuencia, posEspacioDeTrabajo, posDentroDeLaSecuencia);

    }

    public SecuenciaDeBloques separarBloquesEnEspacioDeTrabajo(int posEspacioDeTrabajo, int posDentroDeLaSecuencia){

        return this.sectorDeAlgoritmos.separarSecuenciaEnEspacioDeTrabajo(posEspacioDeTrabajo, posDentroDeLaSecuencia);

    }

    public void iniciarSecuenciaDeEjecucion(){

        this.sectorDeAlgoritmos.ejecutarSecuenciaDeEjecucion(this.dibujante);

    }

    public void agregarAlgoritmoPersonalizadoAlSectorDeBloques(){

        this.sectorDeAlgoritmos.crearNuevoAlgoritmoPersonalizado(this.sectorDeBloques);

    }

    public void reiniciarEspacioDeTrabajo(){

        this.sectorDeAlgoritmos.vaciar();

    }

    public void reiniciarSectorDeDibujo(){

        this.dibujante.regresarAlCentro();
        Pizarra.getInstance().blanquearTodo();

    }

    public boolean dibujanteSeEncuentraEn(Celda celdaEstimada){

        return this.dibujante.seEncuentraEn(celdaEstimada);

    }

}
