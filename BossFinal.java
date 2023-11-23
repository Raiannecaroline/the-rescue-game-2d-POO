import greenfoot.*;

public class BossFinal extends EnemyBase {
    private int tempoUltimoDisparo = 0;
    private static final int INTERVALO_DE_DISPARO = 15;
    private static int vidaMaxima = 100;
    private static int taxaAtualizacao = 5;
    private static int quantidadeAnimacoes = 8;

    public BossFinal(String nomeImagem, String extensaoImagem) {
               super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima);
            }

    public void act() {
        ataque();
    }

    public void ataque() {
        int latencia = Greenfoot.getRandomNumber(50);
        if (latencia == 5 || (tempoUltimoDisparo >= INTERVALO_DE_DISPARO)) {
            tempoUltimoDisparo = 0;

            int direcaoTiro = 346;
            direcaoTiro -= Greenfoot.getRandomNumber(150);

            AtaqueBoss atacar = new AtaqueBoss();
            atacar.setRotation(direcaoTiro);
            atacar.playSomDisparo();
            getWorld().addObject(atacar, getX(), getY());
        } else {
            tempoUltimoDisparo++;
        }
    }

    public void movimentacao() {

    }
}
