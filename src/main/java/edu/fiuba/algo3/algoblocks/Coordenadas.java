package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 16/2/21*/

public class Coordenadas {

    private int x;
    private int y;

    public Coordenadas(int x, int y){

        this.x = x;
        this.y = y;

    }

    public Coordenadas generarCoordenadasAdyacentes(DireccionDeMovimiento direccion){

        int[] nuevasCoordenadas = direccion.aplicarDesplazamiento(this.x, this.y);

        return new Coordenadas(nuevasCoordenadas[0],nuevasCoordenadas[1]);
    }

    public int posicionEnLaMatriz(int baseDeLaMatriz){

        return (baseDeLaMatriz * this.y + this.x);

    }

    public boolean sonLasMismasCoordenadas(Coordenadas coordenadasAComparar){

        return coordenadasAComparar.losNumerosCoinciden(this.x, this.y);

    }

    private boolean losNumerosCoinciden(int xAComparar, int yAComparar){

        return ((this.x == xAComparar) && (this.y == yAComparar));

    }

    public boolean seEncuentraDentroDeLoslimites(int limiteX, int limiteY){

        return (-1 < this.x &&
                -1 < this.y &&
                this.x < limiteX &&
                this.y < limiteY);

    }

}
