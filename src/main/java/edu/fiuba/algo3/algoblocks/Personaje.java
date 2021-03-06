package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.excepciones.FueraDePizarraException;

import java.util.ArrayList;

public class Personaje {

    private Lapiz suLapiz;
    private Celda celdaActual;
    private ArrayList<String> registroDePaso;

    public Personaje(Celda celdaDeInicio){

        this.suLapiz = new Lapiz();
        this.celdaActual = celdaDeInicio;
        this.registroDePaso = new ArrayList<>();

    }

    public void subirLapiz(){

        this.suLapiz.subirLapiz();
        this.actualizarRegistroDePaso("subeLapiz");

    }

    public void bajarLapiz(){

        this.suLapiz.bajarLapiz();
        this.actualizarRegistroDePaso("bajaLapiz");

    }

    public void moversePorLaPizarraHacia(DireccionDeMovimiento estaDireccion){

        try {

            Celda celdaContigua = celdaActual.obtenerCeldaQueEstaALa(estaDireccion);

            suLapiz.dibujar(this.celdaActual, celdaContigua);

            this.celdaActual = celdaContigua;

            this.actualizarRegistroDePaso(estaDireccion.direccion());



        } catch(FueraDePizarraException ignored){

            /*No avanza, se queda donde esta parado*/

        }

    }

    public boolean seEncuentraEn(Celda estaCelda){

        return this.celdaActual.esIgualA(estaCelda);

    }

    public void regresarAlCentro(){

        this.celdaActual = Pizarra.getInstance().obtenerCeldaCentral();
        this.subirLapiz();
        this.registroDePaso.clear();

    }

    private void actualizarRegistroDePaso(String nuevoRegistro){

       this.registroDePaso.add(nuevoRegistro);

    }

    public ArrayList<String> getRegistroDePaso(){

       return this.registroDePaso;

    }


}


