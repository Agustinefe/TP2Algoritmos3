package edu.fiuba.algo3;/* Author: firmapaz ;created on 16/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordenadasTests {

    @Test
    public void test01generoUnasCoordenadasDeAbajoDeLaActual(){

        Coordenadas estasCoordenadas = new Coordenadas(4, 5);
        Coordenadas coordenadasIzquierda = estasCoordenadas.generarCoordenadasAdyacentes(new Izquierda());
        assertTrue(coordenadasIzquierda.sonLasMismasCoordenadas(new Coordenadas(3, 5)));

    }

    @Test
    public void test02prueboLaPosicionEnLaMatrizDeEstasCoordenadas(){

        Coordenadas estasCoordenadas = new Coordenadas(4, 5);
        assertEquals(estasCoordenadas.posicionEnLaMatriz(9), 49);

    }

    @Test
    public void test03CoordenadasNoSeEncuentranDentroDeLosLimites(){

        Coordenadas estasCoordenadas = new Coordenadas(6, 5);
        assertFalse(estasCoordenadas.seEncuentraDentroDeLoslimites(4, 4));

    }

}
