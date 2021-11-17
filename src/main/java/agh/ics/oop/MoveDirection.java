package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    LEFT,
    RIGHT;
    public void toString(MoveDirection[] that) {
        for (MoveDirection moveDirection : that) {
            System.out.print(moveDirection);
        }
    }
}
