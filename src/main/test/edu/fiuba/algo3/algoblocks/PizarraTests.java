package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import edu.fiuba.algo3.excepciones.FueraDePizarraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

        Celda celdaDerecha = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(new Coordenadas(
                Pizarra.getInstance().xCentral(), (Pizarra.getInstance().yCentral()) + 1), new Derecha());

        Celda celdaArriba = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(new Coordenadas(
                Pizarra.getInstance().xCentral() + 1, Pizarra.getInstance().yCentral()), new Arriba());

        assertTrue(celdaDerecha.esIgualA(celdaArriba));

    }

    @Test
    public void test02ObtengoLaMismaCeldaYendoIzquierdaAbajoYAbajoIzquierda(){

        Celda celdaAbajo= Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(new Coordenadas(
                Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral()), new Abajo());
        Celda celdaIzquierda = Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(new Coordenadas(
                Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral() - 1), new Izquierda());

        assertTrue(celdaAbajo.esIgualA(celdaIzquierda));

    }

    @Test
    public void test03ObtengoCorrectamenteLaCeldaCentral(){

        Celda celdaConMismasCoordenadasQueLaCentral = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral());

        assertTrue(celdaConMismasCoordenadasQueLaCentral.esIgualA(Pizarra.getInstance().obtenerCeldaCentral()));

    }


    @Test

    public void test04SalirmeDeLosLimitesDeLaPizarraLanzaUnaExcepcion(){

        Executable task = () -> {
            Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(new Coordenadas(
                    Pizarra.getInstance().xCentral() * 2 , Pizarra.getInstance().yCentral() + 6), new Derecha());
        };

        assertThrows(FueraDePizarraException.class, task);

    }


}
