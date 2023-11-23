import greenfoot.*;

public class VidaBoss extends Actor {
    public String NOME_ARQUIVO_IMAGEM = "life-boss/life-boss_";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    private EnemyBase boss;
    private int qtdImagens = 8;

    public VidaBoss(EnemyBase boss) {
        this.boss = boss;
        setImage(NOME_ARQUIVO_IMAGEM + "0" + EXTENSAO_ARQUIVO_IMAGEM);

    }

    public void act() {
        atualizaImagemVida();
    }

    public void atualizaImagemVida() {
        int porcentagemVidaPerdida = porcentagemVidaPerdida();

        int porcentagemPorImagem = 100 / qtdImagens;
        int indiceImagem = porcentagemVidaPerdida / porcentagemPorImagem;

        indiceImagem = Math.min(indiceImagem, qtdImagens - 1);

        String nomeImagem = NOME_ARQUIVO_IMAGEM + indiceImagem + EXTENSAO_ARQUIVO_IMAGEM;
        setImage(nomeImagem);
    }

    private int porcentagemVidaPerdida() {
        if (boss.getVidaAtual() > 0) {
            return ((boss.getVidaMaxima() - boss.getVidaAtual()) * 100) / boss.getVidaMaxima();
        } else {
            return 0;
        }
    }
}
