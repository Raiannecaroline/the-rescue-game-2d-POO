import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiro extends Actor
{
    private int alcance = Greenfoot.getRandomNumber(10)+30;
    public void act()
    {
        alcance--;
        move(12);
        if(alcance==0 || isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
