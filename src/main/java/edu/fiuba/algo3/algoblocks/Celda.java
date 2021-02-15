package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class Celda{

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

        boolean mismasCoordenadas = otraCelda.sonLasMismasCoordenadas(this.x, this.y);
        boolean ambasDibujadas = otraCelda.seEncuentranAmbasDibujadas(this.dibujado);

        return (mismasCoordenadas && ambasDibujadas);

    }

    private boolean seEncuentranAmbasDibujadas(boolean estadoDeOtraCelda){

        return (this.dibujado == estadoDeOtraCelda);

    }

    private boolean sonLasMismasCoordenadas(int otraX, int otraY){

        return (this.x == otraX && this.y == otraY);

    }

    public void blanquear(){

        this.dibujado = false;

    }

   /* public void imprimirCoordenadas(){

        System.out.println(this.x);
        System.out.println(this.y);

    }*/

}
