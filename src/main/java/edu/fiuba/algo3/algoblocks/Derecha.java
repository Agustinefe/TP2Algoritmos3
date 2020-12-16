package edu.fiuba.algo3.algoblocks;

public class Derecha implements DireccionDeMovimiento{

    public int[] aplicarDesplazamiento(int x, int y) {
        int[] nuevasCoordenadas = new int[2];
        nuevasCoordenadas[0] = this.desplazamientoEnEjeX(x);
        nuevasCoordenadas[1] = this.desplazamientoEnEjeY(y);
        return nuevasCoordenadas;
    }

    private int desplazamientoEnEjeX(int x){

        return (x + 1);

    }

    private int desplazamientoEnEjeY(int y){

        return y;

    }

}
