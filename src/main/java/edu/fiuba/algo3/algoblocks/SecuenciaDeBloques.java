package edu.fiuba.algo3.algoblocks;

import edu.fiuba.algo3.excepciones.FueraDeSecuenciaException;



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

        secuenciaBase.addAll(Math.min(posicion, secuenciaBase.size()), this.laSecuencia);

    }

    public SecuenciaDeBloques removerBloque(int posicion){

        SecuenciaDeBloques secuenciaRemovida = new SecuenciaDeBloques();
        secuenciaRemovida.insertar(this.laSecuencia.remove(posicion));
        return secuenciaRemovida;

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

    public SecuenciaDeBloques duplicar(){

        ArrayList<Bloque> nuevaLista = new ArrayList<>();
        this.laSecuencia.stream().forEach(bloque -> {
            Bloque nuevoBloque = bloque.duplicar();
            nuevaLista.add(nuevoBloque);
        });
        return new SecuenciaDeBloques(nuevaLista);

    }
}
