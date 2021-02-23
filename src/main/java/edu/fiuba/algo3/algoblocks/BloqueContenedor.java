package edu.fiuba.algo3.algoblocks;

public interface BloqueContenedor extends Bloque{

    void insertarSecuenciaEn(SecuenciaDeBloques nuevaSecuencia, int posicion);

    SecuenciaDeBloques separarLaSecuenciaEn(int posicion);

}
