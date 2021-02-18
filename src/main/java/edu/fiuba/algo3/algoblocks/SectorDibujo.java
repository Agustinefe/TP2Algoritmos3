package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

public class SectorDibujo {


    private Personaje dibujante;

    public SectorDibujo(int baseDePizarra, int alturaDePizarra){


        this.dibujante = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());

    }

    public void ejecutarBloque(Bloque bloqueDeAlgoritmo){

        bloqueDeAlgoritmo.ejecutarComportamientoSobrePizarraEn(this.dibujante);

    }

    public void ejecutarSucesionDeBloques(SecuenciaDeBloques algoritmoAEjecutar){

        algoritmoAEjecutar.ejecutarComportamientoSobrePizarraEn(this.dibujante);

    }

    public boolean elPersonajeSeEncuentraEn(Celda celdaEstimada){

        return this.dibujante.seEncuentraEn(celdaEstimada);

    }

}
