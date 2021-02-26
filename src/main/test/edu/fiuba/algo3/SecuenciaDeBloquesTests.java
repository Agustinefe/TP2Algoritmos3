package edu.fiuba.algo3;/* Author: firmapaz ;created on 21/1/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecuenciaDeBloquesTests {

    private SecuenciaDeBloques miSecuencia;
    private SecuenciaDeBloques miSecuencia2;
    private Personaje dibujante;

    @BeforeEach

    public void setUp() {

        Pizarra.getInstance().blanquearTodo();
        this.dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        Derecha derecha = new Derecha();
        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();
        Abajo abajo = new Abajo();


        this.miSecuencia = new SecuenciaDeBloques();

        this.miSecuencia.insertar(new BloqueMovimiento(derecha));
        this.miSecuencia.insertar(new BloqueMovimiento(derecha));
        this.miSecuencia.insertar(new BloqueBajarLapiz());
        this.miSecuencia.insertar(new BloqueMovimiento(arriba));
        this.miSecuencia.insertar(new BloqueMovimiento(izquierda));

        this.miSecuencia2 = new SecuenciaDeBloques();

        this.miSecuencia2.insertar(new BloqueMovimiento(abajo));
        this.miSecuencia2.insertar(new BloqueBajarLapiz());
        this.miSecuencia2.insertar(new BloqueMovimiento(izquierda));
        this.miSecuencia2.insertar(new BloqueSubirLapiz());
        this.miSecuencia2.insertar(new BloqueMovimiento(abajo));

    }

    @Test
    public void test00elSetUpFueHechoCorrectamente() {

        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);
        Celda celdaFinalSecuencia1 = new Celda(5, 5);
        celdaFinalSecuencia1.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia1));

        this.miSecuencia2.ejecutarComportamientoSobrePizarraEn(this.dibujante);
        Celda celdaFinalSecuencia2 = new Celda(4, 3);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia2));

    }

    @Test
    public void test01insertoUnBloqueAlFinalDeLaSecuencia() {

        this.miSecuencia.insertar(new BloqueMovimiento(new Arriba()));
        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(5, 6);
        celdaFinalSecuencia.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));


    }

    @Test
    public void test02InsertoUnBloqueEnDeterminadaPosicion() {

        this.miSecuencia.insertar(new BloqueSubirLapiz(), 4);
        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(5, 5);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test03JuntoDosSecuenciasEnLasPuntas() {

        this.miSecuencia.juntar(this.miSecuencia2);
        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(4, 3);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test04SeparoUnaSecuencia() {

        SecuenciaDeBloques pedacito = this.miSecuencia.separar(2);
        pedacito.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(3, 5);
        celdaFinalSecuencia.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test05JuntoDosSecuenciasEnPosicionDeterminada() {

        SecuenciaDeBloques pedacito = this.miSecuencia2.separar(2);
        this.miSecuencia.juntar(pedacito, 3);
        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(4, 4);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));


    }

    @Test
    public void test06unaNuevaSecuenciaSeEncuentraVacia() {

        SecuenciaDeBloques nuevaSecuencia = new SecuenciaDeBloques();
        assertTrue(nuevaSecuencia.estaVacio());

    }

    @Test
    public void test07VacioUnaSecuencia() {

        this.miSecuencia.vaciar();

        assertTrue(this.miSecuencia.estaVacio());

    }

    @Test
    public void test08RemuevoElementosParticularesDeUnaSecuencia(){

        this.miSecuencia.removerBloque(2);
        this.miSecuencia.removerBloque(3);

        this.miSecuencia.ejecutarComportamientoSobrePizarraEn(this.dibujante);
        Celda celdaFinalEstimada = new Celda(6, 5);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalEstimada));

    }

}
