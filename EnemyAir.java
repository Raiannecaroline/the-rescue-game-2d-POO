import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EnemyAir extends Personagem {

    public int vida = 10;

    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    private int DropInimigo = Greenfoot.getRandomNumber(10);
    private Personagem animacao;
    private List<DisparoPlayer> disparosSofridos;

    public EnemyAir() {

        super("inimigo-aereo/inimigo", ".png", 5, 0, 1, 0);

    }


    public void act() {
        super.act();

        movimentacao();
        disparoInimigo();
        morte();

    }

    private void morte() {
        if (isTouching(DisparoPlayer.class)) {
            removeTouching(DisparoPlayer.class);
            vida--;
            if (vida == 0) {
                getWorld().removeObject(this);
                Sound morte = new Sound("morteenemy.wav");
                morte.play();
            }
        }
    }

    private void disparoInimigo() {
        int latencia = Greenfoot.getRandomNumber(60);

        DisparoEnemy ataque = new DisparoEnemy();
       
        if (latencia == 1) {
             ataque.playSomDisparo();
            getWorld().addObject(ataque, getX(), getY());
            ataque.setRotation(-90);
        }
    }

    private void movimentacao() {
        // UsarAnimacao();

       if(getX() >50){
           move(-3);
       }
            // ataca();
       

    }

    


   

   
}
