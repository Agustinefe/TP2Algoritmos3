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
        Pizarra.getInstance().blanquearTodo();

    }

    @Test
    public void test01CreoUnaSecuenciaYLaEjecuto(){

        SecuenciaDeBloques secuencia1 = new SecuenciaDeBloques();

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("arriba"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("repeticion x2"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("repeticion x2"), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("derecha"), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("abajo"), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("izquierda"), 0, 9);

        this.juego.iniciarSecuenciaDeEjecucion();
        Celda celdaFinalEstimada = new Celda(3, 5);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));

    }

    @Test
    public void test02CreoUnaSecuenciaLaDividoGuardoUnNuevoAlgoritmoLimpioElEspacioDeTrabajoYEjecutoElAlgoritmoPersonalizado(){

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("arriba"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("repeticion x2"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("repeticion x2"), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("derecha"), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("abajo"), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("izquierda"), 0, 9);

        this.juego.separarBloquesEnEspacioDeTrabajo(0, 3);
        this.juego.agregarAlgoritmoPersonalizadoAlSectorDeBloques("personalizado");
        this.juego.reiniciarEspacioDeTrabajo();
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("personalizado"), 0, 0);
        this.juego.iniciarSecuenciaDeEjecucion();

        Celda celdaFinalEstimada = new Celda(3, 6);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));
        
    }

    @Test
    public void test03EjecutoUnaSecuenciaLimpioElSectorDeDibujo(){

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("bajar lapiz"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("derecha"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("abajo"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("derecha"), 0, 4);

        this.juego.meterSecuenciaEnContenedor(new BloqueInvertirComportamiento(), 0);

        this.juego.iniciarSecuenciaDeEjecucion();
        Celda celdaFinalEstimada = new Celda(2, 4);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));

        this.juego.agregarAlgoritmoPersonalizadoAlSectorDeBloques("cacerola");

        /*Ahora voy a limpiar el sector de dibujo y verificar que la ultima celda pisada no este dibujada*/

        this.juego.reiniciarSectorDeDibujo();
        this.juego.reiniciarEspacioDeTrabajo();

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("abajo"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("cacerola"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("derecha"), 0, 4);

        this.juego.iniciarSecuenciaDeEjecucion();

        celdaFinalEstimada = new Celda(2, 3);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));
    }

}
