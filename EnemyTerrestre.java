import java.util.List;
import greenfoot.*;

public class EnemyTerrestre extends EnemyBase {
    public EnemyTerrestre(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida, Class<Disparo> disparoRival, int raioDeteccao,
            int raioAtaque) {
        super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida,
                disparoRival);
    }

    public void act() {
        movimentacao();
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
