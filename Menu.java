import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
<<<<<<< HEAD
 *
 * @author (your name)
=======
 * 
 * @author (your name) 
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private int tela = 1;
    /**
     * Constructor for objects of class Menu.
<<<<<<< HEAD
     *
     */
    public Menu()
    {
=======
     * 
     */
    public Menu()
    {    
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 390, 1);
        setBackground("menu_0"+tela+".png");
        MundoIntro.timer = 500;
    }
    public void act(){
        String key = Greenfoot.getKey();
        if(("s".equals(key) || "down".equals(key))){
            if(tela == 3){tela = 1;}
            else{tela++;}
            setBackground("menu_0"+tela+".png");
        }
        if(("w".equals(key) || "down".equals(key))){
            if(tela == 1){tela = 3;}
            else{tela--;}
            setBackground("menu_0"+tela+".png");
        }
<<<<<<< HEAD

        if("enter".equals(key)){
            switch(tela){
                case 1:Greenfoot.setWorld(new MundoIntro());break;
                case 2:Greenfoot.setWorld(new Creditos());    break;
                case 3:Greenfoot.stop();                      break;
            }
        }
=======
        
        if("enter".equals(key)){
            switch(tela){
                case 1:Greenfoot.setWorld(new MundoIntro());break;
                case 2:Greenfoot.setWorld(new Creditos());    break;                
                case 3:Greenfoot.stop();                      break;
            }
        }   
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
    }
}
