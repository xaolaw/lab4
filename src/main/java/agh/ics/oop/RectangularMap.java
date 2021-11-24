package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap extends AbstractWorldMap{
    private final int height;
    private final int width;
    public RectangularMap(int width, int height){
        this.height=height;
        this.width=width;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0),new Vector2d(this.width,this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(width,height)) && position.follows(new Vector2d(0,0)) && !isOccupied(position);
    }



    @Override
    public Vector2d forceInBounds(Vector2d position){
        Vector2d vec = new Vector2d(position.x%(this.width+1),position.y%(this.height+1));
        if (vec.x<0){
            vec=vec.add(new Vector2d(this.width +1 ,0));
        }
        if (vec.y<0){
            vec=vec.add(new Vector2d(0,this.height +1));
        }
        return  vec;
    }
}
