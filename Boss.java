import greenfoot.*;

public class Boss extends EnemyBase {
    private int tempoUltimoDisparo = 0;
    private static final int INTERVALO_DE_DISPARO = 30;

    public Boss(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida, Class<? extends Disparo> disparoRival) {
                super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida, disparoRival);
            }

    public void act() {
        movimentacao();
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
        if (getX() > 350) {
            move(-3);
        }
    }
}
