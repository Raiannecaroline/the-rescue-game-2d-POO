import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Boss2 extends Personagem {

    public int vida = 1;

    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    private int DropInimigo = Greenfoot.getRandomNumber(10);
    private Personagem animacao;
    private List<DisparoPlayer> disparosSofridos;

    private int tempoUltimoDisparo = 0;
    private static final int INTERVALO_DE_DISPARO = 30;

    public Boss2() {

        super("boss-cenario-2/boss-2", ".png", 5, 0, 3, 0);

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
                Greenfoot.setWorld(new CutScene2To3());
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

    private boolean possoAtualizar() {
        return (cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

    private void movimentacao() {
        if (possoAtualizar()) {
            if (getX() > 350) {
                move(-3);
            }

            // ataca();
        }
    }

}
