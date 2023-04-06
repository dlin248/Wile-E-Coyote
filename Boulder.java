import info.gridworld.actor.Actor;
import java.awt.Color;
import info.gridworld.grid.Location;
/**
 * The boulder is just a little less boring than a rock. But it looks cool
 * @author Darren Lin
 * @since 4 - 6 - 2023
 */

public class Boulder extends Actor
{
	private int lifetime;
	private final int THRESHOLD = 3;
	
	public Boulder()
	{
		setColor(null);
		lifetime = (int)(Math.random()*200 + 1);
	}
	
	public Boulder(int life)
	{
		setColor(null);
		lifetime = life;
	}
	
	public void act()
	{
		if(lifetime < THRESHOLD)
			setColor(Color.RED);
		if(lifetime == 0)
		{
			Location loc = getLocation();
			Kaboom kb = new Kaboom();
			kb.putSelfInGrid(getGrid(),loc);
			//removeSelfFromGrid();
		}
		lifetime--;
	}
}
