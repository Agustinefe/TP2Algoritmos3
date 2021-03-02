package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.algoblocks.Celda;
import edu.fiuba.algo3.algoblocks.Lapiz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LapizTests {

    @Test
    public void test01ElLapizSeInicializaArriba(){

        Lapiz miLapiz = new Lapiz();

        assertFalse(miLapiz.dibujar(new Celda(1,1), new Celda(1,2)));

    }

    @Test
    public void test02BajoElLapizYPuedeDibujar(){

        Lapiz miLapiz = new Lapiz();
        miLapiz.bajarLapiz();

        assertTrue(miLapiz.dibujar(new Celda(1,1), new Celda(1,2)));

    }

    @Test
    public void test03SuboElLapizYNoPasaNadaPorDefecto(){

        Lapiz miLapiz = new Lapiz();
        miLapiz.subirLapiz();

        assertFalse(miLapiz.dibujar(new Celda(1,1), new Celda(1,2)));

    }

    @Test
    public void test04BajoYSuboElLapiz(){

        Lapiz miLapiz = new Lapiz();
        miLapiz.bajarLapiz();

        assertTrue(miLapiz.dibujar(new Celda(1,1), new Celda(1,2)));

        miLapiz.subirLapiz();

        assertFalse(miLapiz.dibujar(new Celda(1,1), new Celda(1,2)));

    }

}
