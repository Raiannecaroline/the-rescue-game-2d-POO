import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    public GameOver(){    
        super(700, 390, 1); 
        setBackground("game_over_0.png");
    
    }
    public void act(){
        String key = Greenfoot.getKey();
        if("escape".equals(key)){
            Greenfoot.setWorld(new Menu());
        }
    }
}
