import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String word;
    public int size;
    public int type;
    public Text(String word, int size, int type) 
    {
        this.word = word;
        this.size = size;
        this.type = type;
        setImage(new GreenfootImage(word, size, Color.ORANGE, new Color (0,0,0,0)));
    }    
    public void act()
    {
        
        if (Greenfoot.mouseClicked (this) && type == 2)
        {
            Greenfoot.setWorld (new MainWorld());
        }
        else if (Greenfoot.mouseClicked (this) && type == 3)
        {
            Greenfoot.setWorld (new Instructions());
        }
        else if (Greenfoot.mouseClicked (this) && type == 4)
        {
            Greenfoot.setWorld (new Title());
        }
    }
}
