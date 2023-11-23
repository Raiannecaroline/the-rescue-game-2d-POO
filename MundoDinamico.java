import greenfoot.*;

public abstract class MundoDinamico extends MundoEstatico {
    private static final int QUANTIDADE_DE_QUADROS = 100;
    private static final int TAMANHO_DO_QUADRO = 5;
    private static final int FORCA_DE_GRAVIDADE = 7;
    private static final int TAMANHO_PLACAR = 30;
    private static final int TIMER_OBJETIVO = 10;

    private int alturaSolo;
    private PlayerBase player1;
    private PlayerBase player2;
    private String nomeImagem;
    private String extensaoImagem;
    private int quadroAtual = 1;
    private EnemyBase boss;
    private boolean terrestre;

    public MundoDinamico(String imagemFundo, int alturaSolo, String nomeImagem, String extensaoImagen,
            boolean terrestre) {
        super(imagemFundo);
        this.alturaSolo = alturaSolo;
        this.nomeImagem = nomeImagem;
        this.extensaoImagem = extensaoImagen;
        this.terrestre = terrestre;

        if (terrestre) {
            this.player1 = new PlayerTerrestre("player/player-1", ".png",
                    1, "right", "left", "enter", "up", "0");
            this.player2 = new PlayerTerrestre("player/player-2", ".png", 2, "d", "a", "t", "w", "space");
        } else {
            this.player1 = new PlayerAereo("helicopter-players/helicopter-player-1", ".png", 1, "right", "left", "enter", "up", "down");
            this.player2 = new PlayerAereo("helicopter-players/helicopter-player-2", ".png", 2, "d", "a", "t", "w", "s");
        }

        VidaPlayer vidaplayer1 = new VidaPlayer(getPlayer1());
        VidaPlayer vidaplayer2 = new VidaPlayer(getPlayer2());

        addObject(vidaplayer1, 30, 10);
        addObject(vidaplayer2, 670, 10);
        addObject(player1, 60, alturaSolo);
        addObject(player2, 80, alturaSolo);
    }

    public void act() {
        projetor(proximaCena());
        aplicarForcaDaGravidade();
        gameOver();
        droparInimigo();
    }

    public void aplicarForcaDaGravidade() {
        if (isTerrestre()) {
            if (!player1.isMorto()) {
                PlayerTerrestre player1cast = (PlayerTerrestre) player1;
                if (player1cast.alturaAtual() > 0) {
                    player1cast.setLocation(player1cast.getX(), player1cast.getY() + FORCA_DE_GRAVIDADE);
                }
            }
            if (!player2.isMorto()) {
                PlayerTerrestre player2cast = (PlayerTerrestre) player2;
                if (player2cast.alturaAtual() > 0) {
                    player2cast.setLocation(player2cast.getX(), player2cast.getY() + FORCA_DE_GRAVIDADE);
                }
            }
        }
    }

    public abstract void droparInimigo();

    private void gameOver() {
        java.util.List<PlayerBase> myActors = getObjects(PlayerBase.class);

        if (myActors.isEmpty()) {
            Greenfoot.setWorld(new MundoGameOver());
        }
    }

    public void projetor(GreenfootImage novaCena) {
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

    public EnemyBase getBoss() {
        return boss;
    }

    public void setBoss(EnemyBase boss) {
        this.boss = boss;
    }

    public boolean isTerrestre() {
        return terrestre;
    }
}
