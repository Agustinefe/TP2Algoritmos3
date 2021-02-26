package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaPizarraDeDibujo {

    private Group pizarraDeDibujo;
    private Canvas lienzo;
    private Personaje personajeModelo;
    private GraphicsContext graphicsContext;
    private final int base = 400;
    private final int altura = 400;


    public VistaPizarraDeDibujo(Personaje dibujante){

        this.personajeModelo = dibujante;
        this.lienzo = new Canvas(this.base, this.altura);
        this.pizarraDeDibujo = new Group(this.lienzo);
        this.graphicsContext = this.lienzo.getGraphicsContext2D();
        pintarFondo();

    }

    public Group obtenerPizarraDeDibujo(){

        return this.pizarraDeDibujo;

    }

    private void dibujarCaminoDePersonaje(){

        ArrayList<String> bitacoraDePersonaje = this.personajeModelo.getRegistroDePaso();

        graphicsContext.setLineWidth(5.0);

        graphicsContext.beginPath();

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillOval(495, 495, 10,10);
        graphicsContext.fill();
        graphicsContext.setStroke(Color.BLACK);

        dibujar(bitacoraDePersonaje);

    }

    private void dibujar(ArrayList<String> bitacoraDePersonaje){

        DibujadorEnCanvas dibujador = new DibujadorEnCanvas(this.base / 2, this.altura / 2, this.base / 10);
        ConversorRegistroDePasoAOrdenDeDibujo conversor = new ConversorRegistroDePasoAOrdenDeDibujo();

        this.graphicsContext.moveTo(this.base / 2, this.altura / 2);


        /*ArrayList<String> bitacora = new ArrayList<>();
        bitacora.add("bajaLapiz");
        bitacora.add("derecha");
        bitacora.add("arriba");
        bitacora.add("izquierda");
        bitacora.add("subeLapiz");
        bitacora.add("izquierda");
        bitacora.add("abajo");
        bitacora.add("bajaLapiz");
        bitacora.add("izquierda");*/

        for(int i = 0; i < bitacoraDePersonaje.size(); i++){

            OrdenDeDibujoParaCanvas orden = conversor.obtenerOrden(bitacoraDePersonaje.get(i));
            orden.ejecutarOrden(dibujador, this.graphicsContext);

        }

        graphicsContext.stroke();

    }
    public void update(){

        this.dibujarCaminoDePersonaje();

    }

    public void clear(){

        this.graphicsContext.clearRect(0, 0, this.base, this.altura);
        this.pintarFondo();

    }

    private void pintarFondo(){

        this.graphicsContext.setFill(Color.BEIGE);
        this.graphicsContext.fillRect(0, 0, this.base, this.altura);
        this.graphicsContext.fill();

    }
}
