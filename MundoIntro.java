import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoIntro here.
<<<<<<< HEAD
 *
 * @author (your name)
=======
 * 
 * @author (your name) 
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
 * @version (a version number or a date)
 */
public class MundoIntro extends World
{
    public static int timer = 500;
    static GreenfootSound mundoIntro = new GreenfootSound("intro-tema.mp3");
    /**
     * Constructor for objects of class MundoIntro.
<<<<<<< HEAD
     *
     */
    public MundoIntro()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1);
        //mundoIntro.play(); 
    }

=======
     * 
     */
    public MundoIntro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1); 
        mundoIntro.play();
    }
    
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
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
