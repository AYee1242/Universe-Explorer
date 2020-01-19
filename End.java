import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{

    /**
     * Constructor for objects of class End.
     * 
     */
    private String score;
    public End(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 400, 1); 
        this.score = String.valueOf(score);
        addStars(200);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Text title = new Text ("Game Over", 100 , 1);
        addObject(title,500,150);
        Text scores = new Text ("Score: " + this.score, 50, 1);
        addObject (scores,500,250);
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
