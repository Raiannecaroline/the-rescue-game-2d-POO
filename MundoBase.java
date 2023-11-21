import greenfoot.*;

public abstract class MundoBase extends World {
    private static final int LARGURA_CENARIO = 700;
    private static final int ALTURA_CENARIO = 390;
    private static final int TAMANHO_CEU = 1;

    public MundoBase(String imagemFundo) {
        super(LARGURA_CENARIO, ALTURA_CENARIO, TAMANHO_CEU);
        setBackground(imagemFundo);
        setActOrder(PlayerBase.class);
    }

    public abstract void proximoMundo(MundoBase proximoMundo);
}
