import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
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
        Text title = new Text ("Universe Explorer", 70 , 1);
        addObject(title,500,70);
        Text play = new Text ("Play", 40, 2);
        addObject (play,500,200);
        Text instructions = new Text ("Instructions", 40, 3);
        addObject (instructions, 500, 300);
        GreenfootSound song = new GreenfootSound ( "Background.wav" );
        song.setVolume(80);
        song.playLoop();
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
