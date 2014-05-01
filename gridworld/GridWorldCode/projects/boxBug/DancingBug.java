import info.gridworld.actor.Bug;


public class DancingBug extends Bug
{
    private int[] dance;
    private int count = 0;


    public DancingBug(int[] a)
    {
        dance = a;
    }


    public void act()
    {
	this.setDirection(this.getDirection() + dance[count]*45);
    count ++;
    count = count%dance.length;
    if (canMove()){
       this.move();
    }
    else{
	this.turn();
	}
}
}
