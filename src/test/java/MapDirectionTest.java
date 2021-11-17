import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    MapDirection north = MapDirection.NORTH;
    MapDirection east = MapDirection.EAST;
    MapDirection south = MapDirection.SOUTH;
    MapDirection west = MapDirection.WEST;
    @Test
    void NextTest(){
        Assertions.assertEquals(north.next(),east);
        Assertions.assertEquals(east.next(),south);
        Assertions.assertEquals(south.next(),west);
        Assertions.assertEquals(west.next(),north);
    }
    @Test
    void previousTest(){
        Assertions.assertEquals(north.previous(),west);
        Assertions.assertEquals(east.previous(),north);
        Assertions.assertEquals(south.previous(),east);
        Assertions.assertEquals(west.previous(),south);
    }
}
