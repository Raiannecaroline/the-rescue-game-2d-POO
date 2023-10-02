import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {
    private int raioDeteccao = 350;
    private int raioAtaque = 200;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Enemy(){
        setImage("enemys/enemys-1-2.png");
    }

    public void act() {
        movimentacao();
    }

    private void movimentacao(){
        if (isInRange()) {
            move(direcaoMovimento());

            // ataca();
        }

    }

    public int direcaoMovimento(){
        int xEnemy = getX();
        int xHeroiMaisProximo = getPlayerMaisProximo().getX();

        if (xEnemy < xHeroiMaisProximo){
            return 1;
        } else {
            return -1;
        }

    }

    public Player getPlayerMaisProximo(){
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() == 1){
            return  listaDePlayers.get(0);
        }

        int xEnemy = getX();
        int xHeroi1 = listaDePlayers.get(0).getX();
        int xHeroi2 = listaDePlayers.get(1).getX();

        if (xEnemy - xHeroi1 < xEnemy - xHeroi2){
            return  listaDePlayers.get(0);
        } else {
            return  listaDePlayers.get(1);
        }
    }

    public boolean isInRange(){
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() != 0){
            return true;
        } else {
            return false;
        }
    }

    public List<Player> getListaDePlayers(){
        return getObjectsInRange(raioDeteccao, Player.class);
    }
}
