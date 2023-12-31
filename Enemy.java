import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Personagem {

    public int vida = 5;

    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    private int DropInimigo = Greenfoot.getRandomNumber(10);
    private Personagem animacao;
    private List<DisparoPlayer> disparosSofridos;
    
    
    private AnimacaoDano animaDano = new AnimacaoDano();

    public Enemy() {

        super("enemys/enemys-1", ".png", 2, 0, 3, 0);

    }

    public void UsarAnimacao() {

        animacao.Animacao();
    }

    public void act() {
        super.act();

        movimentacao();
        disparoInimigo();
        setListaDisparosSofridos();
        morte();

    }

    private void morte() {
        if (isTouching(DisparoPlayer.class)) {
            removeTouching(DisparoPlayer.class);
            vida--;
             getWorld().addObject(animaDano, this.getX(), this.getY());
             if (vida <=3){
                getWorld().removeObject(animaDano);
                if (vida == 0) {
                 getWorld().removeObject(this);
                Sound morte = new Sound("morteenemy.wav");
              morte.play();
            }
            
            }
            
            
        }
    }
    public void receberDano() {
        AnimacaoDano animaDano = new AnimacaoDano();
        getWorld().addObject(animaDano, this.getX(), this.getY());
    }

    private void disparoInimigo() {
        int latencia = Greenfoot.getRandomNumber(60);

        DisparoEnemy ataque = new DisparoEnemy();
       
        if (latencia == 1) {
             ataque.playSomDisparo();
            getWorld().addObject(ataque, getX(), getY());
        }
    }

    private void movimentacao() {
        // UsarAnimacao();

        if (isInRange()) {
            move(direcaoMovimento());

            // ataca();
        }

    }

    public int direcaoMovimento() {
        int xEnemy = getX();
        int xHeroiMaisProximo = getPlayerMaisProximo().getX();

        if (xEnemy < xHeroiMaisProximo) {
            return 4;
        } else {
            return -4;
        }

    }

    public Player getPlayerMaisProximo() {
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() == 1) {
            return listaDePlayers.get(0);
        }

        int xEnemy = getX();
        int xHeroi1 = listaDePlayers.get(0).getX();
        int xHeroi2 = listaDePlayers.get(1).getX();

        if (xEnemy - xHeroi1 < xEnemy - xHeroi2) {
            return listaDePlayers.get(0);
        } else {
            return listaDePlayers.get(1);
        }
    }

    public boolean isInRange() {
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Player> getListaDePlayers() {

        return getObjectsInRange(raioDeteccao, Player.class);
    }

    public List<DisparoPlayer> getListaDisparosSofridos() {
        return this.disparosSofridos;
    }

    public void setListaDisparosSofridos() {
        this.disparosSofridos = getIntersectingObjects(DisparoPlayer.class);
    }

}
