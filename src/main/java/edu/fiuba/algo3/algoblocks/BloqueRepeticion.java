package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 13/1/21*/

import java.util.ArrayList;

public class BloqueRepeticion implements Bloque{

   private int cantidadDeIteraciones;
   private SecuenciaDeBloques secuenciaAIterar;

   public BloqueRepeticion(){

       this.cantidadDeIteraciones = 0;
       this.secuenciaAIterar = new SecuenciaDeBloques();

   }

    @Override
    public String ejecutarComportamientoSobrePizarraEn(Pizarra pizarraDeDibujo, Personaje estePersonaje) {

        for (int i = 0; i < (this.cantidadDeIteraciones); i++){

            secuenciaAIterar.ejecutar(pizarraDeDibujo, estePersonaje);

        }
            return "";
    }

    public void establecerNuevaCantidadDeIteraciones(int nuevaCantidadDeIteraciones){

        this.cantidadDeIteraciones = nuevaCantidadDeIteraciones;

    }

    public void aniadirBloqueEnPosicion(Bloque nuevoBloque, int posicion){

       this.secuenciaAIterar.insertar(nuevoBloque, posicion);

    }

    public SecuenciaDeBloques removerBloquesEnPosicion(int posicion){

       return this.secuenciaAIterar.separar(posicion);

    }


}
