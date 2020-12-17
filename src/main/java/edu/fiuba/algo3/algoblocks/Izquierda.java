package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class Izquierda implements DireccionDeMovimiento{

    public int[] aplicarDesplazamiento(int x, int y) {
        int[] nuevasCoordenadas = new int[2];
        nuevasCoordenadas[0] = this.desplazamientoEnEjeX(x);
        nuevasCoordenadas[1] = this.desplazamientoEnEjeY(y);
        return nuevasCoordenadas;
    }

    private int desplazamientoEnEjeX(int x){

        return (x - 1);

    }

    private int desplazamientoEnEjeY(int y){

        return y;

    }

}
