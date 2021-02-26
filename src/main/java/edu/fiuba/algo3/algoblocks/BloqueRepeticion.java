package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 13/1/21*/

public class BloqueRepeticion implements BloqueContenedor{

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
    public void juntar(SecuenciaDeBloques nuevaSecuencia, int posicion){

       this.secuenciaAIterar.juntar(nuevaSecuencia, posicion);

    }

    @Override
    public SecuenciaDeBloques separar(int posicion){

        return this.secuenciaAIterar.separar(posicion);

    }

    @Override
    public Bloque duplicar(){

        BloqueRepeticion bloqueIterador = new BloqueRepeticion(this.cantidadDeIteraciones);

        bloqueIterador.juntar( this.secuenciaAIterar.duplicar(), 0);

        return bloqueIterador;
    }

    public void aniadirBloqueEnPosicion(Bloque nuevoBloque, int posicion){

       this.secuenciaAIterar.insertar(nuevoBloque, posicion);

    }


}
