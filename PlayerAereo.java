import greenfoot.*;

public class PlayerAereo extends PlayerBase {
    public String baixo;

    public PlayerAereo(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida,
            Class<? extends Disparo> disparoRival, int identificadorPlayer,
            String direita, String esquerda, String atirar, String cima, String baixo) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida, disparoRival, identificadorPlayer, direita, esquerda, atirar, cima);
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
