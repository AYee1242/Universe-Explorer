import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int score = 0;
    private int increase = 1;
    private boolean counter = true;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("score: " + score,25, Color.GREEN, new Color (0,0,0,0)));
        if (counter == true)
        {
            score += increase;
            counter = false;
        }
        else {
            counter = true;
        }
    }    
    public void increase()
    {
        score += 50;
    }
    public void dead()
    {
        increase = 0;
    }
    public int score()
    {
        return score;
    }
}
