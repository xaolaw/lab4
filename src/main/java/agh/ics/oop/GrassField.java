package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class GrassField extends AbstractWorldMap{
    private int Size;
    public GrassField(int positions){
        double DoubleValue = Math.sqrt(10*positions);
        this.Size = (int) DoubleValue;
        Grass first = new Grass(new Vector2d((int) (Math.random() * Size) ,(int) (Math.random() * Size)));
        objects.add(first);
        int how_many=1;
        while (how_many!=positions){
            Grass toAdd = new Grass(new Vector2d((int) (Math.random() * Size) ,(int) (Math.random() * Size)));
            if (!isOccupied(toAdd.getPosition())){
                objects.add(toAdd);
                how_many+=1;
            }
        }
    }
    @Override
    public Object objectAt(Vector2d position) {
        Grass grass=null;
        for (IMapElement cat : objects){
            if (cat.isAt(position)){
                if (cat instanceof Animal){
                    return cat;
                }
                else if(cat instanceof Grass){
                    grass=(Grass) cat;
                }
            }
        }
        return grass;
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
