package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 16/2/21*/

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class GeneradorDeBloques {

    private static GeneradorDeBloques miGenerador = new GeneradorDeBloques();
    private HashMap<String, ConfiguracionDeRectangulo> nombreParaRectangulo;

    private GeneradorDeBloques(){

        this.nombreParaRectangulo = new HashMap<>();
        this.nombreParaRectangulo.put("Derecha", new ConfiguracionDeRectangulo("Derecha", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Izquierda", new ConfiguracionDeRectangulo("Izquierda", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Arriba", new ConfiguracionDeRectangulo("Arriba", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Abajo", new ConfiguracionDeRectangulo("Abajo", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Bajar lapiz", new ConfiguracionDeRectangulo("Bajar Lapiz", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Subir lapiz", new ConfiguracionDeRectangulo("Subir Lapiz", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("Repetir 2 veces", new ConfiguracionDeRectangulo("x2", Color.LIGHTGREEN, 50, 75));
        this.nombreParaRectangulo.put("Repetir 3 veces", new ConfiguracionDeRectangulo("x3", Color.LIGHTGREEN, 50, 75));
        this.nombreParaRectangulo.put("Invertir comportamiento", new ConfiguracionDeRectangulo("Invertir", Color.PINK, 50, 75));

    }

    public static GeneradorDeBloques getInstance(){

        return miGenerador;

    }

    public StackPane generarNuevoBloque(String nombreDelBloque){

        return this.nombreParaRectangulo.get(nombreDelBloque).generarBloque();

    }

    public void agregarNombreBloquePersonalizado(String nombre){

        this.nombreParaRectangulo.put(nombre, new ConfiguracionDeRectangulo(nombre, Color.YELLOW, 50, 75));

    }

}
