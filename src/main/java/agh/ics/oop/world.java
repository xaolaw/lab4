package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;
import jdk.jshell.ImportSnippet;

import java.util.*;

public class world {
    public static void  main(String[] args) {
        /*String[] a = {"f","f","f","f","f","f","f","f"};
        MoveDirection[] directions;
        try{
            directions = new OptionsParser().parse(a);
        }catch (IllegalArgumentException ex){
            directions=new MoveDirection[]{};
            System.out.println(ex.getMessage());
        }
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = new Vector2d[]{new Vector2d(-3, 10)};
        IEngine engine;
        try {
            engine = new SimulationEngine(directions, map, positions);
        }catch (IllegalArgumentException ex) {
            engine = new SimulationEngine(directions, map, new Vector2d[]{});
            System.out.println(ex.getMessage());
        }
        engine.run();*/
        Application.launch(App.class, args);
    }
}
