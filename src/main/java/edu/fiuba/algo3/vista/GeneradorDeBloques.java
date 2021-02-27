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
        this.nombreParaRectangulo.put("derecha", new ConfiguracionDeRectangulo("Derecha", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("izquierda", new ConfiguracionDeRectangulo("Izquierda", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("arriba", new ConfiguracionDeRectangulo("Arriba", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("abajo", new ConfiguracionDeRectangulo("Abajo", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("bajar lapiz", new ConfiguracionDeRectangulo("Bajar Lapiz", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("subir lapiz", new ConfiguracionDeRectangulo("Subir Lapiz", Color.LIGHTBLUE, 50, 75));
        this.nombreParaRectangulo.put("repeticion x2", new ConfiguracionDeRectangulo("x2", Color.LIGHTGREEN, 50, 75));
        this.nombreParaRectangulo.put("repeticion x3", new ConfiguracionDeRectangulo("x3", Color.LIGHTGREEN, 50, 75));
        this.nombreParaRectangulo.put("inversor", new ConfiguracionDeRectangulo("Invertir", Color.PINK, 50, 75));

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
