import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class tiro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tiro extends Player {
    private int alcance = Greenfoot.getRandomNumber(10) + 30;
    private int dano = 1;
    public int latencia = Greenfoot.getRandomNumber(3);

    public void act() {
        atirando();
    }

    public void atirando() {

        alcance--;
        move(12);
        // Verifica se existem objetos da classe Player no mundo
        if (alcance == 0 || isAtEdge() || isTouching(Enemy.class)) {
            getWorld().removeObject(this);

        }
    }

    public boolean Latencia() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % latencia) == 0;
    }

}
