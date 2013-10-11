import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Trail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trail extends Actor
{
    public Trail(int width, int height, Color color)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.setTransparency(100);
        image.fillRect(0, 0, width, height);
        setImage(image);
    }

    /**
     * Act - do whatever the Trail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int alpha = getImage().getTransparency();
        if (alpha > 2)
        {
            getImage().setTransparency(alpha - 2);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    
}
