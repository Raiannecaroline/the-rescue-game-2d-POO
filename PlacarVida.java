import greenfoot.*;

public class PlacarVida extends Placar{
    private Player player;
    private int xVida;
    private int yVida = 20;

    public PlacarVida(Player player, int tamanhoFonte) {
        super(player.getVidas(), tamanhoFonte);
        this.player = player;

    }

    public void act() {
        atualizaPlacar();

    }


    public void atualizaPlacar() {
        int valor = player.getVidas();
        setImage(new GreenfootImage(Integer.toString(valor), tamanhoFonte, fillColor, background, lineColor));
    }
}
