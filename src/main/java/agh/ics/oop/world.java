package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class world {
    public static void  main(String[] args){
        String[] a = {"r","l","f","f","f","f","r","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(a);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,4), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}
