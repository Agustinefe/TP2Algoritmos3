package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasPizarra {

    private Pizarra miPizarra;
    private Celda celdaCentro;

    @BeforeEach

    public void setUp(){

        this.miPizarra = new Pizarra(5, 5);
       celdaCentro = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(2, 3, new Derecha());

    }

    @Test
    public void test01ObtengoLaMismaCeldaYendoDerechaYArriba(){

        Celda celdaDerecha = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(2, 3, new Derecha());
        Celda celdaArriba = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(3, 2, new Arriba());

        assertTrue(celdaDerecha.esIgualA(celdaArriba));

    }

    @Test
    public void test02ObtengoLaMismaCeldaYendoIzquierdaAbajoYAbajoIzquierda(){

        Celda celdaAbajo= miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(1,2, new Abajo());
        Celda celdaIzquierda = miPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(2,1, new Izquierda());

        assertTrue(celdaAbajo.esIgualA(celdaIzquierda));

    }

    @Test
    public void test03ObtengoCorrectamenteLaCeldaCentral(){

        Celda celdaConMismasCoordenadasQueLaCentral = new Celda(2, 2);

        assertTrue(celdaConMismasCoordenadasQueLaCentral.esIgualA(miPizarra.obtenerCeldaCentral()));

    }

    /*Pensar mas pruebas*/


}
