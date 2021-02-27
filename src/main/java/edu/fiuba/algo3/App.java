package edu.fiuba.algo3;

import edu.fiuba.algo3.algoblocks.*;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        var scene = new Scene(contenedorPrincipal, 1700, 680);
        stage.setScene(scene);
        stage.setTitle("Hola");
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