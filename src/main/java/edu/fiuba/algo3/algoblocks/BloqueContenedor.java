package edu.fiuba.algo3.algoblocks;

public interface BloqueContenedor extends Bloque{

    void juntar(SecuenciaDeBloques nuevaSecuencia, int posicion);

    SecuenciaDeBloques separar(int posicion);

}
