package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 12/12/20*/

import edu.fiuba.algo3.excepciones.FueraDePizarraException;

public class Celda{

    private Coordenadas posicion;
    private boolean dibujado;


    public Celda(int coordenadaX, int coordenadaY){

        this.posicion = new Coordenadas(coordenadaX, coordenadaY);
        this.dibujado = false;

    }

    public Celda obtenerCeldaQueEstaALa(DireccionDeMovimiento direccionALaQueSeMueveElPersonaje) throws FueraDePizarraException {

        return Pizarra.getInstance().obtenerCeldaQueEstaAlLadoDeEstasCoordenadas(this.posicion, direccionALaQueSeMueveElPersonaje);

    }

    public boolean dibujar(){

        this.dibujado = true;

        return true;

    }

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



    /*Mensajes que rompen principios de POO pero
    son solo para pruebitas no me peguen
     */

    public void imprimirCoordenadas(){

        this.posicion.imprimirCoordenadas();

    }

}
