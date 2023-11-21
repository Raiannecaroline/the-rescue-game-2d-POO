import greenfoot.*;

public class PlacarVida extends Placar {
    private PlayerBase player;
    private int xVida;
    private int yVida = 20;

    public PlacarVida(PlayerBase player, int tamanhoFonte) {
        super(player.getVida(), tamanhoFonte);
        this.player = player;

    }

    public void act() {
        atualizaPlacar();

    }

    public void atualizaPlacar() {
    int valor = 0;
    PlayerBase playerCast = player;
    valor = playerCast.getVida();

    setImage(new GreenfootImage(Integer.toString(valor), tamanhoFonte, fillColor, background, lineColor));
}
}
