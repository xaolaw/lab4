package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
    public String toString(){
        return direction.toString();
    }
    @Override
    public boolean isAt(Vector2d position){return this.position.equals(position);
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
        }
    }
    @Override
    public Vector2d getPosition() {
        return position;
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition,Vector2d newPosition){
        for (IPositionChangeObserver i : observers){
            i.positionChanged(oldPosition,newPosition);
        }
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
