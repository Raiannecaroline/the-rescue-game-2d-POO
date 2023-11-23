import greenfoot.*;

public class VidaBoss extends Actor {
    public String NOME_ARQUIVO_IMAGEM = "life-boss/life-boss_";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    private Personagem boss;
    private int qtdImagens = 8;

    public VidaBoss(Personagem boss) {
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
        World mundo = this.getWorld();

        if (mundo instanceof Mundo1) {
            Boss1 bossCast = (Boss1) boss;
            if (bossCast.getVidaAtual() > 0) {
                return ((bossCast.getVidaMaxima() - bossCast.getVidaAtual()) * 100) / bossCast.getVidaMaxima();
            } else {
                return 0;
            }

        } else if (mundo instanceof Mundo2) {
            Boss2 bossCast = (Boss2) boss;
            if (bossCast.getVidaAtual() > 0) {
                return ((bossCast.getVidaMaxima() - bossCast.getVidaAtual()) * 100) / bossCast.getVidaMaxima();
            } else {
                return 0;
            }
        } else {
             BossFinal bossCast = (BossFinal) boss;
            if (bossCast.getVidaAtual() > 0) {
                return ((bossCast.getVidaMaxima() - bossCast.getVidaAtual()) * 100) / bossCast.getVidaMaxima();
            } else {
                return 0;
            }
        }
    }
}
