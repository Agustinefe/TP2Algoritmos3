package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 15/2/21*/

public class BloqueInvertirComportamiento implements Bloque{

    private SecuenciaDeBloques secuenciaAInvertir;

    public BloqueInvertirComportamiento(){

        this.secuenciaAInvertir = new SecuenciaDeBloques();

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje) {

        secuenciaAInvertir.ejecutarComportamientoInverso(estePersonaje);

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje) {

        secuenciaAInvertir.ejecutar(estePersonaje);

    }




    public void aniadirBloqueEnPosicion(Bloque nuevoBloque, int posicion){

        this.secuenciaAInvertir.insertar(nuevoBloque, posicion);

    }

    public SecuenciaDeBloques removerBloquesEnPosicion(int posicion){

        return this.secuenciaAInvertir.separar(posicion);

    }

}
