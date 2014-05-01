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
 * @author Cay Horstmann
 */

package info.gridworld.actor;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location; 

import java.awt.Color;

/**
 * A <code>Jumper</code> is an actor that can move and turn. It moves two cells at a time. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Jumper extends Actor
{
    /**
     * Constructs a blue jumper.
     */
    public Jumper()
    {
        setColor(Color.BLUE);
    }

    /**
     * Constructs a jumper of a given color.
     * @param jumpColor the color for this jumper
     */
    public Jumper(Color jumpColor)
    {
        setColor(jumpColor);
    }

    //moves jumper forward two locations, must be valid or jumper will remove self from grid
    public void jump() {
	Grid<Actor> gr = getGrid();
	if ( gr == null ) {
	    return;
	}
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	if (gr.isValid(twoAway)) {
	    moveTo(twoAway);
	}
	else {
	    removeSelfFromGrid();
	}
    }

    public boolean canJump() {
	Grid<Actor> gr = getGrid();
	if (gr == null) {
	    return false;
	}
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	if (!gr.isValid(next)) {
	    return false;
	}
	Actor neighbor = gr.get(next);
	if (!((neighbor == null) || (neighbor instanceof Flower)
	      || (neighbor instanceof Rock))) {
	    return false;
	}
	Location twoAway = next.getAdjacentLocation(getDirection());
	if (!gr.isValid(twoAway)) {
	    return false;
	}
	neighbor = gr.get(twoAway);
	return (neighbor = null) || (neighbor instanceof Flower);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }

    /**
     * Turns the jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the jumper forward.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }
    
}
