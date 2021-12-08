package agh.ics.oop;

import java.util.Comparator;

class MyComparatorY implements Comparator<Vector2d> {
    public int compare(Vector2d one,Vector2d two){
        int expressionX = one.x-two.x;
        int expressionY = one.y-two.y;
        if (expressionY==0){
            if (expressionX==0){
                if (one.equals(two)){
                    return 0;
                }
                return -1;
            }
            return expressionX;
        }
        return expressionY;
    }
}