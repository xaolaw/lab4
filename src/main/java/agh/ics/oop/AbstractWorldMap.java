package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<IMapElement> objects = new ArrayList<>();
    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            objects.add(animal);
            return true;
        }
        return false;

    }
    @Override
    public Object objectAt(Vector2d position) {
        for (IMapElement cat : objects){
            if (cat.isAt(position)){
                return cat;
            }
        }
        return null;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }
    @Override
    public String toString(){
        Vector2d def = new Vector2d(1000000000,1000000000);
        Vector2d def2 = new Vector2d(-1000000000,-1000000000);
        for (IMapElement cat : objects){
            def=def.lowerLeft(cat.getPosition());
            def2=def2.upperRight(cat.getPosition());
        }
        return new MapVisualizer(this).draw(def,def2);
    }
}
