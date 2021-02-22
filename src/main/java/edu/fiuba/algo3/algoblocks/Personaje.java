package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

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

        Celda celdaContigua = celdaActual.obtenerCeldaQueEstaALa(estaDireccion);

        suLapiz.dibujar(this.celdaActual, celdaContigua);

        this.celdaActual = celdaContigua;

        //this.celdaActual.imprimirCoordenadas();

    }

    public boolean seEncuentraEn(Celda estaCelda){

        return this.celdaActual.esIgualA(estaCelda);

    }

    /*Mensajes que rompen principios de POO pero
    son solo para pruebitas
     */

   public void imprimirCoordenadas(){

        this.celdaActual.imprimirCoordenadas();

    }




}


