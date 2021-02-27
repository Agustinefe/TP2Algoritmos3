package edu.fiuba.algo3.vista;/* Author: firmapaz ;created on 26/2/21*/

import edu.fiuba.algo3.algoblocks.SectorAlgoritmo;
import edu.fiuba.algo3.algoblocks.SectorBloque;
import edu.fiuba.algo3.eventos.BotonRemoverEventHandler;
import edu.fiuba.algo3.eventos.BotonVolverAEmpezarEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class VistaControladorDeEspacioDeTrabajo extends HBox {

    public VistaControladorDeEspacioDeTrabajo(VistaBotoneraDeBloques vistaBotoneraDeBloques,
                                              VistaEspacioDeTrabajo vistaEspacioDeTrabajo,
                                              SectorBloque sectorBloque,
                                              SectorAlgoritmo sectorAlgoritmo){


        this.setSpacing(10);

        TextField posicionEnSecuencia = new TextField();
        posicionEnSecuencia.setPromptText("Posicion");

        Button botonRemover = new Button();
        botonRemover.setText("Remover");
        BotonRemoverEventHandler eventoRemover = new BotonRemoverEventHandler(posicionEnSecuencia, sectorAlgoritmo, vistaEspacioDeTrabajo);
        botonRemover.setOnAction(eventoRemover);

        Button botonVolverAEmpezar = new Button();
        botonVolverAEmpezar.setText("Volver a empezar");
        BotonVolverAEmpezarEventHandler eventoVolverAEmpezar = new BotonVolverAEmpezarEventHandler(vistaEspacioDeTrabajo, sectorAlgoritmo);
        botonVolverAEmpezar.setOnAction(eventoVolverAEmpezar);

        this.getChildren().addAll(
                new Label("Posicion: "),
                posicionEnSecuencia,
                botonRemover,
                botonVolverAEmpezar);


    }

}
