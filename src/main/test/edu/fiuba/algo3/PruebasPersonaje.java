package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasPersonaje {

    private Personaje timmy;
    private Pizarra pizarraDeTimmy;
    private Celda celdaInicial;

    @BeforeEach
    public void setUp(){

        this.pizarraDeTimmy = new Pizarra(5, 5);
        this.celdaInicial = pizarraDeTimmy.obtenerCeldaCentral();
        this.timmy = new Personaje(this.celdaInicial);

    }

    @Test
    public void test01TimmyComienzaConElLapizLevantadoYNoDibujaAlMoverse(){



        this.timmy.moversePorLaPizarraHacia(pizarraDeTimmy, new Izquierda());

        assertFalse(this.celdaInicial.seEncuentraDibujada());

    }

    @Test
    public void test02TimmyBajaElLapizYDibujaAlMoverse(){

        this.timmy.bajarLapiz();
        this.timmy.moversePorLaPizarraHacia(pizarraDeTimmy, new Izquierda());

        assertTrue(this.celdaInicial.seEncuentraDibujada());

    }

    @Test
    public void test03TimmyBajaYSubeElLapizYNoDibujaAlMoverse(){

        this.timmy.bajarLapiz();
        this.timmy.subirLapiz();
        this.timmy.moversePorLaPizarraHacia(pizarraDeTimmy, new Izquierda());

        assertFalse(this.celdaInicial.seEncuentraDibujada());

    }

    @Test
    public void test04TimmySeMueveDerechaArribaArribaIzquierdaAbajo(){

        ArrayList<Celda> registroDePasoEstimado = new ArrayList<Celda>();
        ArrayList<DireccionDeMovimiento> listaDeMovimientos= new ArrayList<DireccionDeMovimiento>();

        listaDeMovimientos.add(new Derecha());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Izquierda());
        listaDeMovimientos.add(new Abajo());

        registroDePasoEstimado.add(new Celda(3, 2));
        registroDePasoEstimado.add(new Celda(3, 3));
        registroDePasoEstimado.add(new Celda(3, 4));
        registroDePasoEstimado.add(new Celda(2, 4));
        registroDePasoEstimado.add(new Celda(2, 3));

        for(int i = 0; i < listaDeMovimientos.size(); i++){

            this.timmy.moversePorLaPizarraHacia(this.pizarraDeTimmy, listaDeMovimientos.get(i));
            assertTrue(this.timmy.seEncuentraEn(registroDePasoEstimado.get(i)));

        }

    }

    @Test
    public void test05BajaLapizAbajoDerechaDerechaArribaSuboLapizArribaIzquierda(){

        ArrayList<Celda> registroDePasoEstimado = new ArrayList<Celda>();
        ArrayList<DireccionDeMovimiento> listaDeMovimientos= new ArrayList<DireccionDeMovimiento>();

        listaDeMovimientos.add(new Abajo());
        listaDeMovimientos.add(new Derecha());
        listaDeMovimientos.add(new Derecha());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Arriba());
        listaDeMovimientos.add(new Izquierda());

        registroDePasoEstimado.add(new Celda(2, 1));
        registroDePasoEstimado.add(new Celda(3, 1));
        registroDePasoEstimado.add(new Celda(4, 1));
        registroDePasoEstimado.add(new Celda(4, 2));
        registroDePasoEstimado.add(new Celda(4, 3));
        registroDePasoEstimado.add(new Celda(3, 3));
        registroDePasoEstimado.get(0).dibujar();
        registroDePasoEstimado.get(1).dibujar();
        registroDePasoEstimado.get(2).dibujar();
        registroDePasoEstimado.get(3).dibujar();

        int i;

        this.timmy.bajarLapiz();

        for(i = 0; i < listaDeMovimientos.size() - 2; i++){

            this.timmy.moversePorLaPizarraHacia(this.pizarraDeTimmy, listaDeMovimientos.get(i));
            assertTrue(this.timmy.seEncuentraEn(registroDePasoEstimado.get(i)));

        }

        this.timmy.subirLapiz();

        for(i = listaDeMovimientos.size() - 2; i < listaDeMovimientos.size(); i++){

            this.timmy.moversePorLaPizarraHacia(this.pizarraDeTimmy, listaDeMovimientos.get(i));
            assertTrue(this.timmy.seEncuentraEn(registroDePasoEstimado.get(i)));

        }

    }



}
