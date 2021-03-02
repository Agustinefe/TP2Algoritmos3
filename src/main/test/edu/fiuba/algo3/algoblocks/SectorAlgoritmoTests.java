package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 22/2/21*/

import edu.fiuba.algo3.algoblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

public class SectorAlgoritmoTests {

    @BeforeEach
    public void setUp(){

        Pizarra.getInstance().blanquearTodo();

    }

    @Test
    public void test01AgregoUnBloqueALaSecuenciaDeEjecucionYPuedoEjecutarlo(){
        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        Izquierda izquierda = new Izquierda();
        Abajo abajo = new Abajo();

        SecuenciaDeBloques miBloque = new SecuenciaDeBloques();

        miBloque.insertar(new BloqueMovimiento(abajo));
        miBloque.insertar(new BloqueBajarLapiz());
        miBloque.insertar(new BloqueMovimiento(izquierda));
        miBloque.insertar(new BloqueSubirLapiz());
        miBloque.insertar(new BloqueMovimiento(abajo));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(miBloque,0, 0);
        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalSecuencia = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() - 2);
        assertTrue(dibujante.seEncuentraEn(celdaFinalSecuencia));
    }

    @Test
    public void test02AgregoUnBloqueAlEspacioDeTrabajoYSoloSeEjecutaElBloqueDeEjecucion(){

        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();
        Abajo abajo = new Abajo();

        SecuenciaDeBloques miBloque1 = new SecuenciaDeBloques();

        miBloque1.insertar(new BloqueMovimiento(abajo));
        miBloque1.insertar(new BloqueBajarLapiz());
        miBloque1.insertar(new BloqueMovimiento(izquierda));
        miBloque1.insertar(new BloqueSubirLapiz());
        miBloque1.insertar(new BloqueMovimiento(abajo));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(miBloque1,0, 0);

        SecuenciaDeBloques miBloque2 = new SecuenciaDeBloques();

        miBloque2.insertar(new BloqueMovimiento(new Derecha()));
        miBloque2.insertar(new BloqueMovimiento(new Derecha()));
        miBloque2.insertar(new BloqueMovimiento(new Arriba()));
        miBloque2.insertar(new BloqueBajarLapiz());
        miBloque2.insertar(new BloqueMovimiento(new Derecha()));
        miBloque2.insertar(new BloqueMovimiento(new Arriba()));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(miBloque2, 1, 0);
        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalSecuencia = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() - 2);
        assertTrue(dibujante.seEncuentraEn(celdaFinalSecuencia));
    }

    @Test
    public void test03unirDosBloquesYEjecutarlos(){

        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        SecuenciaDeBloques enLaMano;

        Derecha derecha = new Derecha();
        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();
        Abajo abajo = new Abajo();

        SecuenciaDeBloques bloque1 = new SecuenciaDeBloques();

        bloque1.insertar(new BloqueMovimiento(derecha));
        bloque1.insertar(new BloqueBajarLapiz());
        bloque1.insertar(new BloqueMovimiento(arriba));
        bloque1.insertar(new BloqueMovimiento(derecha));
        bloque1.insertar(new BloqueMovimiento(izquierda));

        SecuenciaDeBloques bloque2 = new SecuenciaDeBloques();

        bloque2.insertar(new BloqueMovimiento(abajo));
        bloque2.insertar(new BloqueBajarLapiz());
        bloque2.insertar(new BloqueMovimiento(abajo));
        bloque2.insertar(new BloqueSubirLapiz());
        bloque2.insertar(new BloqueMovimiento(izquierda));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(bloque1, 1, 0);
        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(bloque2, 2, 0);
        enLaMano = miSectorAlgoritmo.separarSecuenciaEnEspacioDeTrabajo(2, 1);
        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(enLaMano, 1, 5);
        enLaMano = miSectorAlgoritmo.separarSecuenciaEnEspacioDeTrabajo(1, 0);
        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(enLaMano, 0, 0);
        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalSecuencia = new Celda(Pizarra.getInstance().xCentral(), Pizarra.getInstance().yCentral());
        assertTrue(dibujante.seEncuentraEn(celdaFinalSecuencia));
    }



    @Test
    public void test04SepararBloqueYEjecutarUnaParte(){

        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        Derecha derecha = new Derecha();
        Izquierda izquierda = new Izquierda();
        Arriba arriba = new Arriba();
        Abajo abajo = new Abajo();

        SecuenciaDeBloques bloque = new SecuenciaDeBloques();

        bloque.insertar(new BloqueMovimiento(derecha));
        bloque.insertar(new BloqueSubirLapiz());
        bloque.insertar(new BloqueMovimiento(arriba));
        bloque.insertar(new BloqueMovimiento(abajo));
        bloque.insertar(new BloqueBajarLapiz());
        bloque.insertar(new BloqueMovimiento(abajo));
        bloque.insertar(new BloqueMovimiento(derecha));
        bloque.insertar(new BloqueMovimiento(izquierda));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(bloque,0, 0);
        miSectorAlgoritmo.separarSecuenciaEnEspacioDeTrabajo(0, 5);
        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalSecuencia = new Celda(Pizarra.getInstance().xCentral() + 1, Pizarra.getInstance().yCentral());
        assertTrue(dibujante.seEncuentraEn(celdaFinalSecuencia));
    }

    @Test
    public void test05metoUnaSecuenciaEnUnBloqueContenedor(){


        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        SecuenciaDeBloques bloque = new SecuenciaDeBloques();

        bloque.insertar(new BloqueMovimiento(new Derecha()));
        bloque.insertar(new BloqueSubirLapiz());
        bloque.insertar(new BloqueMovimiento(new Arriba()));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(bloque, 0);

        miSectorAlgoritmo.meterSecuenciaEnContenedor(new BloqueInvertirComportamiento(), 0);

        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() - 1, Pizarra.getInstance().yCentral() - 1);
        celdaFinalEstimada.dibujar();

        assertTrue(dibujante.seEncuentraEn(celdaFinalEstimada));
    }

    @Test
    public void test06remuevoBloquesParticularesDeUnaSecuenciaEnElEspacioDeTrabajo(){

        SectorAlgoritmo miSectorAlgoritmo = new SectorAlgoritmo();
        Personaje dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

        SecuenciaDeBloques bloque = new SecuenciaDeBloques();

        bloque.insertar(new BloqueMovimiento(new Derecha()));
        bloque.insertar(new BloqueSubirLapiz());
        bloque.insertar(new BloqueMovimiento(new Arriba()));
        bloque.insertar(new BloqueMovimiento(new Abajo()));

        miSectorAlgoritmo.insertarSecuenciaEnEspacioDeTrabajo(bloque, 0);
        miSectorAlgoritmo.removerBloqueParticular(0, 2);

        miSectorAlgoritmo.ejecutarSecuenciaDeEjecucion(dibujante);

        Celda celdaFinalEstimada = new Celda(Pizarra.getInstance().xCentral() + 1, Pizarra.getInstance().yCentral() - 1);

        assertTrue(dibujante.seEncuentraEn(celdaFinalEstimada));



    }
}
