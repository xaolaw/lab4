package agh.ics.oop;

import jdk.jshell.ImportSnippet;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.TreeSet;

public class GrassField extends AbstractWorldMap{
    private int Size;
    public GrassField(int positions){
        double DoubleValue = Math.sqrt(10*positions);
        this.Size = (int) DoubleValue;
        Grass first = new Grass(new Vector2d((int) (Math.random() * Size) ,(int) (Math.random() * Size)));
        objects.put(first.getPosition(),first);
        set.getSetX().put(first.getPosition(),first);
        set.getSetY().put(first.getPosition(),first);
        int how_many=1;
        while (how_many!=positions){
            Grass toAdd = new Grass(new Vector2d((int) (Math.random() * Size) ,(int) (Math.random() * Size)));
            if (!isOccupied(toAdd.getPosition())){
                objects.put(toAdd.getPosition(),toAdd);
                set.getSetX().put(toAdd.getPosition(),toAdd);
                set.getSetY().put(toAdd.getPosition(),toAdd);
                how_many+=1;
            }
        }
    }
    @Override
    public Object objectAt(Vector2d position) {
        return objects.get(position);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }
    @Override
    public Vector2d forceInBounds(Vector2d position) {
        return position;
    }
}
