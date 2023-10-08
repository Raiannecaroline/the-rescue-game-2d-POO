import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{

    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1);
        setBackground("autores.png");
    }
    public void act(){
        String key = Greenfoot.getKey();
        if ("enter".equals(key)){
            Greenfoot.setWorld(new Menu());
        }
    }
}
