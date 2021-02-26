package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 24/2/21*/

import edu.fiuba.algo3.algoblocks.Abajo;
import edu.fiuba.algo3.algoblocks.Arriba;
import edu.fiuba.algo3.algoblocks.Derecha;
import edu.fiuba.algo3.algoblocks.Izquierda;

import java.util.HashMap;

public class ConversorRegistroDePasoAOrdenDeDibujo {

    private HashMap<String, OrdenDeDibujoParaCanvas> listaDeConversiones;
    
    public ConversorRegistroDePasoAOrdenDeDibujo(){

        this.listaDeConversiones = new HashMap<>();
        this.listaDeConversiones.put("subeLapiz", new OrdenSubirLapiz());
        this.listaDeConversiones.put("bajaLapiz", new OrdenBajarLapiz());
        this.listaDeConversiones.put("arriba", new OrdenMovimiento(new Abajo()));
        this.listaDeConversiones.put("abajo", new OrdenMovimiento(new Arriba()));
        this.listaDeConversiones.put("izquierda", new OrdenMovimiento(new Izquierda()));
        this.listaDeConversiones.put("derecha", new OrdenMovimiento(new Derecha()));

    }

    public OrdenDeDibujoParaCanvas obtenerOrden(String registroDePaso){

        if(!this.listaDeConversiones.containsKey(registroDePaso)){

            //tiraError

        }

        return this.listaDeConversiones.get(registroDePaso);
    }
    
}
