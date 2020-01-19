import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Actor
{
    /**
     * Act - do whatever the Upgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-5);
        Actor rockets;
        rockets = getOneIntersectingObject(Rocket.class);
        if (getX() == 0)
        {   
            getWorld().removeObject(this);
        }
        if (rockets != null)
        {
           for (int i=0; i<10; i++)
           {
               Object obj2 =getWorld().getObjects(Asteroid2.class).get(i);
               Asteroid2 asteroid = (Asteroid2) obj2;
               asteroid.upgradeChange();
           }
           Object obj=getWorld().getObjects(Rocket.class).get(0);
           Rocket rocket =(Rocket) obj;
           int upgradeType = Greenfoot.getRandomNumber(2);
           if (upgradeType == 0)
           {
               rocket.doubleGuns();
           }
           else if (upgradeType == 1)
           {
               rocket.rapidFire();
           }
           getWorld().removeObject(this);
        }
    }
}
