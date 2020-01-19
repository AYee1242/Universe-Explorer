import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer = 20;
    private String laser = "laser";
    private boolean gun = false;
    private boolean rapidGun = false;
    private int timerUpgrade = -1;
    private int timerUpgrade2 = -1;
    
    private GreenfootImage move1 = new GreenfootImage("spaceship0.gif");
    private GreenfootImage move2 = new GreenfootImage("spaceship1.gif");
    private GreenfootImage move3 = new GreenfootImage("spaceship2.gif");
    private boolean picture = false;
    private boolean picture2 = false;
    private boolean picture3 = false;
    private int frame = 1;
    public void act() 
    {
        anime();
        move();
        shoot();
    }    
    public void move(){
        timer += 1;
        if (Greenfoot.isKeyDown("Left"))
        {
            move(-8);
        }
        if (Greenfoot.isKeyDown("Right"))
        {
            move(8);
        }
        if (Greenfoot.isKeyDown("Up"))
        {
            setLocation(getX(),getY()-8);
        }
        if (Greenfoot.isKeyDown("Down"))
        {
            setLocation(getX(),getY()+8);
        }
    }
     public void anime()
    {
        if (frame < 5)
        {
            if (picture3 == true)
            {
                setLocation (getX()-1,getY()-5);
                picture3 = false;
            }
            setImage(move1);
            picture = true;
            frame ++;
        }
        else if (frame < 20)
        {
            if (picture == true)
            {
                setLocation(getX(),getY()+3);
                picture = false;
                picture2 = true;
            }
            setImage(move2);
            frame ++;
        }
        else if (frame < 30)
        {
            if (picture2 == true)
            {
                setLocation(getX()+1,getY()+2);
                picture2 = false;
                picture3 = true;
            }
            setImage(move3);
            frame ++;
        }
        else {
            frame = 1;
        }
    }
    public void shoot()
    {
        if (Greenfoot.isKeyDown("q") && timer > 10 &&  timerUpgrade != -1 && timerUpgrade2 != -1 && timerUpgrade < 60 && timerUpgrade2 < 60)
        {
            shootUpgradeSplit();
            timerUpgrade += 4;
            timerUpgrade2 += 4;
        }
        else if (Greenfoot.isKeyDown("q") && timer > 30 && timerUpgrade != -1 && timerUpgrade < 60)
        {
            shootUpgradeSplit();
            timerUpgrade += 6;
        }
        else if (Greenfoot.isKeyDown("q") && timer > 10 && timerUpgrade2 != -1 && timerUpgrade2 < 60)
        {
            shootNormal();
            timerUpgrade2 += 2;
        }
        else if (Greenfoot.isKeyDown("q") && timer > 30)
        {
            shootNormal();
        }
    }
    public void shootUpgradeSplit()
    {
        Laser laser = new Laser();
        if (timerUpgrade < 60 && timerUpgrade != -1 && timerUpgrade2 < 60 && timerUpgrade2 != -1)
        {
            laser.setImage("Orange laser.png");
            laser.getImage().scale(30,10);
        }
        else
        {
            laser.setImage("Blue laser.png");
            laser.getImage().scale(30,30);
        }
        getWorld().addObject(laser,getX()+66,getY()-20);
        Laser laser2 = new Laser();
        if (timerUpgrade < 60 && timerUpgrade != -1 && timerUpgrade2 < 60 && timerUpgrade2 != -1)
        {
            laser2.setImage("Orange laser.png");
            laser2.getImage().scale(30,10);
        }
        else
        {
            laser2.setImage("Blue laser.png");
            laser2.getImage().scale(30,30);
        }
        getWorld().addObject(laser2,getX()+66,getY()+20);
        timer = 0;
    }
    public void shootNormal()
    {
        Laser laser = new Laser();
        if (timerUpgrade2 < 60 && timerUpgrade2 != -1)
        {
            laser.setImage("Green laser.png");
        }
        else
        {
            laser.setImage("laser.png");
        }
        laser.getImage().scale(30,30);
        getWorld().addObject(laser,getX()+66,getY());
        timer = 0;
    }
    public void doubleGuns()
    {
        timerUpgrade = 0;
    }
    public void rapidFire()
    {
        timerUpgrade2 = 0;
    }
}
