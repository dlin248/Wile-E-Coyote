import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;

public class CoyoteRunner
{
    public static void main(String[] args)
    {
        BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(20,20);
        ActorWorld world = new ActorWorld(mygrid);
        world.add(new Location(3,3), new Coyote());
        world.add(new Location(7,2), new Coyote());
        world.show();
    }
}
