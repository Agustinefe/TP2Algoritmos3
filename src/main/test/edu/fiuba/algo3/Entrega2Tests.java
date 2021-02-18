package edu.fiuba.algo3;/* Author: firmapaz ;created on 10/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Tests {

    private Personaje jimmy;
    private BloqueRepeticion bloqueIterativo;
    private BloqueMovimiento arriba;
    private BloqueMovimiento abajo;
    private BloqueMovimiento derecha;
    private BloqueMovimiento izquierda;

    @BeforeEach
    public void setUp(){

        Pizarra.getInstance().blanquearTodo();
        this.bloqueIterativo = new BloqueRepeticion();
        this.jimmy = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        this.abajo = new BloqueMovimiento(new Abajo());
        this.arriba = new BloqueMovimiento(new Arriba());
        this.izquierda = new BloqueMovimiento(new Izquierda());
        this.derecha = new BloqueMovimiento(new Derecha());

    }

    @Test
    public void test01ejecutoUnBloqueDeRepeticion(){

        bloqueIterativo.aniadirBloqueEnPosicion(this.izquierda, 0);
        bloqueIterativo.aniadirBloqueEnPosicion(this.arriba, 1);
        bloqueIterativo.aniadirBloqueEnPosicion(this.arriba, 2);
        bloqueIterativo.aniadirBloqueEnPosicion(this.derecha, 3);
        bloqueIterativo.aniadirBloqueEnPosicion(this.abajo, 4);

        bloqueIterativo.establecerNuevaCantidadDeIteraciones(3);

        bloqueIterativo.ejecutarComportamientoSobrePizarraEn(jimmy);

        assertTrue(this.jimmy.seEncuentraEn(new Celda(4, 7)));

    }

    @Test
    public void test02EjecutoUnAlgoritmoEnElSectorDeDibujo(){

        Celda unaCelda;
        SecuenciaDeBloques unaSecuencia;
        ArrayList<SecuenciaDeBloques> listaDeSecuencias = new ArrayList<SecuenciaDeBloques>();
        ArrayList<Bloque> listaDeBloques = new ArrayList<Bloque>();
        ArrayList<Celda> pasoEstimadoDePersonaje = new ArrayList<Celda>();

        BloqueRepeticion bloqueIterativo = new BloqueRepeticion();
        bloqueIterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Izquierda()), 0);
        bloqueIterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 1);
        bloqueIterativo.establecerNuevaCantidadDeIteraciones(3);


        listaDeBloques.add(new BloqueMovimiento(new Derecha()));
        listaDeBloques.add(new BloqueMovimiento(new Derecha()));
        listaDeBloques.add(new BloqueMovimiento(new Arriba()));
        listaDeBloques.add(new BloqueBajarLapiz());
        listaDeBloques.add(new BloqueMovimiento(new Derecha()));
        listaDeBloques.add(new BloqueMovimiento(new Arriba()));
        listaDeBloques.add(bloqueIterativo);
        listaDeBloques.add(new BloqueMovimiento(new Derecha()));
        listaDeBloques.add(new BloqueMovimiento(new Abajo()));

        for(int i = 0; i < listaDeBloques.size(); i++){

            unaSecuencia = new SecuenciaDeBloques();
            unaSecuencia.insertar(listaDeBloques.get(i));
            listaDeSecuencias.add(unaSecuencia);

        }

        pasoEstimadoDePersonaje.add(new Celda(5, 4));
        pasoEstimadoDePersonaje.add(new Celda(6, 4));
        pasoEstimadoDePersonaje.add(new Celda(6, 5));
        unaCelda = new Celda(7, 5);
        unaCelda.dibujar();
        pasoEstimadoDePersonaje.add(unaCelda);
        unaCelda = new Celda(7, 6);
        unaCelda.dibujar();
        pasoEstimadoDePersonaje.add(unaCelda);
        unaCelda = new Celda(4, 3);
        unaCelda.dibujar();
        pasoEstimadoDePersonaje.add(unaCelda);
        unaCelda = new Celda(5, 3);
        unaCelda.dibujar();
        pasoEstimadoDePersonaje.add(unaCelda);
        unaCelda = new Celda(5, 2);
        unaCelda.dibujar();
        pasoEstimadoDePersonaje.add(unaCelda);

        int cont;

        for(cont = 0; cont < 3; cont++){

            listaDeSecuencias.get(cont).ejecutarComportamientoSobrePizarraEn(this.jimmy);
            assertTrue(this.jimmy.seEncuentraEn(pasoEstimadoDePersonaje.get(cont)));

        }

    }

}
