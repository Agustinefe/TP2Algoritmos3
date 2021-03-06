package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 16/12/20*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueTests {

    private Personaje dibujante;
    private Celda celdaDeInicio;

    @BeforeEach

    public void setUp(){

        Pizarra.getInstance().blanquearTodo();
        this.celdaDeInicio = Pizarra.getInstance().obtenerCeldaCentral();
        this.dibujante = new Personaje(this.celdaDeInicio);

    }


    @Test
    public void test01BloqueBajarLapiz(){

        (new BloqueBajarLapiz()).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaInicialEstimada = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral());
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));

        (new BloqueMovimiento(new Izquierda())).ejecutarComportamientoSobrePizarraEn(this.dibujante);
        celdaInicialEstimada.dibujar();
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));


    }

    @Test
    public void test02BloqueSubirLapiz(){

        (new BloqueBajarLapiz()).ejecutarComportamientoSobrePizarraEn(this.dibujante);
        (new BloqueSubirLapiz()).ejecutarComportamientoSobrePizarraEn(this.dibujante);
        (new BloqueMovimiento(new Derecha())).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaInicialEstimada = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral());
        assertTrue(this.celdaDeInicio.esIgualA(celdaInicialEstimada));
    }

    @Test
    public void test03BloqueMovimientoDerecha(){

        (new BloqueMovimiento(new Derecha())).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() + 1, Pizarra.getInstance().yCentral());
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test04BloqueMovimientoIzquierda(){

        (new BloqueMovimiento(new Izquierda())).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral());
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test05BloqueMovimientoArriba(){

        (new BloqueMovimiento(new Arriba())).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral() + 1);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test06BloqueMovimientoAbajo(){

        (new BloqueMovimiento(new Abajo())).ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral() - 1);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));
    }

    @Test
    public void test07BloqueRepeticion2(){

        BloqueRepeticion iterativo = new BloqueRepeticionPor2();

        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        iterativo.aniadirBloqueEnPosicion(new BloqueBajarLapiz(), 3);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        iterativo.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() + 2, Pizarra.getInstance().yCentral() + 2);
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

        inverso.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() - 1);
        celdaActualEstimada.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));

    }

    @Test
    public void test09InviertoElComportamientoDeUnBloqueRepeticion(){

        BloqueRepeticion iterativo = new BloqueRepeticionPor2();

        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Derecha()), 0);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 1);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Arriba()), 2);
        iterativo.aniadirBloqueEnPosicion(new BloqueBajarLapiz(), 3);
        iterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 4);

        BloqueInvertirComportamiento inverso = new BloqueInvertirComportamiento();
        inverso.aniadirBloqueEnPosicion(iterativo, 0);

        inverso.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() - 2, Pizarra.getInstance().yCentral() - 2);
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

        inversoDelInverso.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaActualEstimada = new Celda(Pizarra.getInstance().xCentral() + 1, Pizarra.getInstance().yCentral() + 1);
        assertTrue(this.dibujante.seEncuentraEn(celdaActualEstimada));

    }

    @Test
    public void test11BloquePersonalizado(){

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        nuevaSecuencia.insertar(new BloqueMovimiento(new Derecha()));
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));
        nuevaSecuencia.insertar(new BloqueMovimiento(new Derecha()));
        nuevaSecuencia.insertar(new BloqueMovimiento(new Arriba()));

        BloquePersonalizado bloque = new BloquePersonalizado(nuevaSecuencia);

        bloque.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() + 2, Pizarra.getInstance().yCentral() + 2);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalEstimada));

    }


}
