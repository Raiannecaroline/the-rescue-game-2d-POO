import greenfoot.*;

public class Vida extends Actor{
    public String NOME_ARQUIVO_IMAGEM = "life/life-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int identificadorPlayer;
    private Personagem player;
    private World mundo;

    public Vida(PlayerBase player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    }
}
