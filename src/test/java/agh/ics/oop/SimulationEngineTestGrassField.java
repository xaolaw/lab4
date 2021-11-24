package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTestGrassField {
    @Test
    void test() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(positions[0], new Vector2d(2, -1));
        Assertions.assertEquals(positions[1], new Vector2d(3, 7));
    }

    @Test
    void test2() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f","l","l","f","f"});
        IWorldMap map = new GrassField(15);
        Vector2d[] positions = {new Vector2d(0, 1), new Vector2d(-5, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(positions[0], new Vector2d(2, -2));
        Assertions.assertEquals(positions[1], new Vector2d(-7, 7));
    }
}
