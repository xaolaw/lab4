package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;;import java.util.List;

public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        IWorldMap map = new GrassField(10);
        List <String> x = this.getParameters().getRaw();
        Label label = new Label("Zwierzak");
        Scene scene = new Scene(label, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
