package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.List;

public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        String[] a = {"f","f","f","f","f","f","f","f"};
        MoveDirection[] directions;
        try{
            directions = new OptionsParser().parse(a);
        }catch (IllegalArgumentException ex){
            directions=new MoveDirection[]{};
            System.out.println(ex.getMessage());
        }
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = new Vector2d[]{new Vector2d(-3, 10)};
        try {
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        for(int i=map.borderDown().x;i<=map.borderUP().x+1;i++){
            grid.getColumnConstraints().add(new ColumnConstraints(30));
        }
        for(int i=map.borderDown().y;i<=map.borderUP().y+1;i++){
            grid.getRowConstraints().add(new RowConstraints(30));
        }
        grid.add(new Label("y/x"),0,0);
        for(int i=map.borderDown().x;i<=map.borderUP().x;i++){
            grid.add(new Label(String.valueOf(i)),i-map.borderDown().x+1,0);
        }
        for(int i=map.borderDown().y;i<=map.borderUP().y;i++){
            grid.add(new Label(String.valueOf(i)),0,i-map.borderDown().y+1);
        }
        for(int i=map.borderDown().x;i<=map.borderUP().x;i++){
            for(int j=map.borderDown().y;j<=map.borderUP().y;j++){
               if(map.isOccupied(new Vector2d(i,j))){
                    grid.add(new Label(String.valueOf(map.objectAt(new Vector2d(i,j)))),i-map.borderDown().x+1,j-map.borderDown().y+1);
               }
            }
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
