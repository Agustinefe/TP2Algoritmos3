package edu.fiuba.algo3.algoblocks;

public class Celda {

    private int x;
    private int y;
    private boolean dibujado;


    public Celda(int coordenadaX, int coordenadaY){

        this.x = coordenadaX;
        this.y = coordenadaY;
        this.dibujado = false;

    }

    public Celda obtenerCeldaQueEstaALa(DireccionDeMovimiento direccionALaQueSeMueveElPersonaje, Pizarra estaPizarra){

        return estaPizarra.obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(this.x, this.y, direccionALaQueSeMueveElPersonaje);

    }

    public boolean dibujar(){

        this.dibujado = true;

        return this.dibujado;

    }


    //Violadisimo ese encapsulamiento
    public boolean seEncuentraDibujada(){

        return this.dibujado;

    }

    //DOUBLE DISPAAAAAAAAAAAAAAAAAAAAAAAAAAATCH
    public boolean esIgualA(Celda otraCelda){

        return otraCelda.sonLasMismasCoordenadas(this.x, this.y);

    }

    private boolean sonLasMismasCoordenadas(int otraX, int otraY){

        return (this.x == otraX && this.y == otraY);

    }


}
