package edu.fiuba.algo3.algoblocks;

import java.util.ArrayList;

public class Tablero {

    private SectorDibujo sectorDeDibujo;
    private SectorAlgoritmo sectorDeAlgoritmos;
    private SectorBloque sectorDeBloques;

    public Tablero(int baseDePizarra, int alturaDePizarra){

        this.sectorDeDibujo = new SectorDibujo(baseDePizarra, alturaDePizarra);
        this.sectorDeAlgoritmos = new SectorAlgoritmo();
        this.sectorDeBloques = new SectorBloque();

    }

    public void ejecutarSucesionDeAlgoritmos(){

        this.sectorDeAlgoritmos.ejecutarAlgoritmoEn(this.sectorDeDibujo);

    }

    public void agregarBloqueBajarLapiz(){

        sectorDeAlgoritmos.aniadirBloqueAlFinal(sectorDeBloques.crearBloqueBajarLapiz());

    }
}
