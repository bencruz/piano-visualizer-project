import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Oval here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oval extends Actor
{
    /**
     * Oval Constructor
     *
     * @param width  The width of the oval.
     * @param height  The height of the oval.
     * @param color  The color of the oval.
     */
    public Oval(int width, int height, Color color)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.fillOval(0, 0, width, height);
        setImage(image);
    }

    /**
     * Act - do whatever the Oval wants to do. This method is called whenever
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
