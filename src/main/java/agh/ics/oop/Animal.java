package agh.ics.oop;

public class Animal{
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;
    public String toString(){
        return direction.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                if (this.map.canMoveTo(this.map.forceInBounds(this.position.add(this.direction.toUnitVector())))){
                    this.position = this.map.forceInBounds(this.position.add(this.direction.toUnitVector()));
                }
            }
            case BACKWARD -> {
                if (this.map.canMoveTo(this.map.forceInBounds(this.position.subtract(this.direction.toUnitVector())))) {
                    this.position = this.map.forceInBounds(this.position.subtract(this.direction.toUnitVector()));
                }
            }
        };
    }

    public Vector2d getPosition() {
        return position;
    }

    public Animal(IWorldMap map){
        this.map=map;
        this.position = new Vector2d(2,2);
    }
    public Animal(IWorldMap map,Vector2d initalPosition){
        this.map=map;
        this.position=initalPosition;
    }
}
