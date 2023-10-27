import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mundo3 extends World {
    public static final int LARGURA_CENARIO = 700;
    public static final int ALTURA_CENARIO = 390;
    public static final int QUANTIDADE_DE_QUADROS = 100;
    public static final int NIVEL_DO_SOLO = 349;
    public static final int FORCA_DE_GRAVIDADE = 7;
    public static final int TAMANHO_DO_QUADRO = 5;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/CenariomovimentIlha-3/cenario_";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    public static final int TAMANHO_DO_PLACAR = 30;
    public static final int letraVida = 30;

    private int quadroAtual = 1;
    private int cicloAtual = 0;
    private PlayerAir heroi;
    private PlayerAir heroi2;
    private Placar placar;

    public int timer = 0;
    public int timerBoss = 250;

    public Mundo3() {

        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);

        GreenfootImage cenarioInicial = new GreenfootImage("mundo3.png");
        setBackground(cenarioInicial);
        heroi = new PlayerAir(1, "right", "left", "down", "enter", "up");
        heroi2 = new PlayerAir(2, "d", "a", "s", "t", "w");
        placar = new Placar(0, TAMANHO_DO_PLACAR);

        Placar placarVidaHeroi = new PlacarVida(heroi, TAMANHO_DO_PLACAR);
        Placar placarVidaHeroi2 = new PlacarVida(heroi2, TAMANHO_DO_PLACAR);
        Vida vidaHeroi = new Vida(heroi);
        Vida vidaHeroi2 = new Vida(heroi2);

        addObject(vidaHeroi, 10, 25);
        addObject(vidaHeroi2, 690, 25);
        addObject(placarVidaHeroi, 25, 25);
        addObject(placarVidaHeroi2, 675, 25);

        addObject(heroi, 60, NIVEL_DO_SOLO);
        addObject(heroi2, 80, NIVEL_DO_SOLO);
        addObject(placar, 50, 10);

        setActOrder(Player.class);

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
        int posicaoInimigo = Greenfoot.getRandomNumber(370) + 10;
        int posicaoBolaFogo = Greenfoot.getRandomNumber(640) + 30;

        int DropInimigo = Greenfoot.getRandomNumber(50);
        int DropInimigoCeu = Greenfoot.getRandomNumber(100);

        if (DropInimigo == 1) {
            EnemyAir2 air = new EnemyAir2();
            addObject(air, 699, posicaoInimigo);

        }
        if (DropInimigo == 1) {
            BolaFogo bolaFogo = new BolaFogo();
            addObject(bolaFogo, posicaoBolaFogo, 50);
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
        java.util.List<PlayerAir> myActors = getObjects(PlayerAir.class);

        if (myActors.isEmpty()) {
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void act() {

        projetor(proximaCena());

        //aplicarForcaDaGravidade();
        GamerOver();

        contaCiclo();
        DroparInimigo();

    }

    private void projetor(GreenfootImage novaCena) {
        setBackground(novaCena);
    }

    private GreenfootImage proximaCena() {
        GreenfootImage novaCena = filme();

        quadroAtual++;
        if (quadroAtual > QUANTIDADE_DE_QUADROS) {
            quadroAtual = 1;
        }
        return novaCena;
    }

    private GreenfootImage filme() {

        GreenfootImage novaCena = new GreenfootImage(LARGURA_CENARIO, ALTURA_CENARIO);
        int posicaoDoQuadro = 0;
        int quadro = quadroAtual;
        while (posicaoDoQuadro < LARGURA_CENARIO) {
            if (quadro > QUANTIDADE_DE_QUADROS) {
                quadro = 1;
            }
            novaCena.drawImage(imagemDoNovoQuadro(quadro), posicaoDoQuadro, 0);
            quadro++;
            posicaoDoQuadro += TAMANHO_DO_QUADRO;

        }
        return novaCena;
    }

    /**
     * Apenas busca as novas filetas dentro do diretório de imagem
     */
    private GreenfootImage imagemDoNovoQuadro(int proximoQuadro) {
        String nomeDoArquivo = NOME_ARQUIVO_IMAGEM + proximoQuadro + EXTENSAO_ARQUIVO_IMAGEM;
        GreenfootImage novoQuadro = new GreenfootImage(nomeDoArquivo);
        return novoQuadro;

    }

}
