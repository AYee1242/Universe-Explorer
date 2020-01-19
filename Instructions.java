import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        prepare();
        addStars(200);
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Text instruction = new Text ("Destroy as many asteroids as possible ", 40 ,  1);
        addObject(instruction,500,20);
        Text instruction2 = new Text ("while you traverse throughout the universe!", 40, 1);
        addObject(instruction2,500,50);
        Text controls = new Text ("Controls", 40, 1);
        addObject (controls,500,100);
        Text shoot = new Text ("Shoot:                   q", 40, 1);
        addObject (shoot,500,150);
        Text moveUp = new Text ("Move Up:           Arrow Up", 40, 1);
        addObject (moveUp,500,200);
        Text moveDown = new Text ("Move Down:           Arrow Down", 40, 1);
        addObject (moveDown,500,250);
        Text moveRight = new Text ("Move Right:           Arrow Right", 40, 1);
        addObject (moveRight,500,300);
        Text moveLeft = new Text ("Move Left:           Arrow Left", 40, 1);
        addObject (moveLeft,500,350);
        Text back = new Text ("Back", 40, 4);
        addObject (back,920,350);
    }

    private void addStars (int numStars)
    {
        for (int i = 0; i<numStars; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Star(),x,y);
        }
    }
}
