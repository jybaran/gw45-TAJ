import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * A ChameleonKid takes on the color of neighboring actors in front/back of it as it moves through the grid.
 */
public class ChameleonKid extends ChameleonCritter {
    /**
     * Gets actors for processing.
     */
    public ArrayList<Actor> getActors() {
	ArrayList<Actor> actors = new ArrayList<Actor>();
	int[] dirs = { Location.AHEAD, Location.HALF_CIRCLE };
	for (Location loc: getLocationsInDirections(dirs)) {
	    Actor a = getGrid().get(loc);
	    if (a != null) {
		actors.add(a);
	    }
	}
	return actors;
    }
    
    /**
     * Finds valid adj locs of this critter
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions) {
	ArrayList<Location> locs = new ArrayList<Location>();
	Grid gr = getGrid();
	Location loc = getLocation();
	for (int d : directions) {
	    Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	    if (gr.isValid(neighborLoc)) {
		locs.add(neighborLoc);
	    }
	}
	return locs;
    }
}//end class ChameleonKid
