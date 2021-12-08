package agh.ics.oop;

import java.util.TreeMap;
import java.util.TreeSet;

class MapBoundary implements IPositionChangeObserver {
    private TreeMap<Vector2d,IMapElement> X=new TreeMap<>(new MyComparatorX());
    private TreeMap<Vector2d,IMapElement> Y= new TreeMap<>(new MyComparatorY());
    public TreeMap<Vector2d,IMapElement>  getSetX(){
        return this.X;
    }
    public TreeMap<Vector2d,IMapElement>  getSetY(){
        return this.Y;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement elem = X.get(oldPosition);
        X.remove(oldPosition);
        Y.remove(oldPosition);
        X.put(newPosition,elem);
        Y.put(newPosition,elem);
    }
}
