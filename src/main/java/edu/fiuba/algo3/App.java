package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.*;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {

        HBox contenedorPrincipal = new HBox();

        this.inicializarModelo(contenedorPrincipal);

        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setBackground(new Background(new BackgroundFill(Color.SADDLEBROWN.darker(), CornerRadii.EMPTY, Insets.EMPTY)));

        var scene = new Scene(contenedorPrincipal, 1500, 680);
        stage.setScene(scene);
        stage.setTitle("AlgoBlocks");
        stage.show();

    }

    private void inicializarModelo(HBox contenedorPrincipal){

        Personaje dibujantePrincipal = new Personaje(Pizarra.getInstance().obtenerCeldaCentral());
        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
        SectorBloque sectorBloque = new SectorBloque();

        VistaEspacioDeTrabajo espacioDeTrabajo = new VistaEspacioDeTrabajo();
        VistaBotoneraDeBloques botoneraDeBloques = new VistaBotoneraDeBloques(sectorBloque, sectorAlgoritmo, espacioDeTrabajo);

        VistaControladorDeEspacioDeTrabajo controladorDeEspacioDeTrabajo = new VistaControladorDeEspacioDeTrabajo(
                botoneraDeBloques, espacioDeTrabajo, sectorBloque, sectorAlgoritmo);

        VistaSectorDibujo vistaSectorDibujo = new VistaSectorDibujo(dibujantePrincipal, sectorAlgoritmo);
        VistaSectorBloque vistaSectorBloque = new VistaSectorBloque(botoneraDeBloques);
        VistaSectorAlgoritmo vistaSectorAlgoritmo = new VistaSectorAlgoritmo(espacioDeTrabajo, controladorDeEspacioDeTrabajo);

        contenedorPrincipal.getChildren().addAll(
                vistaSectorDibujo,
                vistaSectorBloque,
                vistaSectorAlgoritmo);

    }

}