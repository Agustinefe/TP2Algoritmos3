package edu.fiuba.algo3;/* Author: firmapaz ;created on 19/1/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SectorDibujoTests {

    private SectorDibujo zonaDeDibujo;

    @BeforeEach

    public void setUp(){

        Pizarra.getInstance().blanquearTodo();
        this.zonaDeDibujo = new SectorDibujo(9, 9);

    }

    @Test
    public void test01ElDibujanteComienzaCentradoEnLaPizarra(){

        Celda celdaInicial = new Celda(4, 4);
        assertTrue(this.zonaDeDibujo.elPersonajeSeEncuentraEn(celdaInicial));

    }

    @Test
    public void test02ElDibujanteRealizaUnRecorridoYVerificoLaUltimaPosicion(){
        Celda celdaDibujada;

        ArrayList<Celda> pasoEstimadoDelDibujante= new ArrayList<Celda>();

        SecuenciaDeBloques pasoDelDibujante = new SecuenciaDeBloques();

        BloqueRepeticion bloqueIterativo = new BloqueRepeticion3();
        bloqueIterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Izquierda()), 0);
        bloqueIterativo.aniadirBloqueEnPosicion(new BloqueMovimiento(new Abajo()), 1);


        pasoDelDibujante.insertar(new BloqueMovimiento(new Derecha()));
        pasoDelDibujante.insertar(new BloqueMovimiento(new Derecha()));
        pasoDelDibujante.insertar(new BloqueMovimiento(new Arriba()));
        pasoDelDibujante.insertar(new BloqueBajarLapiz());
        pasoDelDibujante.insertar(new BloqueMovimiento(new Derecha()));
        pasoDelDibujante.insertar(new BloqueMovimiento(new Arriba()));
        pasoDelDibujante.insertar(bloqueIterativo);
        pasoDelDibujante.insertar(new BloqueMovimiento(new Derecha()));
        pasoDelDibujante.insertar(new BloqueMovimiento(new Abajo()));

        celdaDibujada = new Celda(5, 2);
        celdaDibujada.dibujar();
        pasoEstimadoDelDibujante.add(celdaDibujada);

        this.zonaDeDibujo.ejecutarSucesionDeBloques(pasoDelDibujante);

        assertTrue(this.zonaDeDibujo.elPersonajeSeEncuentraEn(celdaDibujada));

    }


}
