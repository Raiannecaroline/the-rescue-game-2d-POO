import greenfoot.*;

public class VidaPlayer extends Actor {
    public String NOME_ARQUIVO_IMAGEM = "life/life";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int identificadorPlayer;
    private PlayerBase player;

    public VidaPlayer(PlayerBase player) {
        this.player = player;
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + "-" + player.getVidaAtual() +
                EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {
        atualizaImagem();
    }

    public PlayerBase getPlayer() {
        return this.player;
    }

    public void atualizaImagem() {

        GreenfootImage novaImagem = criaImagem();
        setImage(novaImagem);

    }

    public GreenfootImage criaImagem() {
        return new GreenfootImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + "-" + player.getVidaAtual() +
        EXTENSAO_ARQUIVO_IMAGEM);

    }
}
