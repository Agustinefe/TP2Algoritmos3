package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import javafx.scene.canvas.GraphicsContext;

public class Dibujando implements FormaDeMovimiento{

    @Override
    public void moverHacia(GraphicsContext graphicsContext, int x, int y){

        graphicsContext.lineTo(x, y);

    }

    @Override
    public FormaDeMovimiento comenzarADibujar(){

        return this;

    }

    @Override
    public FormaDeMovimiento pararDeDibujar(){

        return new NoDibujando();

    }

}
