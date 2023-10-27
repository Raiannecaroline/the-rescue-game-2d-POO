import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Boss1 extends Personagem {

    public int vida = 1;

    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    private int DropInimigo = Greenfoot.getRandomNumber(10);
    private Personagem animacao;
    private List<DisparoPlayer> disparosSofridos;

    public Boss1() {

        super("boss-cenario-1/boss-cenario", ".png", 30, 0, 3, 0);

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
                Greenfoot.setWorld(new Mundo2());
            }
        }

    }

    private void disparoInimigo() {
        int latencia = Greenfoot.getRandomNumber(300);
         int direcaoTiro = Greenfoot.getRandomNumber(150)*-1;


        AtaqueBoss1 atacar = new AtaqueBoss1();

        if (latencia == 5) {
             atacar.playSomDisparo();
            getWorld().addObject(atacar, getX(), getY());
            atacar.setRotation(direcaoTiro);
        }
    }

    private void movimentacao() {
        // UsarAnimacao();

       if(getX() >350){
           move(-3);
       }


            // ataca();


    }







}
