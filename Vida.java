import greenfoot.*;

public class Vida extends Actor{
    public String NOME_ARQUIVO_IMAGEM = "life/life-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int identificadorPlayer;
    private Player player;
    private World mundo;

    public Vida(Player player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {

    }

    public Player getPlayer() {
        return this.player;
    }

    public void exibirVida() {
        /*if (player.getVidas() == 3) {

        }
        Vida vida = new Vida(mundo.getHeroi());
        mundo.addObject(vida, 50, 50);*/
    }

    private GreenfootImage criaImagem() {
        GreenfootImage imagemVida = new GreenfootImage(
            NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
        return imagemVida;
    }
}
