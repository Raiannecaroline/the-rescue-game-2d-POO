import greenfoot.*;

public class Vida extends Actor{
    public String NOME_ARQUIVO_IMAGEM = "life/life-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int identificadorPlayer;
    private Personagem player;
    private World mundo;

    public Vida(Player player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    }

    public Vida(PlayerAir player) {
        this.player = player;
        this.mundo = player.getWorld();
        this.identificadorPlayer = player.getIdentificadorPlayer();
        setImage(NOME_ARQUIVO_IMAGEM + player.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {

    }

    public Personagem getPlayer() {
        return this.player;
    }

    public void exibirVida() {
        /*if (player.getVidas() == 3) {

        }
        Vida vida = new Vida(mundo.getHeroi());
        mundo.addObject(vida, 50, 50);*/
    }

    private GreenfootImage criaImagem() {
    if (player instanceof Player) {
        Player playerCast = (Player) player;
        return new GreenfootImage(NOME_ARQUIVO_IMAGEM + playerCast.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    } else if (player instanceof PlayerAir) {
        PlayerAir playerAirCast = (PlayerAir) player;
        return new GreenfootImage(NOME_ARQUIVO_IMAGEM + playerAirCast.getIdentificadorPlayer() + EXTENSAO_ARQUIVO_IMAGEM);
    } else {
        return new GreenfootImage(""); // Ou outra imagem padrão, se aplicável
    }
}

}
