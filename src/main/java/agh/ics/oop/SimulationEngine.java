package agh.ics.oop;

class SimulationEngine  implements IEngine{
    private IWorldMap engine_map;
    private MoveDirection [] moves;
    private Vector2d [] Positions;
    public SimulationEngine(MoveDirection [] t_move,IWorldMap map,Vector2d [] t_vec){
        this.engine_map=map;
        for (Vector2d vec : t_vec){
            Animal animal = new Animal(map,vec);
            map.place(animal);
            animal.addObserver((IPositionChangeObserver) map);
        }
        this.moves=t_move;
        this.Positions=t_vec;
        System.out.println(this.engine_map);
    }
    @Override
    public void run() {
        int i=0;
        for (MoveDirection m : this.moves){
            Animal animal = (Animal) engine_map.objectAt(Positions[i%Positions.length]);
            Vector2d oldPosition = animal.getPosition();
            animal.move(m);
            animal.positionChanged(oldPosition, animal.getPosition());
            Positions[i%Positions.length]=animal.getPosition();
            i+=1;
            System.out.println(this.engine_map);
        }
    }
}
