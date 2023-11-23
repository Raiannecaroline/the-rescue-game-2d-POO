import greenfoot.*;

public class PlayerAereo extends PlayerBase {
    private String baixo;
    private static int taxaAtualizacao = 5;
    private static int quantidadeAnimacoes = 5;
    private static boolean terrestre = false;

    public PlayerAereo(String nomeImagem, String extensaoImagem, int identificadorPlayer, String direita, String esquerda, String atirar, String cima, String baixo) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, identificadorPlayer, direita, esquerda, atirar, cima, terrestre);
        this.baixo = baixo;
    }

    public void act() {
        movimentacao();
    }

    public void movimentacao() {
        if (!isMorto()) {
            if (Greenfoot.isKeyDown(getDireita())) {
                move(3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(getEsquerda())) {
                move(-3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(getCima())) {
                setLocation(getX(), getY() - 3);
                setRotation(0);
            }
            if (Greenfoot.isKeyDown(getBaixo())) {
                setLocation(getX(), getY() + 3);
                setRotation(0);
            }
        }
    }

    public String getBaixo() {
        return baixo;
    }

}
