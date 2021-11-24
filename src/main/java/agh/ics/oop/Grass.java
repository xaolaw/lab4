package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d position;
    public Grass(Vector2d position){
        this.position=position;
    }
    @Override
    public Vector2d getPosition() {
        return position;
    }
    public String toString() {
        return "*";
    }
    @Override
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
}
