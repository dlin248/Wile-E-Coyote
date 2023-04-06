import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.grid.Location;

/**I love geology!
 * @author Darren Lin
 * @since 4 - 6 - 2023
 */
 
public class Stone extends Rock
{
	private int lifetime;
	private final int THRESHOLD = 3;
	
	public Stone()
	{
		setColor(null);
		lifetime = (int)(Math.random()*200 + 1);
	}
	
	public Stone(int num)
	{
		setColor(null);
		lifetime = num;
	}
	
	public void act()
	{
		if(lifetime < THRESHOLD)
			setColor(Color.GREEN);
		if(lifetime == 0)
		{
			Location oldLoc = getLocation();
			Boulder b = new Boulder();
			b.putSelfInGrid(getGrid(),oldLoc);
			//removeSelfFromGrid();
		}
		lifetime--;
	}
}

