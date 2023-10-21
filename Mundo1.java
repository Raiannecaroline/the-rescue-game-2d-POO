import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mundo1 extends World {
    public static final int LARGURA_CENARIO = 700;
    public static final int ALTURA_CENARIO = 390;
    public static final int QUANTIDADE_DE_QUADROS = 100;
    public static final int NIVEL_DO_SOLO = 336;
    public static final int FORCA_DE_GRAVIDADE = 7;
    public static final int TAMANHO_DO_QUADRO = 5;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/CenariomovimentIlha/cenario_";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    public static final int TAMANHO_DO_PLACAR = 30;
<<<<<<< HEAD
     public static final int letraVida= 30;
=======
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696

    private int quadroAtual = 1;
    private int cicloAtual = 0;
    private Player heroi;
    private Player heroi2;
    private Placar placar;

<<<<<<< HEAD

    public int timer = 0;
     public int timerBoss = 250;


    public Mundo1() {


        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);

=======
    public Mundo1() {

        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
        GreenfootImage cenarioInicial = new GreenfootImage("mundo1.png");
        setBackground(cenarioInicial);
        heroi = new Player(1, "right", "left", "0", "enter", "up");
        heroi2 = new Player(2, "d", "a", "space", "t", "w");
        placar = new Placar(0, TAMANHO_DO_PLACAR);

<<<<<<< HEAD
        Placar placarVidaHeroi = new PlacarVida(heroi, TAMANHO_DO_PLACAR);
        Placar placarVidaHeroi2 = new PlacarVida(heroi2, TAMANHO_DO_PLACAR);
        Vida vidaHeroi = new Vida(heroi);
        Vida vidaHeroi2 = new Vida(heroi2);

        addObject(vidaHeroi, 10, 25);
        addObject(vidaHeroi2, 690, 25);
        addObject(placarVidaHeroi, 25, 25);
        addObject(placarVidaHeroi2, 675, 25);

=======
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
        addObject(heroi, 60, 336);
        addObject(heroi2, 80, 336);
        addObject(placar, 50, 10);

<<<<<<< HEAD






        prepare();
=======
        // prepare();

>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
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
<<<<<<< HEAD
         int DropInimigoCeu = Greenfoot.getRandomNumber(200);
        if (DropInimigo == 1) {
            Enemy inimigo1 = new Enemy();
            addObject(inimigo1, 699, 340);

        }
         if (DropInimigoCeu == 1 && timer<timerBoss) {
            EnemyAir Air = new EnemyAir();
            addObject(Air, 699, 150);
        }
         if (timer == timerBoss ) {
            Boss1 boss = new Boss1();
            addObject(boss, 699, 50);
        }

=======
        if (DropInimigo == 1) {
            Enemy inimigo1 = new Enemy();
            addObject(inimigo1, 699, 340);
        }
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
    }

    public void prepare() {
        Sound backgroundMusic = new Sound();
<<<<<<< HEAD
=======
        addObject(backgroundMusic, 0, 0);
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
        backgroundMusic.play();
    }

    public void aplicarForcaDaGravidade() {
<<<<<<< HEAD

        if (heroi.morte1 ==false){
        if (heroi.alturaAtual() > 0 ) {
            heroi.setLocation(heroi.getX(), heroi.getY() + FORCA_DE_GRAVIDADE);


        }
    }
    if (heroi2.morte1 ==false){
        if (heroi2.alturaAtual() > 0) {
            heroi2.setLocation(heroi2.getX(), heroi2.getY() + FORCA_DE_GRAVIDADE);


        }

    }
    }


=======
        if (heroi.alturaAtual() > 0) {
            heroi.setLocation(heroi.getX(), heroi.getY() + FORCA_DE_GRAVIDADE);

        }
        if (heroi2.alturaAtual() > 0) {
            heroi2.setLocation(heroi2.getX(), heroi2.getY() + FORCA_DE_GRAVIDADE);

        }
    }

>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
    public int cicloAtual() {
        return cicloAtual;
    }

    private void contaCiclo() {
        cicloAtual++;
<<<<<<< HEAD
        if((cicloAtual() % 16) == 0){
            timer++;
        }
=======
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }
<<<<<<< HEAD
    public int Timer() {
        return timer;
    }



    public void act() {



        projetor(proximaCena());

        aplicarForcaDaGravidade();




=======

    public void act() {

        projetor(proximaCena());
        aplicarForcaDaGravidade();
>>>>>>> ac05a2ef5c3fdb22f9bee913be73b395e3a55696
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
