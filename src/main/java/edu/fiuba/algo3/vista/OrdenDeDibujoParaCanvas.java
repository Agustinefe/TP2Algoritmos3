package edu.fiuba.algo3.vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public interface OrdenDeDibujoParaCanvas {

    void ejecutarOrden(DibujadorEnCanvas dibujador, GraphicsContext graphicsContext, ImageView imagenDibujante);

}
