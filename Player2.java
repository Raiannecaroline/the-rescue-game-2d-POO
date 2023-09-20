import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    public int proximoPasso = 6;
    
    
    
    
    /**
     * Act - do whatever the Gato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        setImage(new GreenfootImage("player/player-2-"+proximoPasso+".png"));
    
        proximoPasso++;
        if(proximoPasso > 10){
            proximoPasso = 6;
        }
    } 
    
}
