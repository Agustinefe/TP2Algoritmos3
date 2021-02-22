package edu.fiuba.algo3;/* Author: firmapaz ;created on 20/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecuenciaDeBloquesNuevosTests {

    private SecuenciaDeBloques unaSecuencia;
    private Personaje dibujante;

    @BeforeEach

    public void setUp(){

        Pizarra.getInstance().blanquearTodo();

        this.unaSecuencia = new SecuenciaDeBloques();
        this.dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        BloqueRepeticion iterativo = new BloqueRepeticion();

        iterativo.establecerNuevaCantidadDeIteraciones(2);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 1);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Izquierda()), 2);

        this.unaSecuencia.insertar(new BloqueMovimiento(new Izquierda()));
        this.unaSecuencia.insertar(new BloqueMovimiento(new Arriba()));
        this.unaSecuencia.insertar(new BloqueMovimiento(new Arriba()));
        this.unaSecuencia.insertar(iterativo);
        this.unaSecuencia.insertar(new BloqueMovimiento(new Abajo()));
        this.unaSecuencia.insertar(new BloqueMovimiento(new Derecha()));

        /*

        |Izquierda|
        |Arriba|
        |Arriba|
        |Iterativo (comienzo)|
            |Derecha|
            |Abajo|
            |Izquierda|
        |Iterativo (final)|
        |Abajo|
        |Derecha|

         */

    }

    @Test
    public void test00LaSecuenciaInicialSeSeteaBien(){

        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);
        Celda celdaEstimada = new Celda(4, 3);

        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));
        assertEquals(11, this.unaSecuencia.tamanio());

    }

    @Test
    public void test01InsertoUnaSecuenciaDelanteDeUnBloqueNormalAntesDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 3);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 4);

        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));
        assertEquals(12, this.unaSecuencia.tamanio());



    }

    @Test
    public void test02InsertoUnaSecuenciaDelanteDeUnBloqueNormalDespuesDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 8);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 4);

        assertEquals(12, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));



    }

    @Test
    public void test03InsertoUnaSecuenciaAlPrincipioDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 4);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 5);

        assertEquals(12, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test04InsertoUnaSecuenciaAlFinalDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 4);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 5);

        assertEquals(12, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test05InsertoUnBloqueRepeticionFueraDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();

        BloqueRepeticion iterador = new BloqueRepeticion();
        iterador.establecerNuevaCantidadDeIteraciones(2);
        iterador.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterador.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        nuevaSecuencia.insertar(iterador);

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 3);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(6, 5);

        assertEquals(15, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test06InsertoUnBloqueInvertirComportamientoDentroDelBloqueContenedor(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();

        BloqueInvertirComportamiento inversor = new BloqueInvertirComportamiento();
        inversor.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 0);
        nuevaSecuencia.insertar(inversor);

        this.unaSecuencia.insertarSecuenciaEn(nuevaSecuencia, 5);
        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 5);

        assertEquals(14, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test07SeparoLaSecuenciaAntesDelBloqueContenedor(){

        this.unaSecuencia.separarLaSecuenciaEn(2);

        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(3, 5);

        assertEquals(3, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test08SeparoLaSecuenciaDespuesDelBloqueContenedor(){

        this.unaSecuencia.separarLaSecuenciaEn(8);

        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(3, 4);

        assertEquals(9, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test09SeparoLaSecuenciaDentroDelBloqueContenedor(){

        this.unaSecuencia.separarLaSecuenciaEn(5);

        this.unaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(6, 5);

        assertEquals(9, this.unaSecuencia.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test10IdemTest07peroPrueboLaSecuenciaObtenida(){

        SecuenciaDeBloques secuenciaRestante = this.unaSecuencia.separarLaSecuenciaEn(2);

        secuenciaRestante.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(5, 2);

        assertEquals(9, secuenciaRestante.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test11IdemTest08peroPrueboLaSecuenciaObtenida(){

        SecuenciaDeBloques secuenciaRestante = this.unaSecuencia.separarLaSecuenciaEn(8);

        secuenciaRestante.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(5, 3);

        assertEquals(3, secuenciaRestante.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test12IdemTest09peroPrueboLaSecuenciaObtenida(){

        SecuenciaDeBloques secuenciaRestante = this.unaSecuencia.separarLaSecuenciaEn(5);

        secuenciaRestante.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(3, 3);

        assertEquals(3, secuenciaRestante.tamanio());
        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));

    }

    @Test
    public void test13CreoUnaSecuenciaDeCero(){

        SectorBloque miSectorBloque = new SectorBloque();

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();

        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(1), 0);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(2), 1);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(2), 2);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(6), 3);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(0), 4);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(3), 5);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(1), 6);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(3), 8);
        nuevaSecuencia.insertarSecuenciaEn(miSectorBloque.nuevoBloque(0), 9);

        nuevaSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaEstimada = new Celda(4, 3);

        assertTrue(this.dibujante.seEncuentraEn(celdaEstimada));
        assertEquals(11, this.unaSecuencia.tamanio());

    }
}


