package edu.fiuba.algo3;/* Author: firmapaz ;created on 23/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega3Tests {

    private Tablero juego;

    @BeforeEach
    public void setUp(){

        this.juego = new Tablero();

    }

    @Test
    public void test01CreoUnaSecuenciaYLaEjecuto(){

        SecuenciaDeBloques secuencia1 = new SecuenciaDeBloques();

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(1), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(2), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(2), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(6), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(6), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(0), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(3), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(1), 0, 9);

        this.juego.iniciarSecuenciaDeEjecucion();
        Celda celdaFinalEstimada = new Celda(6, 2);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));

    }

    @Test
    public void test02CreoUnaSecuenciaLaDividoGuardoUnNuevoAlgoritmoLimpioElEspacioDeTrabajoYEjecutoElAlgoritmoPersonalizado(){

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(1), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(2), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(2), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(6), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(6), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(0), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(3), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(1), 0, 9);

        this.juego.separarBloquesEnEspacioDeTrabajo(0, 3);
        this.juego.agregarAlgoritmoPersonalizadoAlSectorDeBloques();
        this.juego.reiniciarEspacioDeTrabajo();
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque(9), 0, 0);
        this.juego.iniciarSecuenciaDeEjecucion();

        Celda celdaFinalEstimada = new Celda(3, 6);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));
        
    }

}
