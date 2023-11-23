import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Personagem extends Actor {
    public String NOME_ARQUIVO_IMAGEM;
    public String EXTENSAO_ARQUIVO_IMAGEM;
    public int TAXA_DE_ATUALIZACAO;
    public int proximoPasso;
    public int quantidadeAnimacoes;
    public int ValorInicial;
    private int identificadorPlayer;
    public Mundo1 mundo;
    private int cicloAtual;

    public Personagem() {
        this.mundo = (Mundo1) getWorld();
    }

    public Personagem(String NOME_ARQUIVO_IMAGEM, String EXTENSAO_ARQUIVO_IMAGEM, int TAXA_DE_ATUALIZACAO,
            int proximoPasso, int quantidadeAnimacoes, int ValorInicial, int identificadorPlayer) {
        this.NOME_ARQUIVO_IMAGEM = NOME_ARQUIVO_IMAGEM;
        this.EXTENSAO_ARQUIVO_IMAGEM = EXTENSAO_ARQUIVO_IMAGEM;
        this.TAXA_DE_ATUALIZACAO = TAXA_DE_ATUALIZACAO;
        this.proximoPasso = proximoPasso;
        this.ValorInicial = ValorInicial;
        this.identificadorPlayer = identificadorPlayer;
        this.quantidadeAnimacoes = quantidadeAnimacoes;

    }

    public Personagem(String NOME_ARQUIVO_IMAGEM, String EXTENSAO_ARQUIVO_IMAGEM, int TAXA_DE_ATUALIZACAO,
            int proximoPasso, int quantidadeAnimacoes, int ValorInicial) {
        this.NOME_ARQUIVO_IMAGEM = NOME_ARQUIVO_IMAGEM;
        this.EXTENSAO_ARQUIVO_IMAGEM = EXTENSAO_ARQUIVO_IMAGEM;
        this.TAXA_DE_ATUALIZACAO = TAXA_DE_ATUALIZACAO;
        this.proximoPasso = proximoPasso;
        this.ValorInicial = ValorInicial;
        this.quantidadeAnimacoes = quantidadeAnimacoes;

    }

    public Personagem(String NOME_ARQUIVO_IMAGEM, String EXTENSAO_ARQUIVO_IMAGEM) {
        this.NOME_ARQUIVO_IMAGEM = NOME_ARQUIVO_IMAGEM;
        this.EXTENSAO_ARQUIVO_IMAGEM = EXTENSAO_ARQUIVO_IMAGEM;
    }

    public void act() {
        contaCiclo();

        Animacao();

        // Add your action code here.
    }

    public void Animacao() {

        setImage(new GreenfootImage(
                NOME_ARQUIVO_IMAGEM + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM));

        if (possoAtualizar()) {
            proximoPasso++;

        }

        if (proximoPasso > quantidadeAnimacoes) {

            proximoPasso = ValorInicial;
        }

    }

    public int cicloAtual() {
        return cicloAtual;
    }

    private void contaCiclo() {
        cicloAtual++;
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    private boolean possoAtualizar() {
        return (cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }
    
    
     

}
