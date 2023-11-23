import greenfoot.*;

public abstract class Personagem extends Actor {
    private String nomeImagem;
    private String extensaoImagem;
    private int taxaAtualizacao;
    private int proximoPasso = 0;
    private int quantidadeAnimacoes;
    private int valorInicial = 0;
    private int vidaMaxima;
    private int vidaAtual;
    private int cicloAtual;
    private Class<? extends Disparo> disparoRival;
    private boolean morto = false;

    public Personagem(
            String nomeImagem, String extensaoImagem, int taxaAtualizacao, int quantidadeAnimacoes,
            int vidaMaxima, Class<? extends Disparo> disparoRival) {

        this.nomeImagem = nomeImagem;
        this.extensaoImagem = extensaoImagem;
        this.taxaAtualizacao = taxaAtualizacao;
        this.quantidadeAnimacoes = quantidadeAnimacoes;
        this.vidaMaxima = vidaMaxima;
        this.disparoRival = disparoRival;

        this.vidaAtual = vidaMaxima;

        setImage(nomeImagem + "-" + valorInicial + extensaoImagem);
    }

    public void act() {
        setCicloAtual();
        animacao();
        movimentacao();
        morte(disparoRival);
        ataque();
    }

    public void animacao() {

        setImage(new GreenfootImage(
                nomeImagem + "-" + proximoPasso + extensaoImagem));

        if (possoAtualizar()) {
            proximoPasso++;

        }

        if (proximoPasso > quantidadeAnimacoes) {

            proximoPasso = valorInicial;
        }

    }

    private boolean possoAtualizar() {
        return (getCicloAtual() % taxaAtualizacao) == 0;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getCicloAtual() {
        return cicloAtual;
    }

    public void setCicloAtual() {
        cicloAtual++;
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    public Class<? extends Disparo> getDisparoRival() {
        return disparoRival;
    }

    public void morte(Class<? extends Disparo> disparoRival) {
        if (isTouching(disparoRival)) {
            removeTouching(disparoRival);
            vidaAtual--;
            if (vidaAtual == 0) {
                setMorto();
                getWorld().removeObject(this);
            }
        }
    }

    public int getTaxaAtualizacao() {
        return taxaAtualizacao;
    }

    public abstract void movimentacao();

    public abstract void ataque();

    public boolean isMorto() {
        return morto;
    }

    public void setMorto() {
        this.morto = true;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }
}
