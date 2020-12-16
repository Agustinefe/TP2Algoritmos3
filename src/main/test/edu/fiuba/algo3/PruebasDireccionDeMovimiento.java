package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasDireccionDeMovimiento {

    private int[] coordenadas;

    @BeforeEach

    public void setUp(){

        this.coordenadas = new int[2];
        this.coordenadas[0] = 0;
        this.coordenadas[1] = 0;

    }

    @Test
    public void test01MeMuevoALaDerecha(){

        DireccionDeMovimiento direccion = new Derecha();
        int[] nuevasCoordenadas = direccion.aplicarDesplazamiento(coordenadas[0], coordenadas[1]);

        assertEquals(this.coordenadas[0] + 1, nuevasCoordenadas[0]);
        assertEquals(this.coordenadas[1], nuevasCoordenadas[1]);

    }

    @Test
    public void test02MeMuevoAbajo(){

        DireccionDeMovimiento direccion = new Abajo();
        int[] nuevasCoordenadas = direccion.aplicarDesplazamiento(coordenadas[0], coordenadas[1]);

        assertEquals(this.coordenadas[0], nuevasCoordenadas[0]);
        assertEquals(this.coordenadas[1] - 1, nuevasCoordenadas[1]);

    }

    @Test
    public void test03MeMuevoALaIzquierda(){

        DireccionDeMovimiento direccion = new Izquierda();
        int[] nuevasCoordenadas = direccion.aplicarDesplazamiento(coordenadas[0], coordenadas[1]);

        assertEquals(this.coordenadas[0] - 1, nuevasCoordenadas[0]);
        assertEquals(this.coordenadas[1], nuevasCoordenadas[1]);

    }

    @Test
    public void test02MeMuevoArriba(){

        DireccionDeMovimiento direccion = new Arriba();
        int[] nuevasCoordenadas = direccion.aplicarDesplazamiento(coordenadas[0], coordenadas[1]);

        assertEquals(this.coordenadas[0], nuevasCoordenadas[0]);
        assertEquals(this.coordenadas[1] + 1, nuevasCoordenadas[1]);

    }

}
