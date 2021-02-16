package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

public class Celda{

    private Coordenadas posicion;
    private boolean dibujado;


    public Celda(int coordenadaX, int coordenadaY){

        this.posicion = new Coordenadas(coordenadaX, coordenadaY);
        this.dibujado = false;

    }

    public Celda obtenerCeldaQueEstaALa(DireccionDeMovimiento direccionALaQueSeMueveElPersonaje){

        return Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(this.posicion, direccionALaQueSeMueveElPersonaje);

    }

    public boolean dibujar(){

        this.dibujado = true;

        return true;

    }


    //Violadisimo ese encapsulamiento
    public boolean seEncuentraDibujada(){

        return this.dibujado;

    }

    //DOUBLE DISPAAAAAAAAAAAAAAAAAAAAAAAAAAATCH
    public boolean esIgualA(Celda otraCelda){

        boolean mismasCoordenadas = otraCelda.sonLasMismasCoordenadas(this.posicion);
        boolean ambasDibujadas = otraCelda.seEncuentranAmbasDibujadas(this.dibujado);

        return (mismasCoordenadas && ambasDibujadas);

    }

    private boolean seEncuentranAmbasDibujadas(boolean estadoDeOtraCelda){

        return (this.dibujado == estadoDeOtraCelda);

    }

    private boolean sonLasMismasCoordenadas(Coordenadas coordenadasAComparar){

        return coordenadasAComparar.sonLasMismasCoordenadas(this.posicion);

    }

    public void blanquear(){

        this.dibujado = false;

    }

    public void imprimirCoordenadas(){

        this.posicion.imprimirCoordenadas();

    }

}
