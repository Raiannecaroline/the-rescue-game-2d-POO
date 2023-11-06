import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mundo4 extends World {
    public static final int LARGURA_CENARIO = 700;
    public static final int ALTURA_CENARIO = 390;
    public static final int QUANTIDADE_DE_QUADROS = 100;
    public static final int NIVEL_DO_SOLO = 302;
    public static final int FORCA_DE_GRAVIDADE = 7;
    public static final int TAMANHO_DO_QUADRO = 5;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/cenario4/cenario-4_0";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    public static final int TAMANHO_DO_PLACAR = 30;
    public static final int letraVida = 30;

    private int quadroAtual = 1;
    private int cicloAtual = 0;
    private Player heroi;
    private Player heroi2;
    private Placar placar;
    private BossFinal boss;

    public int timer = 0;
    public int timerBoss = 10;

    public Mundo4() {

        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);

        GreenfootImage cenarioInicial = new GreenfootImage(NOME_ARQUIVO_IMAGEM + EXTENSAO_ARQUIVO_IMAGEM);
        setBackground(cenarioInicial);
        boss = new BossFinal();
        heroi = new Player(1, "right", "left", "0", "enter", "up");
        heroi2 = new Player(2, "d", "a", "space", "t", "w");
        placar = new Placar(0, TAMANHO_DO_PLACAR);

        Placar placarVidaHeroi = new PlacarVida(heroi, TAMANHO_DO_PLACAR);
        Placar placarVidaHeroi2 = new PlacarVida(heroi2, TAMANHO_DO_PLACAR);
        Vida vidaHeroi = new Vida(heroi);
        Vida vidaHeroi2 = new Vida(heroi2);

        addObject(boss, 350, 206);
        addObject(vidaHeroi, 10, 25);
        addObject(vidaHeroi2, 690, 25);
        addObject(placarVidaHeroi, 25, 25);
        addObject(placarVidaHeroi2, 675, 25);

        addObject(heroi, 60, NIVEL_DO_SOLO);
        addObject(heroi2, 80, NIVEL_DO_SOLO);
        addObject(placar, 50, 10);

        setActOrder(BossFinal.class, Player.class);

        prepare();
    }

    @Override
    public void removeObject(Actor object) {
        if (object instanceof Enemy) {
            placar.atualizaPlacar();
        }
        super.removeObject(object);
    }

    public void DroparInimigo() {

        int DropInimigo = Greenfoot.getRandomNumber(50);
        int DropInimigoCeu = Greenfoot.getRandomNumber(200);
        if (DropInimigo == 1) {
            Enemy2 inimigo1 = new Enemy2();
            addObject(inimigo1, 699, NIVEL_DO_SOLO + 5);

        }
        if (DropInimigoCeu == 1 && timer < timerBoss) {
            EnemyAir2 air = new EnemyAir2();
            addObject(air, 699, 150);
        }
        if (timer == timerBoss) {
            Boss2 boss = new Boss2();
            addObject(boss, 699, 332);
        }

    }

    public void prepare() {
        Sound backgroundMusic = new Sound();
        backgroundMusic.play();
    }

    public void aplicarForcaDaGravidade() {

        if (heroi.morte1 == false) {
            if (heroi.alturaAtual() > 0) {
                heroi.setLocation(heroi.getX(), heroi.getY() + FORCA_DE_GRAVIDADE);

            }
        }
        if (heroi2.morte1 == false) {
            if (heroi2.alturaAtual() > 0) {
                heroi2.setLocation(heroi2.getX(), heroi2.getY() + FORCA_DE_GRAVIDADE);

            }

        }
    }

    public int cicloAtual() {
        return cicloAtual;
    }

    private void contaCiclo() {
        cicloAtual++;
        if ((cicloAtual() % 16) == 0) {
            timer++;
        }
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    public int Timer() {
        return timer;
    }

    private void GamerOver() {
        java.util.List<Player> myActors = getObjects(Player.class);

        if (myActors.isEmpty()) {
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void act() {
        aplicarForcaDaGravidade();
        GamerOver();

        contaCiclo();
        // DroparInimigo();

    }
}
