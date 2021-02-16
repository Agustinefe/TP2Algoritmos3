package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizarraTests {

    private Celda celdaCentro;

    @BeforeEach

    public void setUp(){

        Pizarra.getInstance().blanquearTodo();
        celdaCentro = Pizarra.getInstance().obtenerCeldaCentral();
    }

    @Test
    public void test01ObtengoLaMismaCeldaYendoDerechaYArriba(){

        Celda celdaDerecha = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(4, 5, new Derecha());
        Celda celdaArriba = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(5, 4, new Arriba());

        assertTrue(celdaDerecha.esIgualA(celdaArriba));

    }

    @Test
    public void test02ObtengoLaMismaCeldaYendoIzquierdaAbajoYAbajoIzquierda(){

        Celda celdaAbajo= Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(3,4, new Abajo());
        Celda celdaIzquierda = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(4,3, new Izquierda());

        assertTrue(celdaAbajo.esIgualA(celdaIzquierda));

    }

    @Test
    public void test03ObtengoCorrectamenteLaCeldaCentral(){

        Celda celdaConMismasCoordenadasQueLaCentral = new Celda(4, 4);

        assertTrue(celdaConMismasCoordenadasQueLaCentral.esIgualA(Pizarra.getInstance().obtenerCeldaCentral()));

    }

    /*Pensar mas pruebas*/


}
