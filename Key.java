import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;

/**
 * A key on a piano keyboard. This key has a pair of images to show a normal
 * and depressed state, and it is associated with a keyboard key and a sound
 * file, which is played when the key is pressed.
 * 
 * @author: M. Kolling
 * @version: 1.0
 */
public class Key extends Actor
{
    private boolean isDown;
    private String key;
    private String sound;
    private String upImage;
    private String downImage;
    private Visualizer screen;
    private Color shapeColor;

    /**
     * Create a new key linked to a given keyboard key, and
     * with a given sound.
     */
    public Key(String keyName, String soundFile, String img1, String img2)
    {
        sound = soundFile;
        key = keyName;
        upImage = img1;
        downImage = img2;
        setImage(upImage);
        isDown = false;  
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        if (!isDown && Greenfoot.isKeyDown(key)) {
            play();
            setImage(downImage);
            isDown = true;
        }
        if (isDown && !Greenfoot.isKeyDown(key)) {
            setImage(upImage);
            isDown = false;
        }
        if (Greenfoot.mousePressed(this))
        {
            play();
            setImage(downImage);
        }
        if (Greenfoot.mouseClicked(null))
        {
            setImage(upImage);
        }
    }

    /**
     * Play the note of this key.
     */
    public void play()
    {
        Greenfoot.playSound(sound);
        if (screen != null)
        {
            screen.visualize(this);
        }
    }
    
    public void setColor(Color newColor)
    {
        shapeColor = newColor;
    }
    
    public Color getColor()
    {
        return shapeColor;
    }
    
    /**
     * Sets a new Visualizer to use.
     *
     * @param visualizer The new Visualizer to use.
     */
    public void setVisualizer(Visualizer visualizer)
    {
        screen = visualizer;
    }
}
