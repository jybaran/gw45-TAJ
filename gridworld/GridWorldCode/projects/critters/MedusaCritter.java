package info.gridworld.actor;
import info.gridworld.actor.Actor; 
import info.gridworld.actor.Critter; 
import info.gridworld.grid.Location; 
import java.util.ArrayList; 


public class MedusaCritter extends Critter {
    
    //public MedusaCritter(){
	
    //}
    
    public ArrayList<Actor> getActors()
    {
	ArrayList<Actor> greg = new ArrayList<Actor>();
        greg.add(getGrid().get(getLocation().getAdjacentLocation(getDirection())));
	return greg;
	
    }

    public void processActors(ArrayList<Actor> actors){
  
        Actor a = actors.get(0);
	if (!(a instanceof Rock) && !(a instanceof Critter)){
	    
	    Rock c = new Rock();
	    getGrid().put(a.getLocation(), c);}
    }
	
        
} 
