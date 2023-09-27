import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    public static final String NOME_ARQUIVO_IMAGEM = "player/player-";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    public int proximoPasso = 6;

    private int identificadorPlayer;

    /**
     * Act - do whatever the Gato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Player(int identificadorPlayer) {
        super();
        this.identificadorPlayer = identificadorPlayer;
    }

    public void act()
    {

        setImage(new GreenfootImage(NOME_ARQUIVO_IMAGEM + identificadorPlayer + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM));

        proximoPasso++;
        if(proximoPasso > 10){
            proximoPasso = 6;
        }
    }

}
