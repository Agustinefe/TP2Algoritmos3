package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.DireccionDeMovimiento;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.HashMap;

public class DibujadorEnCanvas {

    private final int intervalo;
    private int posicionXActual;
    private int posicionYActual;
    private FormaDeMovimiento formaDeMovimiento;

    public DibujadorEnCanvas(int x, int y, int intervalo){

        this.formaDeMovimiento = new NoDibujando();
        this.posicionXActual = x;
        this.posicionYActual = y;
        this.intervalo = intervalo;

    }

    private void actualizarPosicion(DireccionDeMovimiento direccion){

        int[] nuevaPosicion = direccion.aplicarDesplazamiento(this.posicionXActual / intervalo, this.posicionYActual / intervalo);
        this.posicionXActual = nuevaPosicion[0] * this.intervalo;
        this.posicionYActual = nuevaPosicion[1] * this.intervalo;

    }

    public void comenzarADibujar(){

        this.formaDeMovimiento = this.formaDeMovimiento.comenzarADibujar();

    }

    public void pararDeDibujar(){

        this.formaDeMovimiento = this.formaDeMovimiento.pararDeDibujar();

    }

    public void moverseHacia(GraphicsContext graphicsContext, DireccionDeMovimiento direccion){

        this.actualizarPosicion(direccion);
        this.formaDeMovimiento.moverHacia(graphicsContext, this.posicionXActual, this.posicionYActual);

    }
}
