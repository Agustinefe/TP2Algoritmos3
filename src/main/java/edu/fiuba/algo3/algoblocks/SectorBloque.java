package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;

public class SectorBloque {

    private ArrayList<SecuenciaDeBloques> bloquesDisponibles;

    public SectorBloque(){
        this.bloquesDisponibles = new ArrayList<>();
        ArrayList<Bloque> listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Derecha())); //0
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Izquierda())); //1
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Arriba())); //2
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Abajo())); //3
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueBajarLapiz()); //4
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueSubirLapiz()); //5
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueRepeticion()); //6
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueInvertirComportamiento()); //7
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
    }

    public SecuenciaDeBloques nuevoBloque(int posicion){

        SecuenciaDeBloques bloque = bloquesDisponibles.get(posicion);
        return bloque.duplicar();

    }

    public void crearAlgoritmoPersonalizado(SecuenciaDeBloques bloque){

        this.bloquesDisponibles.add(bloque.duplicar());

    }

    //metodo para pruebas
    public int  cantidadDeBloques(){
        return bloquesDisponibles.size();
    }

}
