import java.util.List;
import greenfoot.*;

public class EnemyTerrestre extends EnemyBase {
    private static int taxaAtualizacao = 2;
    private static int quantidadeAnimacoes = 3;
    private static int vidaMaxima = 5;

    public EnemyTerrestre(String nomeImagem, String extensaoImagem) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, quantidadeAnimacoes, vidaMaxima);
    }

    public void ataque() {
        int latencia = Greenfoot.getRandomNumber(60);

        DisparoEnemy ataque = new DisparoEnemy();

        if (latencia == 1) {
            ataque.playSomDisparo();
            getWorld().addObject(ataque, getX(), getY());
        }
    }

    public void movimentacao() {
        if (isInRange()) {
            move(direcaoMovimento());
        }

    }

    public int direcaoMovimento() {
        int xEnemy = getX();
        int xHeroiMaisProximo = getPlayerMaisProximo().getX();

        if (xEnemy < xHeroiMaisProximo) {
            return 4;
        } else {
            return -4;
        }

    }

    public PlayerBase getPlayerMaisProximo() {
        List<PlayerBase> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() == 1) {
            return listaDePlayers.get(0);
        }

        int xEnemy = getX();
        int xHeroi1 = listaDePlayers.get(0).getX();
        int xHeroi2 = listaDePlayers.get(1).getX();

        if (xEnemy - xHeroi1 < xEnemy - xHeroi2) {
            return listaDePlayers.get(0);
        } else {
            return listaDePlayers.get(1);
        }
    }

    public boolean isInRange() {
        List<PlayerBase> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<PlayerBase> getListaDePlayers() {
        return getObjectsInRange(getRaioDeteccao(), PlayerBase.class);
    }
}
