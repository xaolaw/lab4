package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String [] args){
        MoveDirection[] toReturn=new MoveDirection[args.length];
        int indeks=0;
        for (int i=0;i< args.length;i++){
            switch (args[i]) {
                case "f", "forward" -> toReturn[i - indeks] = MoveDirection.FORWARD;
                case "b", "backward" -> toReturn[i - indeks] = MoveDirection.BACKWARD;
                case "l", "left" -> toReturn[i - indeks] = MoveDirection.LEFT;
                case "r", "right" -> toReturn[i - indeks] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException("Cannot understand this move " + args[i]);
            }
            }
        return toReturn;
        }
}
