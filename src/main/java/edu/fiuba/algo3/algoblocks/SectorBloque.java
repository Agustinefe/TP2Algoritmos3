package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

import java.util.ArrayList;
import java.util.HashMap;

public class SectorBloque {

    private HashMap<String, SecuenciaDeBloques> bloquesDisponibles;

    public SectorBloque(){
        this.bloquesDisponibles = new HashMap<>();
        ArrayList<Bloque> listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Derecha())); // DERECHA (0)
        this.bloquesDisponibles.put( "derecha", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Izquierda())); // IZQUIERDA (1)
        this.bloquesDisponibles.put( "izquierda", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Arriba())); // ARRIBA (2)
        this.bloquesDisponibles.put( "arriba", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueMovimiento(new Abajo())); // ABAJO (3)
        this.bloquesDisponibles.put( "abajo", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueBajarLapiz()); // BAJAR LAPIZ (4)
        this.bloquesDisponibles.put( "bajar lapiz", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueSubirLapiz()); // SUBIR LAPIZ (5)
        this.bloquesDisponibles.put( "subir lapiz", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueRepeticionPor2()); // REPETICION 2 (6)
        this.bloquesDisponibles.put( "repeticion x2", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueRepeticionPor3()); // REPETICION 3 (7)
        this.bloquesDisponibles.put( "repeticion x3", new SecuenciaDeBloques(listaBloques));
        listaBloques = new ArrayList<>();
        listaBloques.add(new BloqueInvertirComportamiento()); // INVERSOR (8)
        this.bloquesDisponibles.put( "inversor", new SecuenciaDeBloques(listaBloques));
    }

    public SecuenciaDeBloques nuevoBloque(String nombre){

        SecuenciaDeBloques bloque = bloquesDisponibles.get(nombre);
        return bloque.duplicar();

    }

    public void crearAlgoritmoPersonalizado(SecuenciaDeBloques bloque, String nombre){

        //TODO buscar una mejor manera de hacer esto
        BloquePersonalizado nuevoBloque = new BloquePersonalizado(bloque.duplicar());
        ArrayList<Bloque> listaBloques = new ArrayList<>();
        listaBloques.add(nuevoBloque);
        this.bloquesDisponibles.put(nombre, new SecuenciaDeBloques(listaBloques));

    }

    //metodo para pruebas
    public int  cantidadDeBloques(){
        return bloquesDisponibles.size();
    }

}
