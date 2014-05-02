/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter {
    public QuickCrab()
    {
        setColor(Color.CYAN);
    }

    /**
     * @return list of empty locations two to left/right
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();

	addIfGoodTwoAwayMove(locs, getDirection() + Location.LEFT);
	addIfGoodTwoAwayMove(locs, getDirection() + Location.RIGHT);

	if (locs.size() == 0) {
	    return super.getMoveLocations();
	}

        return locs;
    }
    private void addIfGoodTwoAwayMove(ArrayList<Location> locs,int dir)
    {
	Grid g = getGrid();
	Location loc = getLocation();
	Location temp = loc.getAdjacentLocation(dir);
	if(g.isValid(temp) && g.get(temp) == null)
	    {
		Location loc2 = temp.getAdjacentLocation(dir);
		if(g.isValid(loc2) && g.get(loc2)== null)
		    locs.add(loc2);
	    }
    } 
}
