import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Actor
{
    int count = 0;
    public Rectangle(int width, int height, Color color)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.setTransparency(0);
        image.fillRect(0, 0, width, height);
        setImage(image);
    }

    /**
     * Act - do whatever the Rectangle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int alpha = getImage().getTransparency();
        if (getY() >= getImage().getHeight()/2)
        {
            //getImage().setTransparency(alpha - 2);
            makeTrail();
        }
        else
        {
            getWorld().removeObject(this);
        }
        if(getRotation() != 90)
        {
            setRotation(90);
        }
        move(-2);
        getImage().setColor(colorGrade(getImage().getColor()));
    }

    /**
     * To make a trail of fading rectangles behind this one.
     */
    private void makeTrail()
    {
        getWorld().addObject(new Trail(getImage().getWidth(), getImage().getHeight(), getImage().getColor()), this.getX(), this.getY());
    }

    /**
     * To delay colorChange
     */
    private Color colorGrade(Color color)
    {
        if(count >= 3)
        {
            count = 0;
            return colorChange(color);
        }
        else
        {
            count++;
            return color;
        }
    }

    /**
     * To change the color of the rectangle as it moves upward.
     */
    private Color colorChange(Color color)
    {
        if(color == Color.BLUE)
        {
            return Color.CYAN;
        }
        else if(color == Color.CYAN)
        {
            return Color.GREEN;
        }
        else if(color == Color.GREEN)
        {
            return Color.YELLOW;
        }
        else if(color == Color.YELLOW)
        {
            return Color.ORANGE;
        }
        else if(color == Color.ORANGE)
        {
            return Color.RED;
        }
        else if(color == Color.RED)
        {
            return Color.PINK;
        }
        else if(color == Color.PINK)
        {
            return Color.MAGENTA;
        }
        else if(color == Color.MAGENTA)
        {
            return Color.BLUE;
        }
        else
        {
            return Color.BLUE;
        }
    }
}
