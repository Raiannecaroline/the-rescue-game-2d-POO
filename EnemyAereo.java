import greenfoot.*;

public class EnemyAereo extends EnemyBase {
    public EnemyAereo(String nomeImagem, String extensaoImagem, int taxaAtualizacao, int proximoPasso,
            int quantidadeAnimacoes, int valorInicial, int vida, Class<? extends Disparo> disparoRival) {
                super(nomeImagem, extensaoImagem, taxaAtualizacao, proximoPasso, quantidadeAnimacoes, valorInicial, vida, disparoRival);
            }


    public void act() {
        movimentacao();
        ataque();
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
       if(getX() >50){
           move(-3);
       }
    }
}
