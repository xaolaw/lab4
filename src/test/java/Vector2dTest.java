import org.junit.jupiter.api.Test;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Assertions;
public class Vector2dTest {
    Vector2d a = new Vector2d(1,2);
    @Test
    void toStringTest(){
        String n;
        n=a.toString();
        Assertions.assertEquals(n,"(1,2)");
    }
    @Test
    void equalsTest(){
        Vector2d b = new Vector2d(1,2);
        Assertions.assertEquals(a, b);
    }
    @Test
    public void precedesTest(){
        Vector2d c = new Vector2d(5,4);
        Assertions.assertTrue(a.precedes(c));
    }
    @Test
    public void followsTest(){
        Vector2d c = new Vector2d(-1,0);
        Assertions.assertTrue(a.follows(c));
    }
    @Test
    void upperRightTest(){
        Vector2d c = new Vector2d(-1,10);
        Assertions.assertEquals(a.upperRight(c),new Vector2d(1,10));
    }
    @Test
    void lowerLeftTest(){
        Vector2d c = new Vector2d(-1,10);
        Assertions.assertEquals(a.lowerLeft(c),new Vector2d(-1,2));
    }
    @Test
    void addTest(){
        Vector2d c = new Vector2d(-1,10);
        Assertions.assertEquals(a.add(c),new Vector2d(0,12));
    }
    @Test
    void subtract(){
        Vector2d c = new Vector2d(-1,10);
        Assertions.assertEquals(a.subtract(c),new Vector2d(2,-8));
    }
    @Test
    void oppositeTest(){
        Assertions.assertEquals(a.opposite(),new Vector2d(2,1));
    }

}
