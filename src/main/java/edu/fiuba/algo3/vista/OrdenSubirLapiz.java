package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import javafx.scene.canvas.GraphicsContext;

public class OrdenSubirLapiz implements OrdenDeDibujoParaCanvas{

    @Override
    public void ejecutarOrden(DibujadorEnCanvas dibujador, GraphicsContext graphicsContext){

        dibujador.pararDeDibujar();

    }

}
