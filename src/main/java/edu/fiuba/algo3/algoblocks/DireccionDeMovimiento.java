package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public interface DireccionDeMovimiento {

    int[] aplicarDesplazamiento(int x, int y);

    DireccionDeMovimiento direccionOpuesta();

    DireccionDeMovimiento duplicar();

}