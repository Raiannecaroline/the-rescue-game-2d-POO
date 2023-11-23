import greenfoot.*;

public class EnemyAereo extends EnemyBase {
    private static int taxaAtualizacao = 5;
    private static int vidaMaxima = 5;

    public EnemyAereo(String nomeImagem, String extensaoImagem, int quantidadeAnimacoes) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima);
    }

    public void ataque() {
        int latencia = Greenfoot.getRandomNumber(60);

        DisparoEnemy ataque = new DisparoEnemy();

        if (latencia == 1) {
            ataque.playSomDisparo();
            getWorld().addObject(ataque, getX(), getY());
            ataque.setRotation(-90);
        }
    }

    public void movimentacao() {
        if (getX() > 50) {
            move(-3);
        }
    }
}
