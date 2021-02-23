package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;

public class SectorBloque {

    private ArrayList<SecuenciaDeBloques> bloquesDisponibles;

    public SectorBloque(){
        this.bloquesDisponibles = new ArrayList<>();
        ArrayList<Bloque> listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Derecha())); // DERECHA (0)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Izquierda())); // IZQUIERDA (1)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Arriba())); // ARRIBA (2)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Abajo())); // ABAJO (3)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueBajarLapiz()); // BAJAR LAPIZ (4)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueSubirLapiz()); // SUBIR LAPIZ (5)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueRepeticion2()); // REPETICION 2 (6)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueRepeticion3()); // REPETICION 3 (7)
        this.bloquesDisponibles.add(new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueInvertirComportamiento()); // INVERSOR (8)
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
