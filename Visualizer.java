import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Visualizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Visualizer extends Actor
{
    private GreenfootImage image;
    Color transGray = new Color(5, 5, 5, 200);

    public Visualizer()
    {
        image = new GreenfootImage(800, 340);
        image.setColor(transGray);
        image.fill();
        setImage(image);
    }

    /**
     * Act - do whatever the Visualizer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * To make imagery when piano is played
     * 
     * @param k - the key played
     */
    public void visualize(Key k)
    {
        // Following is the visualization code
        int width = k.getImage().getWidth();
        int x = k.getX();
        int drawHeight = image.getHeight() - width / 2;
        int y = image.getHeight() - width / 2;
        Color color = k.getColor();
        Rectangle shape = new Rectangle(width, width, color);
        getWorld().addObject(shape, x, y);
    }
}