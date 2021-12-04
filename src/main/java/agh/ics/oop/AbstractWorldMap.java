package agh.ics.oop;

import jdk.jshell.ImportSnippet;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    MapBoundary set = new MapBoundary(new TreeSet<>(new MyComparatorX()),new TreeSet<>(new MyComparatorY()));
    Map<Vector2d,IMapElement> objects = new HashMap<>();
    Map<Vector2d,IMapElement> toAdd = new HashMap<>();
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            if (objects.get(animal.getPosition()) instanceof Grass){
                toAdd.put(objects.get(animal.getPosition()).getPosition(),objects.get(animal.getPosition()));
            }
            objects.put(animal.getPosition(), animal);
            set.getSetX().add(animal);
            set.getSetY().add(animal);
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
        Vector2d def = new Vector2d(set.getSetX().first().getPosition().x,set.getSetY().first().getPosition().y);
        Vector2d def2 = new Vector2d(set.getSetX().last().getPosition().x,set.getSetY().last().getPosition().y);
        /*
        for (Vector2d cat : objects.keySet()){
            def=def.lowerLeft(cat);
            def2=def2.upperRight(cat);
        }*/
        return new MapVisualizer(this).draw(def,def2);
    }
    /*
    toAdd has values of grass that animal is on. So when he goes off the grass the grass gets back to Hashmap objects, also if
    the animal changed position TreeSets are updated to generate new borders of Map
     */
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement craeture = objects.get(oldPosition);
        IMapElement newAdd=null;
        set.getSetX().remove(craeture);
        set.getSetY().remove(craeture);
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
        set.getSetX().add(craeture);
        set.getSetY().add(craeture);
    }
}
