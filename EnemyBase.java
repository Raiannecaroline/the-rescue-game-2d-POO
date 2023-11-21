import greenfoot.*;

public abstract class EnemyBase extends Personagem {
    private final int raioDeteccao = 700;

    public EnemyBase(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida, Class<? extends Disparo> disparoRival) {
                super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida, disparoRival);
            }

    public int getRaioDeteccao() {
        return raioDeteccao;
    }
}