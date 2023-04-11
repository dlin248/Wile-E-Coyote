import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.List;
import java.util.ArrayList;

/**
 * woof woof woof
 * wait thats a dog
 * is a coyote a dog???
 * @author Darren Lin
 * @since 4 - 6 - 2023
 */
 
public class Coyote extends Critter
{
	private int steps;
	private boolean end;
	private int sleep;
	public Coyote()
	{
		setColor(null);
		end = false;
		sleep = 0;
		int direction = (int)(Math.random() * 8)*45;
		setDirection(direction);
		steps = 0;
	}
	/**
	 * Overrides the act method in Critter 
	 */
    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        //ArrayList<Location> moveLocs = getMoveLocations();
        //Location loc = selectMoveLocation(moveLocs);
        Location location = getLocation().getAdjacentLocation(getDirection());
        if(end)
        {
			sleep++;
		}
		if(sleep == 5)
		{
			end = false;
			if(getGrid().isValid(location))
			{
				Stone stone = new Stone();
				ArrayList<Location> arrL = getGrid().getEmptyAdjacentLocations(getLocation());
				stone.putSelfInGrid(getGrid(),arrL.get(0));
			}
		}
		if(!end) 
		{
			if(getGrid().isValid(location))
				makeMove(location);
			else
			{
				end = true;
				steps = 0;
			}
		}
    }
    
    
	public void makeMove(Location loc)
	{
		Actor actor = getGrid().get(loc);
		if(actor instanceof Boulder)
		{
			actor.removeSelfFromGrid();
			Kaboom kaboom = new Kaboom();
			kaboom.putSelfInGrid(getGrid(),loc);
			removeSelfFromGrid();
			return;
		}
		else if(actor != null)
		{
			if(steps == 5)
			{
				end = true;
				steps = 0;
			}
			moveTo(loc);
			steps++;
		}
		else
		{
			end = true;
		}
		
	}
}
