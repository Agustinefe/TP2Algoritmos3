import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasManejoDeListas {

    private ManejoDeListas miManejador;

    @BeforeEach

    public void setUp(){

        this.miManejador = new ManejoDeListas();

        miManejador.aniadirBloqueASecuenciaDeEjecucion(1);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(2);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(3);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(4);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(5);

    }

    @Test
    public void test01(){

        ArrayList<Integer> miLista = new ArrayList<Integer>();

        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);

        while(0 < miLista.size()){

            miLista.remove(0);

        }

        assertTrue(miLista.isEmpty());

    }

    @Test
    public void test02(){

        ArrayList<Integer> miLista1 = new ArrayList<Integer>();
        ArrayList<Integer> miLista2 = new ArrayList<Integer>();

        miLista1.add(1);
        miLista1.add(2);
        miLista1.add(5);
        miLista1.add(6);

        miLista2.add(3);
        miLista2.add(4);

        miLista1.addAll(2, miLista2);

        assertEquals(1, miLista1.get(0));
        assertEquals(2, miLista1.get(1));
        assertEquals(3, miLista1.get(2));
        assertEquals(4, miLista1.get(3));
        assertEquals(5, miLista1.get(4));
        assertEquals(6, miLista1.get(5));
    }

    @Test
    public void test03(){

        ArrayList<Integer> miLista1= miManejador.obtenerSecuenciaDeEjecucion();

        assertEquals(1, miLista1.get(0));
        assertEquals(2, miLista1.get(1));
        assertEquals(3, miLista1.get(2));
        assertEquals(4, miLista1.get(3));
        assertEquals(5, miLista1.get(4));

    }

    @Test
    public void test04(){

        try {

            miManejador.agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(3);

        } catch (Exception e){

            System.out.println("ERROR: Actualmente se poseen datos en el organizador");

        }

        miManejador.soltarSucesionDeBloquesEnLaSecuenciaDeEjecucionEnPosicion(1);

        ArrayList<Integer> miLista1 = miManejador.obtenerSecuenciaDeEjecucion();

        assertEquals(1, miLista1.get(0));
        assertEquals(4, miLista1.get(1));
        assertEquals(5, miLista1.get(2));
        assertEquals(2, miLista1.get(3));
        assertEquals(3, miLista1.get(4));


    }

    @Test
    public void test05(){

        miManejador.aniadirBloqueASecuenciaDeEjecucion(1);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(2);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(3);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(4);
        miManejador.aniadirBloqueASecuenciaDeEjecucion(5);

        try {

            miManejador.agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(3);

        } catch (Exception e){

            System.out.println("ERROR: Actualmente se poseen datos en el organizador");

        }
        miManejador.soltarSucesionDeBloquesLibresEnEspacioDeTrabajo();
        miManejador.soltarSucesionDeBloquesEnLaSecuenciaDeEjecucionEnPosicion(1);

        ArrayList<Integer> miLista1 = miManejador.obtenerSecuenciaDeEjecucion();

        assertEquals(1, miLista1.get(0));
        assertEquals(2, miLista1.get(1));
        assertEquals(3, miLista1.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> miLista1.get(3));

    }

    @Test
    public void test06(){

        miManejador.aniadirBloqueASecuenciaDeEjecucion(6, 3);

        ArrayList<Integer> miLista1 = miManejador.obtenerSecuenciaDeEjecucion();

        assertEquals(1, miLista1.get(0));
        assertEquals(2, miLista1.get(1));
        assertEquals(3, miLista1.get(2));
        assertEquals(6, miLista1.get(3));
        assertEquals(4, miLista1.get(4));
        assertEquals(5, miLista1.get(5));

    }

    @Test
    public void test07(){

        try {

            miManejador.agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(3);

        } catch (Exception e){

            System.out.println("ERROR: Actualmente se poseen datos en el organizador");

        }
        miManejador.arrojarBloquesALaBasura();

        ArrayList<Integer> miLista1 = miManejador.obtenerSecuenciaDeEjecucion();

        assertEquals(1, miLista1.get(0));
        assertEquals(2, miLista1.get(1));


    }

    @Test

    public void test08(){

        assertDoesNotThrow(() -> miManejador.agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(3));
        assertThrows(OrganizadorOcupadoException.class, () -> miManejador.agarrarSucesionDeBloquesDeLaSecuenciaDeEjecucionDesdePosicion(1));

    }

}
