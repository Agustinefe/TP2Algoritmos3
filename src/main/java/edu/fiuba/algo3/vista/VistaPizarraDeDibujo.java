package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.Personaje;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaPizarraDeDibujo {

    private StackPane pizarraDeDibujo;
    private Canvas lienzo;
    private Personaje personajeModelo;
    private GraphicsContext graphicsContext;
    private ImageView gatitoDibujante;
    private final int base = 400;
    private final int altura = 400;


    public VistaPizarraDeDibujo(Personaje dibujante){

        this.personajeModelo = dibujante;
        this.lienzo = new Canvas(this.base, this.altura);
        this.gatitoDibujante = new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/lapiz.png"));
        this.gatitoDibujante.setFitWidth(25);
        this.gatitoDibujante.setFitHeight(25);
        this.pizarraDeDibujo = new StackPane(this.lienzo, gatitoDibujante);
        this.graphicsContext = this.lienzo.getGraphicsContext2D();
        this.pintarFondo();

    }

    public StackPane obtenerPizarraDeDibujo(){

        return this.pizarraDeDibujo;

    }

    private void prepararAreaDeDibujo(){

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

        for(int i = 0; i < bitacoraDePersonaje.size(); i++){

            OrdenDeDibujoParaCanvas orden = conversor.obtenerOrden(bitacoraDePersonaje.get(i));
            orden.ejecutarOrden(dibujador, this.graphicsContext, this.gatitoDibujante);

        }

        graphicsContext.stroke();

    }
    public void dibujarCaminoDelPersonaje(){

        this.prepararAreaDeDibujo();

    }

    public void clear(){

        this.graphicsContext.clearRect(0, 0, this.base, this.altura);
        this.pintarFondo();
        this.gatitoDibujante.setTranslateX(0);
        this.gatitoDibujante.setTranslateY(0);

    }

    private void pintarFondo(){

        this.graphicsContext.setFill(Color.LIGHTYELLOW);
        this.graphicsContext.fillRect(0, 0, this.base, this.altura);
        this.graphicsContext.fill();

    }
}
