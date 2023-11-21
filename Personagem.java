import greenfoot.*;

public abstract class Personagem extends Actor {
    private String nomeImagem;
    private String extensaoImagem;
    private int taxaAtualizacao;
    private int proximoPasso;
    private int quantidadeAnimacoes;
    private int valorInicial;
    private int vida;
    private int cicloAtual;
    private Class<? extends Disparo> disparoRival;
    private boolean morto = false;



    public Personagem(
            String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso, int quantidadeAnimacoes,
            int valorInicial, int vida, Class<? extends Disparo> disparoRival) {

        this.nomeImagem = nomeImagem;
        this.extensaoImagem = extensaoImagem;
        this.taxaAtualizacao = taxaAtualizacao;
        this.proximoPasso = proximoPasso;
        this.quantidadeAnimacoes = quantidadeAnimacoes;
        this.valorInicial = valorInicial;
        this.vida = vida;
        this.disparoRival = disparoRival;

        setImage(nomeImagem + "-" + valorInicial + extensaoImagem);
    }

    public void act() {
        setCicloAtual();
        Animacao();
        morte(disparoRival);
    }

    public void Animacao() {

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

    public int getVida() {
        return vida;
    }

    public void danoSofrido() {
        this.vida = vida--;
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
            vida--;
            if (vida == 0) {
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
}
