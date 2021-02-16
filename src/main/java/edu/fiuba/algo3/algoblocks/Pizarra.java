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

    private int funcionCoordenadasAPosicionEnListaDeCeldas(int x, int y){

        return (this.base * y + x);

    }

    public Celda obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(int coordenadaX, int coordenadaY, DireccionDeMovimiento
                                                             direccionDeCeldaContigua){

        int[] nuevasCoordenadas = direccionDeCeldaContigua.aplicarDesplazamiento(coordenadaX, coordenadaY);
        this.comprobarQueLasCoordenadasEstanDentroDeLaPizarra(nuevasCoordenadas);
        int posicionDeCeldaContigua = this.funcionCoordenadasAPosicionEnListaDeCeldas(nuevasCoordenadas[0], nuevasCoordenadas[1]);

        return listaDeCeldas.get(posicionDeCeldaContigua);

    }

    public Celda obtenerCeldaCentral(){

        int posicionDeCeldaContigua = this.funcionCoordenadasAPosicionEnListaDeCeldas(
                this.base / 2,
                this.altura / 2);

        return listaDeCeldas.get(posicionDeCeldaContigua);
    }

    private void comprobarQueLasCoordenadasEstanDentroDeLaPizarra(int[] coordenadas){

        if(coordenadas[0] >= this.base || coordenadas[1] >= this.altura){
            //Tira error de pizarra fuera de rango
        }

    }

    public void blanquearTodo(){

        this.listaDeCeldas.stream().forEach(celda -> {celda.blanquear();});

    }

}
