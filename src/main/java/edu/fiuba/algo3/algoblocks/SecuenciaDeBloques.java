package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class SecuenciaDeBloques implements Bloque{

    private ArrayList<Bloque> laSecuencia;


    public SecuenciaDeBloques(){

        this.laSecuencia = new ArrayList<>();

    }

    public SecuenciaDeBloques(ArrayList<Bloque> contenidoInicialDeLaSecuencia){

        this.laSecuencia = contenidoInicialDeLaSecuencia;

    }

    public void insertar(Bloque nuevoObjeto){

        this.laSecuencia.add(nuevoObjeto);
        //this.tamanio += nuevoObjeto.tamanio();

    }

    public void insertar(Bloque nuevoObjeto, int posicion){

        this.laSecuencia.add(posicion, nuevoObjeto);
        //this.tamanio += nuevoObjeto.tamanio();

    }

    public void juntar(SecuenciaDeBloques nuevaSecuencia, int posicion){

        nuevaSecuencia.insertarseEn(this.laSecuencia, posicion);
        //this.tamanio += nuevaSecuencia.tamanio();

    }

    public void juntar(SecuenciaDeBloques nuevaSecuencia){

        this.juntar(nuevaSecuencia, this.laSecuencia.size());

    }

    private void insertarseEn(ArrayList<Bloque> secuenciaBase, int posicion){


        secuenciaBase.addAll(posicion, this.laSecuencia);

    }

    public SecuenciaDeBloques separar(int puntoDeCorte){

        ArrayList<Bloque> bloquesDeLaDerecha = new ArrayList<>();

        while(puntoDeCorte < this.laSecuencia.size()) { bloquesDeLaDerecha.add(this.laSecuencia.remove(puntoDeCorte)); }

        return new SecuenciaDeBloques(bloquesDeLaDerecha);

    }

    public boolean estaVacio(){

        return this.laSecuencia.isEmpty();

    }

    public void vaciar(){

        this.laSecuencia.clear();

    }

    public void ejecutarComportamientoSobrePizarraEn(Personaje dibujante){

        this.laSecuencia.stream().forEach(bloque -> {bloque.ejecutarComportamientoSobrePizarraEn(dibujante);});

    }

    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje dibujante){

        this.laSecuencia.stream().forEach(bloque -> {bloque.ejecutarComportamientoInversoSobrePizarraEn(dibujante);});

    }


    @Override
    public int tamanio(){

        int tamanio = 0;
        for(int i = 0; i < this.laSecuencia.size(); i++){

            tamanio += this.laSecuencia.get(i).tamanio();

        }

        return tamanio + 1;

    }

    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicionBuscada){

        if(posicionBuscada > (this.tamanio() + 1) ){
            //rompe
        }

        Bloque bloqueActual;

        int contador = 0;
        int posicionEnRecorrido = 0;

        while((posicionEnRecorrido < posicionBuscada)){

            bloqueActual = this.laSecuencia.get(contador);
            posicionEnRecorrido += bloqueActual.tamanio();
            contador++;

        }

        if(posicionEnRecorrido != posicionBuscada){

            bloqueActual = this.laSecuencia.get(contador - 1);
            bloqueActual.insertarSecuenciaEn(nuevaSecuencia, posicionBuscada - (posicionEnRecorrido - bloqueActual.tamanio()) - 1);

        } else {

            this.juntar(nuevaSecuencia, contador);

        }

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicionBuscada){

        if(posicionBuscada > (this.tamanio() + 1) ){
            //rompe
        }

        SecuenciaDeBloques secuenciaRestante;
        Bloque bloqueActual = this.laSecuencia.get(0);

        int contador = 0;
        int posicionEnRecorrido = 0;

        while((posicionEnRecorrido < posicionBuscada)){

            bloqueActual = this.laSecuencia.get(contador);
            posicionEnRecorrido += bloqueActual.tamanio();
            contador++;

        }

        if(posicionEnRecorrido != posicionBuscada){

            secuenciaRestante = bloqueActual.separarLaSecuenciaEn(posicionBuscada - (posicionEnRecorrido - bloqueActual.tamanio()) - 1);

        } else {

            secuenciaRestante = this.separar(contador);

        }

        return secuenciaRestante;

    }

    public SecuenciaDeBloques duplicar(){

        ArrayList<Bloque> nuevaLista = new ArrayList<>();
        this.laSecuencia.stream().forEach(bloque -> {
            Bloque nuevoBloque = bloque.duplicar();
            nuevaLista.add(nuevoBloque);
        });
        return new SecuenciaDeBloques(nuevaLista);

    }
}
