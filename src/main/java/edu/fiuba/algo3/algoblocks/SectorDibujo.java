package edu.fiuba.algo3.algoblocks;

public class SectorDibujo {

    private Pizarra pizarraDeDibujo;
    private Personaje dibujante;

    public SectorDibujo(int baseDePizarra, int alturaDePizarra){

        this.pizarraDeDibujo = new Pizarra(baseDePizarra, alturaDePizarra);
        this.dibujante = new Personaje(this.pizarraDeDibujo.obtenerCeldaCentral());

    }

    public void ejecutarBloque(Bloque bloqueDeAlgoritmo){

        bloqueDeAlgoritmo.ejecutarComportamientoSobrePizarraEn(this.pizarraDeDibujo, this.dibujante);

    }

}
