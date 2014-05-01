// JENNY BARAN
// APCS2 pd 9
// HW34
// 2014-04-29

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
 * A ChameleonCritter takes on the color of neighboring actors as it moves through the grid.
 * The implementation of this class is testable on the AP CS A and AB Exams.
 */
public class ChameleonCritter extends Critter {
    /**
     * Randomly selects a neighbor and changes this critter’s color to be the same as that neighbor’s.
     * If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors) {
	int n = actors.size();
	if (n == 0) {
	    darken();
	    return;
	}
	int r = (int) (Math.random()  * n);
	Actor other = actors.get(r);
	setColor(other.getColor());
    }
    /**
     * Turns towards the new location as it moves. 
     */
    public void makeMove(Location loc)
    {
	setDirection(getLocation().getDirectionToward(loc));
	super.makeMove(loc);
    }
    /**
     * darkens color
     */
    public void darken() {
	Color c = getColor();
	int red = (int)(c.getRed() * .95);
	int green = (int)(c.getGreen() * .95);
	int blue = (int)(c.getBlue() * .95);
	setColor( new Color(red, green, blue) );
    }
}