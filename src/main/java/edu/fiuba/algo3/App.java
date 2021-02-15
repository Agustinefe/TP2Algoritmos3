package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.MyButtonEventHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        StackPane layout = new StackPane();
        Button miBoton = new Button();
        miBoton.setText("Clickeame");
        MyButtonEventHandler eventoDeBoton = new MyButtonEventHandler(miBoton);
        miBoton.setOnAction(eventoDeBoton);
        layout.getChildren().add(miBoton);
        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Hola");
        stage.show();*/

        Circle circle = createCircle("#ff00ff", "#ff88ff",100);

        circle.setOnDragDetected((MouseEvent event) -> {
            System.out.println("Circle 1 drag detected");

            Dragboard db = circle.startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putString("Circle source text");
            db.setContent(content);
        });
        circle.setOnMouseDragged((MouseEvent event) -> {
            event.setDragDetect(true);
        });

        Circle circle2 = createCircle("#00ffff", "#88ffff",300);

        circle2.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != circle2 && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        circle2.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                System.out.println("Dropped: " + db.getString());
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }
            event.consume();
        });

        Shape shape = new Rectangle(50, 50);
        shape.setStroke(Color.RED);

        

        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().add(circle2);

        Scene scene = new Scene(pane, 1024, 800, true);
        stage.setScene(scene);
        stage.setTitle("2D Example");

        stage.show();
    }

    private Circle createCircle(String strokeColor, String fillColor, double x) {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(200);
        circle.setRadius(50);
        circle.setStroke(Color.valueOf(strokeColor));
        circle.setStrokeWidth(5);
        circle.setFill(Color.valueOf(fillColor));
        return circle;
    }

    public static void main(String[] args) {
        launch();
    }

}