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
        //this.tamanio += nuevoObjeto.tamanio();

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

    public int tamanio(){

        return this.laSecuencia.size();

    }

    /*
    @Override
    public int tamanio(){

        int tamanio = 0;
        for(int i = 0; i < this.laSecuencia.size(); i++){

            tamanio += this.laSecuencia.get(i).tamanio();

        }

        return tamanio + 1;

    }

    public void insertarSecuencia(SecuenciaDeBloques nuevaSecuencia){

        this.juntar(nuevaSecuencia);

    }

    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicionBuscada){

        if(posicionBuscada > (this.tamanio()) ){

            throw new FueraDeSecuenciaException();

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

            BloqueContenedor bloqueConSecuenciaBuscada = (BloqueContenedor) this.laSecuencia.get(contador - 1);
            bloqueConSecuenciaBuscada.insertarSecuenciaEn(nuevaSecuencia, posicionBuscada - (posicionEnRecorrido - bloqueConSecuenciaBuscada.tamanio()) - 1);

        } else {

            this.juntar(nuevaSecuencia, contador);

        }

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicionBuscada) throws FueraDeSecuenciaException {

        if(posicionBuscada > (this.tamanio()) ){

            throw new FueraDeSecuenciaException();

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

            BloqueContenedor bloqueConSecuenciaBuscada = (BloqueContenedor) this.laSecuencia.get(contador - 1);
            secuenciaRestante = bloqueConSecuenciaBuscada.separarLaSecuenciaEn(posicionBuscada - (posicionEnRecorrido - bloqueConSecuenciaBuscada.tamanio()) - 1);

        } else {

            secuenciaRestante = this.separar(contador);

        }

        return secuenciaRestante;

    }
*/
    public SecuenciaDeBloques duplicar(){

        ArrayList<Bloque> nuevaLista = new ArrayList<>();
        this.laSecuencia.stream().forEach(bloque -> {
            Bloque nuevoBloque = bloque.duplicar();
            nuevaLista.add(nuevoBloque);
        });
        return new SecuenciaDeBloques(nuevaLista);

    }
}
