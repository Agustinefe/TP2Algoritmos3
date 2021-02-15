package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class SecuenciaDeBloques {

    private ArrayList<Bloque> laSecuencia;

    public SecuenciaDeBloques(){

        this.laSecuencia = new ArrayList<Bloque>();

    }

    public SecuenciaDeBloques(ArrayList<Bloque> contenidoInicialDeLaSecuencia){

        this.laSecuencia = contenidoInicialDeLaSecuencia;

    }

    public void insertar(Bloque nuevoObjeto){

        this.laSecuencia.add(nuevoObjeto);

    }

    public void insertar(Bloque nuevoObjeto, int posicion){

        this.laSecuencia.add(posicion, nuevoObjeto);

    }

    public void juntar(SecuenciaDeBloques nuevaSecuencia, int posicion){

        nuevaSecuencia.insertarseEn(this.laSecuencia, posicion);

    }

    public void juntar(SecuenciaDeBloques nuevaSecuencia){

        this.juntar(nuevaSecuencia, this.laSecuencia.size());

    }

    private void insertarseEn(ArrayList<Bloque> secuenciaBase, int posicion){

        secuenciaBase.addAll(posicion, this.laSecuencia);

    }

    public SecuenciaDeBloques separar(int puntoDeCorte){

        ArrayList<Bloque> secuenciaDeLaDerecha = new ArrayList<Bloque>();

        while(puntoDeCorte < this.laSecuencia.size()) { secuenciaDeLaDerecha.add(this.laSecuencia.remove(puntoDeCorte)); }

        return (new SecuenciaDeBloques(secuenciaDeLaDerecha));

    }

    public boolean estaVacio(){

        return this.laSecuencia.isEmpty();

    }

    public void vaciar(){

        this.laSecuencia.clear();

    }

    public void ejecutar(Pizarra zonaDeDibujo, Personaje dibujante){

        this.laSecuencia.stream().forEach(bloque -> {bloque.ejecutarComportamientoSobrePizarraEn(zonaDeDibujo, dibujante);});

    }

    public void ejecutarComportamientoInverso(Pizarra zonaDeDibujo, Personaje dibujante){

        this.laSecuencia.stream().forEach(bloque -> {bloque.ejecutarComportamientoInversoSobrePizarraEn(zonaDeDibujo, dibujante);});

    }




}
