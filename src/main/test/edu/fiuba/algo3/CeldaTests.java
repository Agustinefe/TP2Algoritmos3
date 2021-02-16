package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CeldaTests {

    //private Pizarra miPizarra;
    private Celda celdaCentral;

    @BeforeEach

    public void setUp(){

       //this.miPizarra = new Pizarra(9, 9);
       this.celdaCentral = Pizarra.getInstance().obtenerCeldaCentral();

    }

    @Test

    public void test01DibujarDevuelveTrue(){

        assertTrue(this.celdaCentral.dibujar());

    }

    @Test
    public void test02LlegoALaCeldaDiagonalArribaDerechaPorCaminosDistintos(){

        Celda celdaArribaDeLaCentral = this.celdaCentral.obtenerCeldaQueEstaALa(new Arriba());
        Celda celdaDerechaDeLaCentral = this.celdaCentral.obtenerCeldaQueEstaALa(new Derecha());

        assertFalse(celdaArribaDeLaCentral.esIgualA(celdaDerechaDeLaCentral));

        Celda derechaDeLaCeldaArriba = celdaArribaDeLaCentral.obtenerCeldaQueEstaALa(new Derecha());
        Celda arribaDeLaCeldaDerecha = celdaDerechaDeLaCentral.obtenerCeldaQueEstaALa(new Arriba());

        assertTrue(derechaDeLaCeldaArriba.esIgualA(arribaDeLaCeldaDerecha));

    }

    @Test
    public void test03SeMueveDerechaArribaArribaIzquierda(){

        ArrayList<DireccionDeMovimiento> listaDeMovimientos = new ArrayList<DireccionDeMovimiento>();

        listaDeMovimientos.add(new Derecha());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Izquierda());

        Celda celdaActual = this.celdaCentral;

        Celda celdaFinalEstimada = new Celda(4, 6);

        for(int i = 0; i < listaDeMovimientos.size(); i++){

            celdaActual = celdaActual.obtenerCeldaQueEstaALa(listaDeMovimientos.get(i));

        }

        assertTrue(celdaActual.esIgualA(celdaFinalEstimada));

    }

}
