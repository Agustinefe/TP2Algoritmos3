package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class SecuenciaDeObjetos<T> {

    private ArrayList<T> laSecuencia;

    public SecuenciaDeObjetos(){

        this.laSecuencia = new ArrayList<T>();

    }

    public SecuenciaDeObjetos(ArrayList<T> contenidoInicialDeLaSecuencia){

        this.laSecuencia = contenidoInicialDeLaSecuencia;

    }

    public void insertar(T nuevoObjeto){

        this.laSecuencia.add(nuevoObjeto);

    }

    public void insertar(T nuevoObjeto, int posicion){

        this.laSecuencia.add(posicion, nuevoObjeto);

    }

    public void juntar(SecuenciaDeObjetos nuevaSecuencia, int posicion){

        nuevaSecuencia.insertarseEn(this.laSecuencia, posicion);

    }

    public void juntar(SecuenciaDeObjetos nuevaSecuencia){

        this.juntar(nuevaSecuencia, this.laSecuencia.size());

    }

    private void insertarseEn(ArrayList<T> secuenciaBase, int posicion){

        secuenciaBase.addAll(posicion, this.laSecuencia);

    }

    public SecuenciaDeObjetos separar(int puntoDeCorte){

        ArrayList<T> secuenciaDeLaDerecha = new ArrayList<T>();

        while(puntoDeCorte < this.laSecuencia.size()) { secuenciaDeLaDerecha.add(this.laSecuencia.remove(puntoDeCorte)); }

        return (new SecuenciaDeObjetos(secuenciaDeLaDerecha));

    }

    public boolean estaVacio(){

        return this.laSecuencia.isEmpty();

    }

    public void vaciar(){

        this.laSecuencia.clear();

    }

    public ArrayList<T> obtenerSecuencia(){

        return this.laSecuencia;

    }




}
