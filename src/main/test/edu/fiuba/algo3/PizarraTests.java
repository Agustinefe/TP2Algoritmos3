package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizarraTests {

    private Pizarra miPizarra;
    private Celda celdaCentro;

    @BeforeEach

    public void setUp(){

        this.miPizarra = new Pizarra(9, 9);
        celdaCentro = miPizarra.obtenerCeldaCentral();
    }

    @Test
    public void test01ObtengoLaMismaCeldaYendoDerechaYArriba(){

        Celda celdaDerecha = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(4, 5, new Derecha());
        Celda celdaArriba = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(5, 4, new Arriba());

        assertTrue(celdaDerecha.esIgualA(celdaArriba));

    }

    @Test
    public void test02ObtengoLaMismaCeldaYendoIzquierdaAbajoYAbajoIzquierda(){

        Celda celdaAbajo= miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(3,4, new Abajo());
        Celda celdaIzquierda = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(4,3, new Izquierda());

        assertTrue(celdaAbajo.esIgualA(celdaIzquierda));

    }

    @Test
    public void test03ObtengoCorrectamenteLaCeldaCentral(){

        Celda celdaConMismasCoordenadasQueLaCentral = new Celda(4, 4);

        assertTrue(celdaConMismasCoordenadasQueLaCentral.esIgualA(miPizarra.obtenerCeldaCentral()));

    }

    /*Pensar mas pruebas*/


}
