import greenfoot.*;

public class Boss extends EnemyBase {
    private int tempoUltimoDisparo = 0;
    private static final int INTERVALO_DE_DISPARO = 30;
    private static int vidaMaxima = 100;
    private static int taxaAtualizacao = 5;
    private static int quantidadeAnimacoes = 3;

    public Boss(String nomeImagem, String extensaoImagem) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima);
    }

    public void act() {
        movimentacao();
        ataque();
    }

    @Override
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

    @Override
    public void movimentacao() {
        if (getX() > 350) {
            move(-3);
        }
    }
}
