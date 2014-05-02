import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter; 
import info.gridworld.actor.Rock; 
import info.gridworld.grid.Location;

import java.util.ArrayList; 


/*****************************************************************
 * NAME TAJ TEAM NAME
 * APCS pd 9
 * HW 35GridWorld, Part 4
 * yyyy-mm-dd
 *
 * class MedusaCritter
 *
 * BEACUASE:
 * It seemed interesting while at the same time not too hard and not too easy.
 *
 * SPECIFICATIONS:
 * -MedusaCritter can turn the actor in front of it into a rock by removing it and spawning a rock object on the location.
-Class MedusaCritter inherits all methods and variables/constants of superclasses Critter and Actor. Below are overwritten methods

-processActors(Actor a){//Overwrites processActors() of superclass Critter
    If the actorâ€™s direction is the direction of the medusaâ€™s + 180 && the actor is directly in front of the medusa (basically, eye contact and one space away), the actor in front will be removed and replaced by a rock UNLESS it is a Critter or Rock
}
-ArrayList<Actor> getActors(){//Overwrites getActors() of superclass Critter
   Only obtains critter directly in front for processing. Dependent on direction of MedusaCritter executing code. Returns ArrayList consisting of all objects one space ahead
}

 *
 * TEST CASES:
 * T1-There is a non-rock-non-critter actor on the tile ahead facing the MedusaCritter: act() will remove that actor and replace it with a rock. The MedusaCritter will then move as specified by the Critter class
T2-There is a non-rock-non-critter actor on the tile ahead but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
T3-There is a non-rock-non-critter actor on the tile to the right but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
T4-There is a rock/critter actor on the tile ahead: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
T5-All other scenarios: MedusaCritter will behave as a normal Critter
 *
 * ERRATA:
 * The beginning of development was done by two individuals who did not have the ability to run gridWorld. By the time the third member was able to run gridWorld it was far into the process and when errors poped up they were unable to correct them due to lack of knowledge of what went on in the first round. Ultimately, instead of adding any test cases we subtracted 5 due to the lack of success. 
 * 
 *****************************************************************/


public class MedusaCritter extends Critter {
    
    public ArrayList<Actor> getActors()
    {
	ArrayList<Actor> greg = new ArrayList<Actor>();
        greg.add(getGrid().get(getLocation().getAdjacentLocation(getDirection())));
	return greg;
	
    }

    public void processActors(ArrayList<Actor> actors) {
  
        Actor a = actors.get(0);
	if (!(a instanceof Rock) && !(a instanceof Critter) && (a.getDirection() == (getDirection() - 180) || (a.getDirection() == (getDirection() + 180)))){
	    
	    Rock c = new Rock();
	    Location loc = a.getLocation();
	    getGrid().remove(loc);
	    getGrid().put(loc, c);}
    }
	
        
} 
