package agh.ics.oop;

import java.util.TreeSet;

class MapBoundary implements IPositionChangeObserver {
    private TreeSet<IMapElement> X ;//= new TreeSet<IMapElement>(new MyComparatorX());
    private TreeSet<IMapElement> Y ;//= new TreeSet<IMapElement>(new MyComparatorY());
    public MapBoundary(TreeSet<IMapElement> x ,TreeSet<IMapElement> y){
        this.X=x;
        this.Y=y;
    }
    public TreeSet<IMapElement>  getSetX(){
        return this.X;
    }
    public TreeSet<IMapElement>  getSetY(){
        return this.Y;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}
