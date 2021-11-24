package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.Position;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    @Test
    void test() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(positions[0], new Vector2d(2, 5));
        Assertions.assertEquals(positions[1], new Vector2d(3, 1));
    }

    @Test
    void test2() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(21, 37);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assertions.assertEquals(positions[0], new Vector2d(2, 3));
        Assertions.assertEquals(positions[1], new Vector2d(3, 3));

    }
}