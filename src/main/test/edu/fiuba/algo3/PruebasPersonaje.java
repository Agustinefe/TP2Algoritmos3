package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.Celda;
import edu.fiuba.algo3.algoblocks.Izquierda;
import edu.fiuba.algo3.algoblocks.Personaje;
import edu.fiuba.algo3.algoblocks.Pizarra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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


}
