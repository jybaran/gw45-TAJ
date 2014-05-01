import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

/**
* This class runs a world that contains a jumper, a bug, a flower, and a
* rock added at random locations.
*/

public class JumperRunner {
    public static void main(String[] args) {
	ActorWorld world = new ActorWorld();
	world.add(new Jumper());
	world.add(new Rock());
	world.add(new Bug());
	world.add(new Flower());
	world.show();
    }//end main
}//end class JumperRunner
