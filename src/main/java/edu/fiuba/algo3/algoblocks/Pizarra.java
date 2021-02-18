package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class Pizarra {

    private static Pizarra INSTANCIA = new Pizarra(9, 9);
    private ArrayList<Celda> listaDeCeldas;
    private int base;
    private int altura;

    /*
    * Puedo implementar la listaDeCeldas con una matriz.
    * */
    private Pizarra(int nuevaBase, int nuevaAltura){

        listaDeCeldas = new ArrayList<Celda>();
        Celda estaCelda;
        this.base = nuevaBase;
        this.altura = nuevaAltura;

        for(int h = 0; h < this.altura; h++){
            for(int b = 0; b < this.base; b++){
                estaCelda = new Celda(b, h);

                listaDeCeldas.add(estaCelda);

            }

        }

    }

    public static Pizarra getInstance(){

        return INSTANCIA;

    }


    public Celda obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(Coordenadas estasCoordenadas, DireccionDeMovimiento
                                                             direccionDeCeldaContigua){

        Coordenadas nuevasCoordenadas = estasCoordenadas.generarCoordenadasAdyacentes(direccionDeCeldaContigua);
        this.comprobarQueLasCoordenadasEstanDentroDeLaPizarra(nuevasCoordenadas);
        int posicionDeCeldaContigua = nuevasCoordenadas.posicionEnLaMatriz(this.base);

        return listaDeCeldas.get(posicionDeCeldaContigua);

    }

    public Celda obtenerCeldaCentral(){

        int posicionDeCeldaContigua = this.base * (this.altura / 2) + (this.base / 2);

        return listaDeCeldas.get(posicionDeCeldaContigua);
    }

    private void comprobarQueLasCoordenadasEstanDentroDeLaPizarra(Coordenadas coordenadasAVerificar){

        if(coordenadasAVerificar.seEncuentraDentroDeLoslimites(this.base, this.altura)){
            //Tira error de pizarra fuera de rango
        }

    }

    public void blanquearTodo(){

        this.listaDeCeldas.stream().forEach(celda -> {celda.blanquear();});

    }

}
