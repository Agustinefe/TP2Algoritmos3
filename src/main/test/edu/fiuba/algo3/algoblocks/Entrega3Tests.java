package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 23/2/21*/

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

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Arriba"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Repetir 2 veces"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Repetir 2 veces"), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Derecha"), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Abajo"), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Izquierda"), 0, 9);

        this.juego.iniciarSecuenciaDeEjecucion();
        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() + 1);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));

    }

    @Test
    public void test02CreoUnaSecuenciaLaDividoGuardoUnNuevoAlgoritmoLimpioElEspacioDeTrabajoYEjecutoElAlgoritmoPersonalizado(){

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Arriba"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Repetir 2 veces"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Repetir 2 veces"), 0, 4);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Derecha"), 0, 5);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Abajo"), 0, 6);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Izquierda"), 0, 9);

        this.juego.separarBloquesEnEspacioDeTrabajo(0, 3);
        this.juego.agregarAlgoritmoPersonalizadoAlSectorDeBloques("personalizado");
        this.juego.reiniciarEspacioDeTrabajo();
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("personalizado"), 0, 0);
        this.juego.iniciarSecuenciaDeEjecucion();

        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() + 2);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));
        
    }

    @Test
    public void test03EjecutoUnaSecuenciaLimpioElSectorDeDibujo(){

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Bajar lapiz"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Arriba"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Derecha"), 0, 2);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Abajo"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Derecha"), 0, 4);

        this.juego.meterSecuenciaEnContenedor(new BloqueInvertirComportamiento(), 0);

        this.juego.iniciarSecuenciaDeEjecucion();
        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() - 2, Pizarra.getInstance().yCentral());
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));

        this.juego.agregarAlgoritmoPersonalizadoAlSectorDeBloques("cacerola");

        /*Ahora voy a limpiar el sector de dibujo y verificar que la ultima celda pisada no este dibujada*/

        this.juego.reiniciarSectorDeDibujo();
        this.juego.reiniciarEspacioDeTrabajo();

        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Izquierda"), 0, 0);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Abajo"), 0, 1);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("cacerola"), 0, 3);
        this.juego.insertarBloqueEnEspacioDeTrabajo(this.juego.crearNuevoBloque("Derecha"), 0, 4);

        /*
        * izquierda
        * abajo
        * bajarLapiz
        * arriba
        * derecha
        * derecha
        * abajo
        * derecha
        *
        * izquierda
        * abajo
        * cacerola
        * derecha
        *
        * */

        this.juego.iniciarSecuenciaDeEjecucion();

        celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() - 2, Pizarra.getInstance().yCentral() - 1);
        assertTrue(this.juego.dibujanteSeEncuentraEn(celdaFinalEstimada));
    }

}
