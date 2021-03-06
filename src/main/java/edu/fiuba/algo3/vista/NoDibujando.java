package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NoDibujando implements FormaDeMovimiento{

    @Override
    public void moverHacia(GraphicsContext graphicsContext, int x, int y){

        graphicsContext.moveTo(x, y);

    }

    @Override
    public FormaDeMovimiento comenzarADibujar(){

        return new Dibujando();

    }

    @Override
    public FormaDeMovimiento pararDeDibujar(){

        return this;

    }

}
