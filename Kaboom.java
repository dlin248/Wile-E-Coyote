import info.gridworld.actor.Actor;
/**
 * Kaboom is a part of the Wile E Coyote world. It kills anything around it
 * @author Darren Lin
 * @since 4 - 6 - 2023
 * */

public class Kaboom extends Actor
{
	private int lifetime;
	private final int BOOM = 3;
	
	public Kaboom()
	{
		setColor(null);
		lifetime = BOOM;
	}
	public void act()
	{
		if(lifetime == 0)
			removeSelfFromGrid();
		lifetime--;
	}
}
