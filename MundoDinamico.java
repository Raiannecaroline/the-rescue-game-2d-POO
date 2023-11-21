import greenfoot.*;

public class MundoDinamico extends MundoEstatico {
    private static final int QUANTIDADE_DE_QUADROS = 100;
    private static final int TAMANHO_DO_QUADRO = 5;
    private static final int FORCA_DE_GRAVIDADE = 7;
    private static final int TAMANHO_PLACAR = 30;

    private int alturaSolo;
    private PlayerBase player1;
    private PlayerBase player2;
    private Placar placar;
    private String nomeImagem;
    private String extensaoImagem;
    private int quadroAtual = 1;
    private int timerBoss;
    private EnemyBase boss;

    public MundoDinamico(String imagemFundo, int alturaSolo, String nomeImagem, String extensaoImagen,
            MundoBase proximoMundo) {
        super(imagemFundo, proximoMundo);
        this.alturaSolo = alturaSolo;
        this.nomeImagem = nomeImagem;
        this.extensaoImagem = extensaoImagen;

        this.player1 = new PlayerTerrestre("player/player-1", ".png", 2,
                1, 11, 0, 5, DisparoEnemy.class,
                1, "right", "left", "enter", "up", "0");
        this.player2 = new PlayerTerrestre("player/player-1", ".png", 2,
                1, 11, 0, 5, DisparoEnemy.class, 2, "right", "left", "enter", "up", "0");
        this.placar = new Placar(0, TAMANHO_PLACAR);

        Placar placarVidaHeroi = new PlacarVida(player1, TAMANHO_PLACAR);
        Placar placarVidaHeroi2 = new PlacarVida(player2, TAMANHO_PLACAR);
        Vida vidaHeroi = new Vida(player1);
        Vida vidaHeroi2 = new Vida(player2);

        addObject(vidaHeroi, 10, 25);
        addObject(vidaHeroi2, 690, 25);
        addObject(placarVidaHeroi, 25, 25);
        addObject(placarVidaHeroi2, 675, 25);
        addObject(player1, 60, alturaSolo);
        addObject(player2, 80, alturaSolo);
        addObject(placar, 50, 10);
    }

    public void act() {
        projetor(proximaCena());
        // aplicarForcaDaGravidade();
        GamerOver();
        DroparInimigo();
    }

    @Override
    public void removeObject(Actor object) {
        if (object instanceof EnemyTerrestre) {
            placar.atualizaPlacar();
        }
        super.removeObject(object);
    }

    @Override
    public void proximoMundo(MundoBase proximoMundo) {
        String tecla = Greenfoot.getKey();

        if (getBoss().isMorto()) {
            Greenfoot.setWorld(proximoMundo);
        }
    }

    public void DroparInimigo() {

        int DropInimigo = Greenfoot.getRandomNumber(50);
        int DropInimigoCeu = Greenfoot.getRandomNumber(200);
        if (DropInimigo == 1) {
            EnemyTerrestre inimigo1 = new EnemyTerrestre();
            addObject(inimigo1, 699, getAlturaSolo());

        }
        if (DropInimigoCeu == 1 && getTimer() < getTimerBoss()) {
            EnemyAereo air = new EnemyAereo();
            addObject(air, 699, 150);
        }
        if (getTimer() == getTimerBoss()) {
            setBoss(new Boss());
            addObject(getBoss(), 699, 50);
        }

    }

    private void GamerOver() {
        java.util.List<PlayerBase> myActors = getObjects(PlayerBase.class);

        if (myActors.isEmpty()) {
            Greenfoot.setWorld(new GameOver());
        }
    }

    private void projetor(GreenfootImage novaCena) {
        setBackground(novaCena);
    }

    private GreenfootImage proximaCena() {
        GreenfootImage novaCena = filme();

        setQuadroAtual();

        return novaCena;
    }

    private GreenfootImage filme() {

        GreenfootImage novaCena = new GreenfootImage(getWidth(), getHeight());
        int posicaoDoQuadro = 0;
        int quadro = quadroAtual;
        while (posicaoDoQuadro < getWidth()) {
            if (quadro > QUANTIDADE_DE_QUADROS) {
                quadro = 1;
            }
            novaCena.drawImage(imagemDoNovoQuadro(quadro), posicaoDoQuadro, 0);
            quadro++;
            posicaoDoQuadro += TAMANHO_DO_QUADRO;

        }
        return novaCena;
    }

    private GreenfootImage imagemDoNovoQuadro(int proximoQuadro) {
        String nomeDoArquivo = getNomeImagem() + proximoQuadro + getExtensaoImagem();
        GreenfootImage novoQuadro = new GreenfootImage(nomeDoArquivo);
        return novoQuadro;

    }

    public int getAlturaSolo() {
        return alturaSolo;
    }

    public void setAlturaSolo(int alturaSolo) {
        this.alturaSolo = alturaSolo;
    }

    public PlayerBase getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerBase player1) {
        this.player1 = player1;
    }

    public PlayerBase getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerBase player2) {
        this.player2 = player2;
    }

    public Placar getPlacar() {
        return placar;
    }

    public void setPlacar(Placar placar) {
        this.placar = placar;
    }

    public int getQuadroAtual() {
        return quadroAtual;
    }

    public void setQuadroAtual() {
        quadroAtual++;
        if (quadroAtual > QUANTIDADE_DE_QUADROS) {
            quadroAtual = 1;
        }
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public String getExtensaoImagem() {
        return extensaoImagem;
    }

    public static int getForcaGravidade() {
        return FORCA_DE_GRAVIDADE;
    }

    public int getTimerBoss() {
        return timerBoss;
    }

    public EnemyBase getBoss() {
        return boss;
    }

    public void setBoss(EnemyBase boss) {
        this.boss = boss;
    }
}
