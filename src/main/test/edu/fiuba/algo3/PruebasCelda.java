package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasCelda {

    private Pizarra miPizarra;
    private Celda celdaCentral;

    @BeforeEach

    public void setUp(){

       this.miPizarra = new Pizarra(7, 7);
       this.celdaCentral = miPizarra.obtenerCeldaCentral();

    }

    @Test

    public void test01DibujarDevuelveTrue(){

        assertTrue(this.celdaCentral.dibujar());

    }

    @Test
    public void test02LlegoALaCeldaDiagonalArribaDerechaPorCaminosDistintos(){

        Celda celdaArribaDeLaCentral = this.celdaCentral.obtenerCeldaQueEstaALa(new Arriba(), this.miPizarra);
        Celda celdaDerechaDeLaCentral = this.celdaCentral.obtenerCeldaQueEstaALa(new Derecha(), this.miPizarra);

        assertFalse(celdaArribaDeLaCentral.esIgualA(celdaDerechaDeLaCentral));

        Celda derechaDeLaCeldaArriba = celdaArribaDeLaCentral.obtenerCeldaQueEstaALa(new Derecha(), this.miPizarra);
        Celda arribaDeLaCeldaDerecha = celdaDerechaDeLaCentral.obtenerCeldaQueEstaALa(new Arriba(), this.miPizarra);

        assertTrue(derechaDeLaCeldaArriba.esIgualA(arribaDeLaCeldaDerecha));

    }

    /*Pensar mas pruebas*/
}
