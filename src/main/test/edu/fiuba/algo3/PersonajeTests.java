package edu.fiuba.algo3;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTests {

    private Personaje timmy;
    private Celda celdaInicial;

    @BeforeEach
    public void setUp(){

        Pizarra.getInstance().blanquearTodo();
        this.celdaInicial = Pizarra.getInstance().obtenerCeldaCentral();
        this.timmy = new Personaje(this.celdaInicial);

    }

    @Test
    public void test01TimmyComienzaConElLapizLevantadoYNoDibujaAlMoverse(){



        this.timmy.moversePorLaPizarraHacia(new Izquierda());

        assertFalse(this.celdaInicial.seEncuentraDibujada());

    }

    @Test
    public void test02TimmyBajaElLapizYDibujaAlMoverse(){

        this.timmy.bajarLapiz();
        this.timmy.moversePorLaPizarraHacia(new Izquierda());

        assertTrue(this.celdaInicial.seEncuentraDibujada());

    }

    @Test
    public void test03TimmyBajaYSubeElLapizYNoDibujaAlMoverse(){

        this.timmy.bajarLapiz();
        this.timmy.subirLapiz();
        this.timmy.moversePorLaPizarraHacia(new Izquierda());

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
        //4, 4
        registroDePasoEstimado.add(new Celda(5, 4));
        registroDePasoEstimado.add(new Celda(5, 5));
        registroDePasoEstimado.add(new Celda(5, 6));
        registroDePasoEstimado.add(new Celda(4, 6));
        registroDePasoEstimado.add(new Celda(4, 5));

        for(int i = 0; i < listaDeMovimientos.size(); i++){

            this.timmy.moversePorLaPizarraHacia(listaDeMovimientos.get(i));
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

        registroDePasoEstimado.add(new Celda(4, 3));
        registroDePasoEstimado.add(new Celda(5, 3));
        registroDePasoEstimado.add(new Celda(6, 3));
        registroDePasoEstimado.add(new Celda(6, 4));
        registroDePasoEstimado.add(new Celda(6, 5));
        registroDePasoEstimado.add(new Celda(5, 5));
        registroDePasoEstimado.get(0).dibujar();
        registroDePasoEstimado.get(1).dibujar();
        registroDePasoEstimado.get(2).dibujar();
        registroDePasoEstimado.get(3).dibujar();

        int i;

        this.timmy.bajarLapiz();

        for(i = 0; i < listaDeMovimientos.size() - 2; i++){

            this.timmy.moversePorLaPizarraHacia(listaDeMovimientos.get(i));
            assertTrue(this.timmy.seEncuentraEn(registroDePasoEstimado.get(i)));

        }

        this.timmy.subirLapiz();

        for(i = listaDeMovimientos.size() - 2; i < listaDeMovimientos.size(); i++){

            this.timmy.moversePorLaPizarraHacia(listaDeMovimientos.get(i));
            assertTrue(this.timmy.seEncuentraEn(registroDePasoEstimado.get(i)));

        }

    }



}
