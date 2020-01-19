import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    public MainWorld()
    {    

        super(1000, 475, 1); 
        prepare();
        addStars(200);
        addAsteroid(10);
        
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private void addStars (int numStars)
    {
        for (int i = 0; i<numStars; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Star(),x,y);
        }
    }
    private void addAsteroid (int numAsteroids)
    {
        for (int i = 0; i<numAsteroids; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Asteroid2(),x,y);
        }
    }
    private void prepare()
    {
 
        Rocket rocket = new Rocket();
        addObject(rocket,84,224);

        Counter counter = new Counter();
        addObject(counter,900,20);
        counter.getImage().scale(1,1);
        
    }
    private void endScreen()
    {
        int num= 0;
    }
}
