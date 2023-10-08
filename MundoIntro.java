import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoIntro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoIntro extends World
{
    public static int timer = 500;
    static GreenfootSound mundoIntro = new GreenfootSound("intro-tema.mp3");
    /**
     * Constructor for objects of class MundoIntro.
     * 
     */
    public MundoIntro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1); 
        mundoIntro.play();
    }
    
    public void act() {
        if (timer > 400) {
            setBackground(new GreenfootImage("intro_1.png"));
        }
        timer--;
        if (timer == 0) {
            Greenfoot.setWorld(new Mundo1());
        }
    }
}
