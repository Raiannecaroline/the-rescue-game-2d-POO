import greenfoot.*;

public class PlayerTerrestre extends PlayerBase {
    private String pular;
    private static int taxaAtualizacao = 2;
    private static int quantidadeAnimacoes = 11;
    private static boolean terrestre = true;
    public static final int ALTURA_MAXIMA_PULO = 6;

    private boolean emTerraFirme = true;
    private boolean emPulo = false;
    private int alturaAtualDoPulo = 0;

    public PlayerTerrestre(String nomeImagem, String extensaoImagem, int identificadorPlayer, String direita,
            String esquerda, String atirar, String cima, String pular) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, identificadorPlayer, direita, esquerda,
                atirar, cima, terrestre);
        this.pular = pular;
    }

    private void gerenciamentoDoPulo() {

        capturaInicoDoPulo();
        executaSubidaDoPulo();
        executaDescidaDoPulo();
        executaApiceDoPulo();
        executaPousoDoPulo();

    }

    private void capturaInicoDoPulo() {

        if (alturaAtual() != 0 || timer()) {
            if (Greenfoot.isKeyDown(pular)) {

                emTerraFirme = false;
                emPulo = true;

            }
        }
    }

    public void movimentacao() {
        if (!isMorto()) {
            gerenciamentoDoPulo();
            if (Greenfoot.isKeyDown(getDireita())) {
                move(3);
                setRotation(0);

            }
            if (Greenfoot.isKeyDown(getEsquerda())) {
                move(-3);
                setRotation(0);
                getImage().mirrorHorizontally();
            }
        }

    }

    private void executaSubidaDoPulo() {
        if (alturaAtualDoPulo < ALTURA_MAXIMA_PULO && emPulo) {
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - MundoDinamico.getForcaGravidade() * 2);

        }
    }

    private void executaApiceDoPulo() {
        if (alturaAtualDoPulo == ALTURA_MAXIMA_PULO) {
            emPulo = false;

        }
    }

    private void executaDescidaDoPulo() {
        if (alturaAtualDoPulo > 0 && !emPulo) {
            alturaAtualDoPulo--;

        }
    }

    private void executaPousoDoPulo() {
        if (alturaAtualDoPulo == 0 && !emPulo) {
            emTerraFirme = true;

        }
    }

    public int getAlturaDosPes() {
        return getY() + getImage().getHeight() / 2;

    }

    public int alturaAtual() {
        MundoDinamico mundo = (MundoDinamico) getWorld();

        return ((getAlturaDosPes() - 20) - mundo.getAlturaSolo()) * -1;
    }

    private boolean timer() {
        MundoDinamico mundo = (MundoDinamico) getWorld();

        return (mundo.getCicloAtual() % 106) == 0;
    }

    public boolean isEmTerraFirme() {
        return emTerraFirme;
    }
}
