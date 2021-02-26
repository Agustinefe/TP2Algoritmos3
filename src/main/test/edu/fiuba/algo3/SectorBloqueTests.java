package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SectorBloqueTests {

    @Test
    public void test01SectorBloqueSeInicializaConLaCantidadDeBloquesCorrecta(){
        SectorBloque miSectorBloque = new SectorBloque();
        assertTrue(miSectorBloque.cantidadDeBloques() == 9);
    }

    @Test
    public void test02AlAgregarUnAlgoritmoPersonalizadoSeGuardaEnSectorBloque(){
        SectorBloque miSectorBloque = new SectorBloque();
        ArrayList<Bloque> miLista = new ArrayList<>();

        Derecha derecha = new Derecha();
        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();
        Abajo abajo = new Abajo();

        miLista.add(new BloqueMovimiento(derecha));
        miLista.add(new BloqueMovimiento(derecha));
        miLista.add(new BloqueBajarLapiz());
        miLista.add(new BloqueMovimiento(arriba));
        miLista.add(new BloqueMovimiento(izquierda));

        SecuenciaDeBloques miBloque = new SecuenciaDeBloques(miLista);
        miSectorBloque.crearAlgoritmoPersonalizado(miBloque, "personalizado");
        assertTrue(miSectorBloque.cantidadDeBloques() == 10);
    }

    @Test
    public void test03CrearAlgoritmoPersonalizadoYLuegoObtenerloYEjecutarlo(){
        SectorBloque miSectorBloque = new SectorBloque();
        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        ArrayList<Bloque> misBloques = new ArrayList<>();

        Derecha derecha = new Derecha();
        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();

        misBloques.add(new BloqueMovimiento(derecha));
        misBloques.add(new BloqueMovimiento(derecha));
        misBloques.add(new BloqueSubirLapiz());
        misBloques.add(new BloqueMovimiento(arriba));
        misBloques.add(new BloqueMovimiento(derecha));
        misBloques.add(new BloqueMovimiento(arriba));
        misBloques.add(new BloqueMovimiento(izquierda));

        SecuenciaDeBloques miBloque = new SecuenciaDeBloques(misBloques);
        miSectorBloque.crearAlgoritmoPersonalizado(miBloque, "personalizado");
        SecuenciaDeBloques nuevoBloque = miSectorBloque.nuevoBloque("personalizado");

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(nuevoBloque,0, 0);
        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalSecuencia = new Celda(6, 6);
        assertTrue(dibujante.seEncuentraEn(celdaFinalSecuencia));

    }

}