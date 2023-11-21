import greenfoot.*;

public class PlayerTerrestre extends PlayerBase {
    private String pular;

    public static final int ALTURA_MAXIMA_PULO = 6;

    private boolean estaEmTerraFirme = true;
    private boolean estaEmPulo = false;
    private int alturaAtualDoPulo = 0;

    public PlayerTerrestre(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida,
            Class<? extends Disparo> disparoRival, int identificadorPlayer,
            String direita, String esquerda, String atirar, String cima, String pular) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida, disparoRival, vida, direita, esquerda, atirar, cima);
        this.pular = pular;
    }

    public void act() {
        movimentacao();
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

                estaEmTerraFirme = false;
                estaEmPulo = true;

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
        if (alturaAtualDoPulo < ALTURA_MAXIMA_PULO && estaEmPulo) {
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - MundoDinamico.getForcaGravidade() * 2);

        }
    }

    private void executaApiceDoPulo() {
        if (alturaAtualDoPulo == ALTURA_MAXIMA_PULO) {
            estaEmPulo = false;

        }
    }

    private void executaDescidaDoPulo() {
        if (alturaAtualDoPulo > 0 && !estaEmPulo) {
            alturaAtualDoPulo--;

        }
    }

    private void executaPousoDoPulo() {
        if (alturaAtualDoPulo == 0 && !estaEmPulo) {
            estaEmTerraFirme = true;

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
}
