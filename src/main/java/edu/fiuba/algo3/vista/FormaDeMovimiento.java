package edu.fiuba.algo3.vista;

import javafx.scene.canvas.GraphicsContext;

public interface FormaDeMovimiento {

    void moverHacia(GraphicsContext graphicsContext, int x, int y);

    FormaDeMovimiento comenzarADibujar();

    FormaDeMovimiento pararDeDibujar();

}
