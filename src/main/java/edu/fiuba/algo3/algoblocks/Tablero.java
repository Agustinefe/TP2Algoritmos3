package edu.fiuba.algo3.algoblocks;/* Author: firmapaz ;created on 14/12/20*/

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


}
