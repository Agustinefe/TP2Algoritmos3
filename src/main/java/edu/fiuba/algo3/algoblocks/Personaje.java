package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.excepciones.FueraDePizarraException;

public class Personaje {

    private Lapiz suLapiz;
    private Celda celdaActual;

    public Personaje(Celda celdaDeInicio){

        this.suLapiz = new Lapiz();
        this.celdaActual = celdaDeInicio;

    }

    public void subirLapiz(){

        this.suLapiz.subirLapiz();

    }

    public void bajarLapiz(){

        this.suLapiz.bajarLapiz();

    }

    public void moversePorLaPizarraHacia(DireccionDeMovimiento estaDireccion){

        try {

            Celda celdaContigua = celdaActual.obtenerCeldaQueEstaALa(estaDireccion);

            suLapiz.dibujar(this.celdaActual, celdaContigua);

            this.celdaActual = celdaContigua;

        } catch(FueraDePizarraException error){

            /*No avanza, se queda donde esta parado*/

        }

        //this.celdaActual.imprimirCoordenadas();

    }

    public boolean seEncuentraEn(Celda estaCelda){

        return this.celdaActual.esIgualA(estaCelda);

    }

    public void regresarAlCentro(){

        this.celdaActual = Pizarra.getInstance().obtenerCeldaCentral();
        this.subirLapiz();

    }

    /*Mensajes que rompen principios de POO pero
    son solo para pruebitas
     */

   public void imprimirCoordenadas(){

        this.celdaActual.imprimirCoordenadas();

    }




}


