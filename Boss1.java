import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Boss1 extends Personagem {
    private int vidaMaxima = 100;
    private int vidaAtual;

    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    private int tempoUltimoDisparo = 0;
    private static final int INTERVALO_DE_DISPARO = 5;

    public Boss1() {

        super("boss-cenario-1/boss-cenario", ".png", 5, 0, 3, 0);
        vidaAtual = vidaMaxima;

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
            vidaAtual--;
            if (vidaAtual == 0) {
                getWorld().removeObject(this);
                Greenfoot.setWorld(new Mundo2());
            }
        }

    }

    public void disparoInimigo() {
        int latencia = Greenfoot.getRandomNumber(50);
        if (latencia == 5 || (tempoUltimoDisparo >= INTERVALO_DE_DISPARO)) {
            tempoUltimoDisparo = 0;

            int direcaoTiro = 346;
            direcaoTiro -= Greenfoot.getRandomNumber(150);

            AtaqueBoss1 atacar = new AtaqueBoss1();
            atacar.setRotation(direcaoTiro);
            atacar.playSomDisparo();
            getWorld().addObject(atacar, getX(), getY());
        } else {
            tempoUltimoDisparo++;
        }
    }

    private void movimentacao() {

        if (getX() > 350) {
            move(-3);
        }

        // ataca();

    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

}
