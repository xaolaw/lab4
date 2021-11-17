package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String [] args){
        MoveDirection[] toReturn=new MoveDirection[args.length];
        int indeks=0;
        for (int i=0;i< args.length;i++){
                if (args[i]=="f" || args[i]=="forward") {
                    toReturn[i-indeks]=MoveDirection.FORWARD;
                }
                else if(args[i]=="b" || args[i]=="backward") {
                    toReturn[i-indeks]=MoveDirection.BACKWARD;
                }
                else if(args[i]=="l" || args[i]=="left") {
                    toReturn[i-indeks]=MoveDirection.LEFT;
                }
                else if(args[i]=="r" || args[i]=="right") {
                    toReturn[i-indeks] = MoveDirection.RIGHT;
                }
                else {
                    indeks+=1;
                }
            }
        return toReturn;
        }
}
