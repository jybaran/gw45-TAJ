import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter; 
import info.gridworld.actor.Rock; 
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;


public class MedusaCritter extends Critter {

    public MedusaCritter() {
	setColor(Color.GREEN);
    }
    
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
