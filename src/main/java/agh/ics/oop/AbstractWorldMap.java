package agh.ics.oop;

import jdk.jshell.ImportSnippet;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    MapBoundary set = new MapBoundary();
    Map<Vector2d,IMapElement> objects = new HashMap<>();
    Map<Vector2d,IMapElement> toAdd = new HashMap<>();
    public Vector2d borderDown(){
        return new Vector2d(set.getSetX().firstKey().x,set.getSetY().firstKey().y);
    }
    public Vector2d borderUP(){
        return new Vector2d(set.getSetX().lastKey().x,set.getSetY().lastKey().y);
    }
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            if (objects.get(animal.getPosition()) instanceof Grass){
                toAdd.put(objects.get(animal.getPosition()).getPosition(),objects.get(animal.getPosition()));
            }
            objects.put(animal.getPosition(), animal);
            set.getSetX().put(animal.getPosition(),animal);
            set.getSetY().put(animal.getPosition(),animal);
            animal.addObserver(this);
            animal.addObserver(set);
            return true;
        }
        throw new IllegalArgumentException("This position is already occupied " + animal.getPosition());
    }
    @Override
    public Object objectAt(Vector2d position) {
        return objects.get(position);
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }
    @Override
    public String toString(){
        Vector2d def = new Vector2d(set.getSetX().firstKey().x,set.getSetY().firstKey().y);
        Vector2d def2 = new Vector2d(set.getSetX().lastKey().x,set.getSetY().lastKey().y);
        /*
        for (Vector2d cat : objects.keySet()){
            def=def.lowerLeft(cat);
            def2=def2.upperRight(cat);
        }*/
        return new MapVisualizer(this).draw(def,def2);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement craeture = objects.get(oldPosition);
        IMapElement newAdd=null;
        if (toAdd.size()>0){
            newAdd = toAdd.get(oldPosition);
        }
        if (objects.get(newPosition) instanceof Grass){
            toAdd.put(objects.get(newPosition).getPosition(),objects.get(newPosition));
        }
        objects.remove(oldPosition);
        if (newAdd!=null){
            objects.put(newAdd.getPosition(),newAdd);
        }
        objects.put(newPosition,craeture);
    }
}
