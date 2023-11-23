import greenfoot.*;

public abstract class EnemyBase extends Personagem {
    private final int raioDeteccao = 700;
    private static Class<? extends Disparo> disparoRival = DisparoPlayer.class;

    public EnemyBase(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int quantidadeAnimacoes,
            int vidaMaxima) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima, disparoRival);
    }

    public int getRaioDeteccao() {
        return raioDeteccao;
    }
}