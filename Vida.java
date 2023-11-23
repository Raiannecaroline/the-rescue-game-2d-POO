import greenfoot.*;

public class Vida extends Actor {
    public String NOME_ARQUIVO_IMAGEM = "life/life";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int identificadorPlayer;
    private Personagem player;
    private World mundo;

    public Vida(Player player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + "-" + player.getVidas() +
                EXTENSAO_ARQUIVO_IMAGEM);
    }

    public Vida(PlayerAir player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + "-" + player.getVidas() +
                EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {
        atualizaImagem();
    }

    public Player getPlayer() {
        return (Player) this.player;
    }

    public PlayerAir getPlayerAir() {
        return (PlayerAir) this.player;
    }

    public void atualizaImagem() {

        GreenfootImage novaImagem = criaImagem();
        setImage(novaImagem);

    }

    public GreenfootImage criaImagem() {
        if (player instanceof Player) {
            Player playerCast = (Player) player;
            return new GreenfootImage(
                    NOME_ARQUIVO_IMAGEM + playerCast.getIdentificadorPlayer() + "-" + playerCast.getVidas() +
                            EXTENSAO_ARQUIVO_IMAGEM);
        } else if (player instanceof PlayerAir) {
            PlayerAir playerAirCast = (PlayerAir) player;
            return new GreenfootImage(
                    NOME_ARQUIVO_IMAGEM + playerAirCast.getIdentificadorPlayer() + "-" + playerAirCast.getVidas()
                            + EXTENSAO_ARQUIVO_IMAGEM);
        } else {
            return new GreenfootImage("");
        }
    }
}
