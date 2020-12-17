package edu.fiuba.algo3;/* Author: firmapaz ;created on 16/12/20*/

import edu.fiuba.algo3.algoblocks.BloqueSubirLapiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasBloque {

    @Test
    public void test01DosBloqueSonLosMismos() {

        BloqueSubirLapiz primerBloque = new BloqueSubirLapiz();
        BloqueSubirLapiz segundoBloque = new BloqueSubirLapiz();

        assertEquals(primerBloque, segundoBloque);

    }

}
