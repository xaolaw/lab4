package agh.ics.oop;

import java.util.Comparator;

class MyComparatorX implements Comparator<IMapElement> {
    public int compare(IMapElement one,IMapElement two){
            int expressionX = one.getPosition().x-two.getPosition().x;
            int expressionY = one.getPosition().y-two.getPosition().y;
            if (expressionX==0){
                if (expressionY==0){
                    if (one.equals(two)){
                        return 0;
                    }
                    else if (one instanceof Animal){
                        return 1;
                    }
                    return -1;
                }
                return expressionY;
            }
            return expressionX;
    }
}
