import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AtaqueInimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtaqueInimigo extends Enemy
{
      private int alcance = Greenfoot.getRandomNumber(10)+30;
    private int dano =1;
    public int latencia = Greenfoot.getRandomNumber(100);
   
    public void act()
    {
       
       atirando();
        }
        public void atirando(){
             move(-15);
             alcance--;
        
        if(alcance==0 || isAtEdge()|| isTouching(Player.class)){
            getWorld().removeObject(this);
        
}
        
}

}
