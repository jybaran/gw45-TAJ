// JENNY BARAN
// APCS2 pd 9
// HW34
// 2014-04-29

/**
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
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>BlusterCritter</code> is a critter that looks at all neighbors within
 * two steps of its location and compares the number to its courage value
 * to determine whether to set its color brighter or darker.
 */
public class BlusterCritter extends Critter {

    private int courageFactor;

    public BlusterCritter( int c ) {
	super();
	courageFactor = c;
    }

    /**
     * gets actors for processing, must be contained in same grid.
     * implemented to return actors within two steps of blustercritter.
     * @return a list of actors that are neighbors of this critter.
     */
    public ArrayList<Actor> getActors() {
	ArrayList<Actor> actors = new ArrayList<Actor>();
	
	Location loc = getLocation();
	for ( int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ ) {
	    for (int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++ ) {
		Location tempLoc = new Locations(r, c);
		if ( gertGrid().isValid(tempLoc) ) {
		    Actor a = getGrid().get(tempLoc);
		    if ( a != null && a != this ) {
			actors.add(a);
		    }
		}
	    }
	}
	return actors;
    }
    
    /**
     * processes actors. counts actors within 2 locs of the critter. if fewer than courageFactor,
     * critter brightens. otherwise, it darkens.
     * precond: all objs in actors are in same grid as this critter.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors) {
	int count = 0;
	for (Actor a : actors) {
            if (a instanceof Critter) {
		count++;
	    }
	    if (count < courageFactor) {
		lighten();
	    }
	    else {
		darken();
	    }
        }
    }

    /**
     * darkens critter's color
     */
    private void darket() {
	Color c = getColor();
	int red = c.getRed();
	int green = c.getGreen();
	int blue = c.getBlue();

	if (red > 1) red = red -2;
	if (green > 1) green = green -2;
	if (blue > 1) blue = blue -2;
	
	setColor(new Color(red, green, blue));
    }

    private void lighten() {
	Color c = getColor();
	int red = c.getRed();
	int green = c.getGreen();
	int blue = c.getBlue();

	if (red < 254) red = red +2;
	if (green < 254) green = green +2;
	if (blue < 254) blue = blue +2;

	setColor(new Color(red, green, blue));
    }
}