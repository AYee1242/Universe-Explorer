import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid2 extends Actor
{
    private int speed = 3;
    private int speed2 = 1;
    private int direction = Greenfoot.getRandomNumber(4) - 2;
    private int direction2 = direction;
    private boolean end = false;
    private boolean explosion = false;
    private boolean upgradeChange = false;
    private int randomDrop = 3;
    private int delay = 0;
    private int frame = 0;
    private boolean inPlace = true;
    private boolean animate = false;
    private GreenfootImage ast = new GreenfootImage("asteroids.png");
    private GreenfootImage explosion1 = new GreenfootImage("explosion1.png");
    private GreenfootImage explosion2 = new GreenfootImage("explosion2.png");
    private GreenfootImage explosion3 = new GreenfootImage("explosion3.png");
    private GreenfootImage explosion4 = new GreenfootImage("explosion4.png");
    private GreenfootImage explosion5 = new GreenfootImage("explosion5.png");
    
    public Asteroid2()
    {
        getImage().setTransparency(0);
        getImage().scale(50,50);
    }
    public void act() 
    {
        moves();
        destroy();
        delay();
        laserDestroyed();
        animation();
    }    
    public void moves()
    {   
       if (speed > 15)
       {
           speed = 15;
       }
       setLocation (getX()-speed,getY()+direction);
       turn(direction);
       if (getY() == 0) 
       {
           direction = -1 * (direction); 
       }
       if (getY() > 395)
       {
           direction = -1 * (direction); 
       }
       if (getX() < 5)
       {    
           destroyed();
       }
    }
    public void destroy()
    {
        Actor rocket;
        rocket = getOneObjectAtOffset(0,0,Rocket.class);
        if (rocket != null && end == true)
        {
            World world;
            world = getWorld();
            world.removeObject(rocket);
            Object obj=world.getObjects(Counter.class).get(0);
            Counter counter=(Counter) obj;
            counter.dead();
            Greenfoot.setWorld (new End(counter.score()));
        }
    }
    public void destroyed()
    {   
        getImage().setTransparency(0);
        end = false;
        if (Greenfoot.getRandomNumber(50) == 1)
        {
          end = true;
          explosion = true;
          getImage().setTransparency(250);
          speed += Greenfoot.getRandomNumber(3);
          direction += 1;
          setLocation (1000, Greenfoot.getRandomNumber(300)+50);
        }
    }
    public void laserDestroyed()
    {
       Actor laser2;
       laser2= getOneIntersectingObject(Laser.class);
       if (laser2 != null && explosion == true)
       {
           /*GreenfootSound song = new GreenfootSound ( "Explosion1.wav" );
           song.setVolume(80);
           song.play();*/
           animate = true;
           explosion = false;
           getWorld().removeObject(laser2);
           Object obj=getWorld().getObjects(Counter.class).get(0);
           Counter counter=(Counter) obj;
           counter.increase();
           if (Greenfoot.getRandomNumber(randomDrop) == 0)
           {
              Upgrade upgrade = new Upgrade();   
              getWorld().addObject (upgrade,getX(),getY());
           }
           destroyed();
       }
    }
    public void upgradeChange()
    {
        upgradeChange = true;
    }
    public void delay()
    {
        if (upgradeChange == true)
        {
            randomDrop = 30;
            delay ++;
            if (delay == 500)
            {   
                delay = 0;
                randomDrop = 4;
                upgradeChange = false;
            }
        }
    }
    public void animation()
    {
        if (animate == true)
        {
            if (inPlace == true)
            {
                speed2 = speed;
                speed = 0;
                direction2 = direction;
                direction = 0;
                inPlace = false;
            }
            if (frame < 5)
            {
                setImage(explosion1);
                frame ++;
            }
            else if (frame < 10)
            {
                setImage(explosion2);
                frame ++;
            }
            else if (frame < 15)
            {
                setImage(explosion3);
                frame ++;
            }
            else if (frame < 20)
            {
                setImage(explosion4);
                frame ++;
            }
            else if (frame < 25)
            {
                setImage(explosion5);
                frame ++;
            }
            else
            {   
                frame = 1;
                setImage(ast);
                getImage().setTransparency(0);
                getImage().scale(50,50);
                speed = speed2;
                direction = direction2;
                animate = false;
                inPlace = true;
            }
        }
    }
}

