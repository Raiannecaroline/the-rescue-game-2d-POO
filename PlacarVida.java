import greenfoot.*;

public class PlacarVida extends Placar {
    private Personagem player;
    private int xVida;
    private int yVida = 20;

    public PlacarVida(Player player, int tamanhoFonte) {
        super(player.getVidas(), tamanhoFonte);
        this.player = player;

    }

    public PlacarVida(PlayerAir player, int tamanhoFonte) {
        super(player.getVidas(), tamanhoFonte);
        this.player = player;

    }

    public void act() {
        atualizaPlacar();

    }

    public void atualizaPlacar() {
    int valor = 0;
    if (player instanceof Player) {
        Player playerCast = (Player) player;
        valor = playerCast.getVidas();
    } else if (player instanceof PlayerAir) {
        PlayerAir playerAirCast = (PlayerAir) player;
        valor = playerAirCast.getVidas();
    }
    
    setImage(new GreenfootImage(Integer.toString(valor), tamanhoFonte, fillColor, background, lineColor));
}
}
