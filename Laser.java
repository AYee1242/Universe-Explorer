import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    private boolean shot = false;
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean stop = false;
    public void act() 
    {
        move();
    }    
    public void move()
    {
        move(8);
        if (getX() > 995)
        {
            World world;
            world = getWorld();
            world.removeObject(this);
        }
    }
}
