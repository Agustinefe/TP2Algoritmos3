package edu.fiuba.algo3;/* Author: firmapaz ;created on 21/1/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecuenciaDeBloquesTests {

    private SecuenciaDeBloques miSecuencia;
    private SecuenciaDeBloques miSecuencia2;
    //private Pizarra nuevaPizarra;
    private Personaje dibujante;

    @BeforeEach

    public void setUp() {

        //this.nuevaPizarra = new Pizarra(9, 9);
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

        this.miSecuencia.ejecutar(this.dibujante);
        Celda celdaFinalSecuencia1 = new Celda(5, 5);
        celdaFinalSecuencia1.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia1));

        this.miSecuencia2.ejecutar(this.dibujante);
        Celda celdaFinalSecuencia2 = new Celda(4, 3);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia2));

    }

    @Test
    public void test01insertoUnBloqueAlFinalDeLaSecuencia() {

        this.miSecuencia.insertar(new BloqueMovimiento(new Arriba()));
        this.miSecuencia.ejecutar(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(5, 6);
        celdaFinalSecuencia.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));


    }

    @Test
    public void test02InsertoUnBloqueEnDeterminadaPosicion() {

        this.miSecuencia.insertar(new BloqueSubirLapiz(), 4);
        this.miSecuencia.ejecutar(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(5, 5);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test03JuntoDosSecuenciasEnLasPuntas() {

        this.miSecuencia.juntar(this.miSecuencia2);
        this.miSecuencia.ejecutar(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(4, 3);
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test04SeparoUnaSecuencia() {

        SecuenciaDeBloques pedacito = this.miSecuencia.separar(2);
        pedacito.ejecutar(this.dibujante);

        Celda celdaFinalSecuencia = new Celda(3, 5);
        celdaFinalSecuencia.dibujar();
        assertTrue(this.dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

    @Test
    public void test05JuntoDosSecuenciasEnPosicionDeterminada() {

        SecuenciaDeBloques pedacito = this.miSecuencia2.separar(2);
        this.miSecuencia.juntar(pedacito, 3);
        this.miSecuencia.ejecutar(this.dibujante);

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

}