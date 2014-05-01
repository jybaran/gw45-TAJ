import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int turncount;

    public ZBug(int length)
    {
	steps = 0;
        sideLength = length;
	turncount = length * 3;
	this.setDirection(90);
    }

    public void act()
    {
	    
        if(steps < sideLength && canMove() && turncount > 0)
        {
	    move();
            steps++;
	    turncount = turncount -1;
        }
	else if(steps == sideLength && canMove() && turncount > 0){
	    steps = 0;
	    if (this.getDirection() == 90){
		this.setDirection(225);
	    }
	    else if(this.getDirection() == 225){
		this.setDirection(90);
	    }
	}
	    
       
    }
}
