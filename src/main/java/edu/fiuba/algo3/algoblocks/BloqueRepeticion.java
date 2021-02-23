package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 13/1/21*/

public class BloqueRepeticion implements Bloque{

   private int cantidadDeIteraciones;
   private SecuenciaDeBloques secuenciaAIterar;

   public BloqueRepeticion(int cantidadDeIteraciones){

       this.cantidadDeIteraciones = cantidadDeIteraciones;
       this.secuenciaAIterar = new SecuenciaDeBloques();

   }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje) {

        for (int i = 0; i < (this.cantidadDeIteraciones); i++){

            secuenciaAIterar.ejecutarComportamientoSobrePizarraEn(estePersonaje);

        }

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje) {

        for (int i = 0; i < (this.cantidadDeIteraciones); i++){

            secuenciaAIterar.ejecutarComportamientoInversoSobrePizarraEn(estePersonaje);

        }

    }

    @Override
    public int tamanio(){

        return (this.secuenciaAIterar.tamanio() + 1);

    }

    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion){

       this.secuenciaAIterar.insertarSecuenciaEn(nuevaSecuencia, posicion);

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicion){

        return this.secuenciaAIterar.separarLaSecuenciaEn(posicion);

    }

    @Override
    public Bloque duplicar(){

        BloqueRepeticion bloqueIterador = new BloqueRepeticion(this.cantidadDeIteraciones);

        bloqueIterador.insertarSecuenciaEn( this.secuenciaAIterar.duplicar(), 0);

        return bloqueIterador;
    }

    public void aniadirBloqueEnPosicion(Bloque nuevoBloque, int posicion){

       this.secuenciaAIterar.insertar(nuevoBloque, posicion);

    }

    public void aniadirBloqueEnPosicion(SecuenciaDeBloques nuevoBloque, int posicion){

        this.secuenciaAIterar.juntar(nuevoBloque, posicion);

    }

    public SecuenciaDeBloques removerBloquesEnPosicion(int posicion){

       return this.secuenciaAIterar.separar(posicion);

    }


}
