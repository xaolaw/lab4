package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection direction = MapDirection.NORTH;

    public String toString(){
        return position.toString() + " " +  direction.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.direction = this.direction.previous();
            case RIGHT -> this.direction = this.direction.next();
            case FORWARD -> {
                this.position = this.position.add(this.direction.toUnitVector());
                if (this.position.x == 5) {
                    this.position = this.position.subtract(new Vector2d(5, 0));
                }
                if (this.position.y == 5) {
                    this.position = this.position.subtract(new Vector2d(0, 5));
                }
            }
            case BACKWARD -> {
                this.position = this.position.subtract(this.direction.toUnitVector());
                if (this.position.x == -1) {
                    this.position = this.position.add(new Vector2d(5, 0));
                }
                if (this.position.y == -1) {
                    this.position = this.position.add(new Vector2d(0, 5));
                }
            }
        }
        ;
    }
}
