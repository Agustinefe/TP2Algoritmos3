package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.DireccionDeMovimiento;
import javafx.scene.canvas.GraphicsContext;

public class OrdenMovimiento implements OrdenDeDibujoParaCanvas{

    private DireccionDeMovimiento direccion;

    public OrdenMovimiento(DireccionDeMovimiento nuevaDireccion){

        this.direccion = nuevaDireccion;

    }

    @Override
    public void ejecutarOrden(DibujadorEnCanvas dibujador, GraphicsContext graphicsContext){

        dibujador.moverseHacia(graphicsContext, this.direccion);

    }


}
