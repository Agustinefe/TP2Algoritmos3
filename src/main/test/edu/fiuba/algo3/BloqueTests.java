package edu.fiuba.algo3;/* Author: firmapaz ;created on 16/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueTests {

    private Personaje dibujante;
    private Celda celdaDeInicio;
    private Pizarra zonaDeDibujo;

    @BeforeEach

    public void setUp(){

        this.zonaDeDibujo = new Pizarra(9, 9);
        this.celdaDeInicio = this.zonaDeDibujo.obtenerCeldaCentral();
        this.dibujante = new Personaje(this.celdaDeInicio);

    }


    @Test
    public void test01BloqueBajarLapiz(){

        (new BloqueBajarLapiz()).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaInicialEstimada = new Celda(4, 4);
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));

        (new BloqueMovimiento(new Izquierda())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);
        celdaInicialEstimada.dibujar();
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));


    }

    @Test
    public void test02BloqueSubirLapiz(){

        (new BloqueBajarLapiz()).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);
        (new BloqueSubirLapiz()).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);
        (new BloqueMovimiento(new Derecha())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaInicialEstimada = new Celda(4, 4);
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));
    }

    @Test
    public void test03BloqueMovimientoDerecha(){

        (new BloqueMovimiento(new Derecha())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(5, 4);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test04BloqueMovimientoIzquierda(){

        (new BloqueMovimiento(new Izquierda())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(3, 4);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test05BloqueMovimientoArriba(){

        (new BloqueMovimiento(new Arriba())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(4, 5);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test06BloqueMovimientoAbajo(){

        (new BloqueMovimiento(new Abajo())).ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(4, 3);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test07BloqueRepeticion(){

        BloqueRepeticion iterativo = new BloqueRepeticion();

        iterativo.establecerNuevaCantidadDeIteraciones(2);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        iterativo.aniadirBloqueEnPosicion(new BloqueBajarLapiz(), 3);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        iterativo.ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(6, 6);
        celdaActualEstimada.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));


    }

    @Test
    public void test08BloqueInvertirComportamiento(){

        BloqueInvertirComportamiento inverso = new BloqueInvertirComportamiento();

        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        inverso.aniadirBloqueEnPosicion(new BloqueSubirLapiz(), 3);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        inverso.ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(3, 3);
        celdaActualEstimada.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));

    }

    @Test
    public void test09InviertoElComportamientoDeUnBloqueRepeticion(){

        BloqueRepeticion iterativo = new BloqueRepeticion();

        iterativo.establecerNuevaCantidadDeIteraciones(2);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        iterativo.aniadirBloqueEnPosicion(new BloqueBajarLapiz(), 3);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        BloqueInvertirComportamiento inverso = new BloqueInvertirComportamiento();
        inverso.aniadirBloqueEnPosicion(iterativo, 0);

        inverso.ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(2, 2);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));

    }

    @Test
    public void test10InvertirElComportamientoDeUnBloqueDeComportamientoInvertidoEjecutaUnComportamientoNormal(){

        BloqueInvertirComportamiento inverso = new BloqueInvertirComportamiento();
        BloqueInvertirComportamiento inversoDelInverso = new BloqueInvertirComportamiento();

        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        inverso.aniadirBloqueEnPosicion(new BloqueSubirLapiz(), 3);
        inverso.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        inversoDelInverso.aniadirBloqueEnPosicion(inverso, 0);

        inversoDelInverso.ejecutarComportamientoSobrePizarraEn(this.zonaDeDibujo, this.dibujante);

        Celda celdaActualEstimada = new Celda(5, 5);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));

    }


}
