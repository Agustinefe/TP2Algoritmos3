package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 15/2/21*/

public class BloqueInvertirComportamiento implements Bloque{

    private SecuenciaDeBloques secuenciaAInvertir;

    public BloqueInvertirComportamiento(){

        this.secuenciaAInvertir = new SecuenciaDeBloques();

    }

    @Override
    public void ejecutarComportamientoSobrePizarraEn(Personaje estePersonaje) {

        secuenciaAInvertir.ejecutarComportamientoInversoSobrePizarraEn(estePersonaje);

    }

    @Override
    public void ejecutarComportamientoInversoSobrePizarraEn(Personaje estePersonaje) {

        secuenciaAInvertir.ejecutarComportamientoSobrePizarraEn(estePersonaje);

    }

    @Override
    public int tamanio(){

        return (this.secuenciaAInvertir.tamanio() + 1);

    }

    @Override
    public void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion){

        this.secuenciaAInvertir.insertarSecuenciaEn(nuevaSecuencia, posicion);

    }

    @Override
    public SecuenciaDeBloques separarLaSecuenciaEn(int posicion){

        return this.secuenciaAInvertir.separarLaSecuenciaEn(posicion);

    }

    @Override
    public Bloque duplicar(){

        BloqueInvertirComportamiento bloqueInversor = new BloqueInvertirComportamiento();

        bloqueInversor.insertarSecuenciaEn( this.secuenciaAInvertir.duplicar(), 0);

        return bloqueInversor;
    }


    public void aniadirBloqueEnPosicion(Bloque nuevoBloque, int posicion){

        this.secuenciaAInvertir.insertar(nuevoBloque, posicion);

    }

    public void aniadirBloqueEnPosicion(SecuenciaDeBloques nuevoBloque, int posicion){

        this.secuenciaAInvertir.juntar(nuevoBloque, posicion);

    }

    public SecuenciaDeBloques removerBloquesEnPosicion(int posicion){

        return this.secuenciaAInvertir.separar(posicion);

    }

}
