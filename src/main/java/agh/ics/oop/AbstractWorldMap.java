package agh.ics.oop;

import jdk.jshell.ImportSnippet;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    Map<Vector2d,IMapElement> objects = new HashMap<>();
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            objects.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        IMapElement a = objects.get(position);
        return a;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }
    @Override
    public String toString(){
        Vector2d def = new Vector2d(1000000000,1000000000);
        Vector2d def2 = new Vector2d(-1000000000,-1000000000);
        for (Vector2d cat : objects.keySet()){
            def=def.lowerLeft(cat);
            def2=def2.upperRight(cat);
        }
        return new MapVisualizer(this).draw(def,def2);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement craeture = objects.get(oldPosition);
        objects.remove(oldPosition);
        objects.put(newPosition,craeture);
    }
}
