package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String [] args){
        MoveDirection[] toReturn=new MoveDirection[args.length];
        int indeks=0;
        for (int i=0;i< args.length;i++){
                if (args[i].equals("f") || args[i].equals("forward")) {
                    toReturn[i-indeks]=MoveDirection.FORWARD;
                }
                else if(args[i].equals("b") || args[i].equals("backward")) {
                    toReturn[i-indeks]=MoveDirection.BACKWARD;
                }
                else if(args[i].equals("l") || args[i].equals("left")) {
                    toReturn[i-indeks]=MoveDirection.LEFT;
                }
                else if(args[i].equals("r") || args[i].equals("right")) {
                    toReturn[i-indeks] = MoveDirection.RIGHT;
                }
                else {
                    indeks+=1;
                }
            }
        return toReturn;
        }
}
