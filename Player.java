import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Personagem {
    public String NOME_ARQUIVO_IMAGEM = "player/player-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    public int proximoPasso = 1;
    public String Direita;
    public String Esquerda;
    public String Pular;
    public String Atirar;
    public String Cima;
    public int vidas = 5;
    public int timer = 0;
    private int cicloAtual = 0;

    public static int TAXA_DE_ATUALIZACAO = 2;
    public static final int ALTURA_MAXIMA_PULO = 6;

    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;

    protected int identificadorPlayer;
    private boolean atirando = false;
    public boolean morte1;

    private Vida BarraDevida1;
    private Vida BarraDevida2;
    
    private boolean transparency = false; 
    private int transparentDuration = 600;
    
    

     

    public Player(int vidas) {
        this.vidas = vidas;
        morte1 = false;

        // Valor inicial da vida do personagem

    }
    

    public Player(int vidas, int identificadorPlayer) {
        this.vidas = vidas;
        this.identificadorPlayer = identificadorPlayer;

    }

    public int getVidas() {
        return vidas;
    }

    public int getIdentificadorPlayer() {
        return identificadorPlayer;
    }

    public Player(int identificadorPlayer, String Direita, String Esquerda, String Pular, String Atirar, String Cima) {
        super();
        this.identificadorPlayer = identificadorPlayer;
        this.Direita = Direita;
        this.Esquerda = Esquerda;
        this.Pular = Pular;
        this.Atirar = Atirar;
        this.Cima = Cima;
        setImage(NOME_ARQUIVO_IMAGEM+identificadorPlayer+"-9"+EXTENSAO_ARQUIVO_IMAGEM);
    }

    public void act() {
    
         

        morte();
        movimentacao();
        disparo();

    }
    public void setTransparency(int t) {
        GreenfootImage image = getImage();
        image.setTransparency(t); // Define a transparência da imagem do jogador
    }
    
    private void morte() {

        if (isTouching(DisparoEnemy.class)) {
          
            removeTouching(DisparoEnemy.class);
            vidas--;
            if(vidas> 1){
                
           
            Sound dano = new Sound("somhit.wav");
              dano.play();
           
             }
              

            if (vidas == 0) {

                morte1 = true;
                 Sound morte = new Sound("deadplayer.wav");
                 morte.play();

                getWorld().removeObject(this);

            }

        }

    }

    public void disparo() {
        if (deveAtirar() && !isAtirando()) {
            DisparoPlayer tiro = criarTiro();
            atirar(tiro);
            ajustarDirecaoDoTiro(tiro);
        } else if (!deveAtirar()) {
            pararAtirar();
        }
    }

    private boolean deveAtirar() {
        return Greenfoot.isKeyDown(Atirar);
    }
    

    private boolean isAtirando() {
        return this.atirando;
    }

    private DisparoPlayer criarTiro() {
        DisparoPlayer tiro = new DisparoPlayer();
          setTransparency(50);
        tiro.playSomDisparo();
        this.atirando = true;
        return tiro;
    }

    private void atirar(DisparoPlayer tiro) {
        getWorld().addObject(tiro, getX() + 5, getY());
    }

    private void ajustarDirecaoDoTiro(DisparoPlayer tiro) {
        if (Greenfoot.isKeyDown(Cima) && Greenfoot.isKeyDown(Direita)) {
            tiro.setRotation(-45);
        } else if (Greenfoot.isKeyDown(Cima) && Greenfoot.isKeyDown(Esquerda)) {
            tiro.setRotation(-135);
        } else if (Greenfoot.isKeyDown(Cima)) {
            tiro.setRotation(-90);
        } else if (Greenfoot.isKeyDown(Direita)) {
            tiro.setRotation(0);
        } else if (Greenfoot.isKeyDown(Esquerda)) {
            tiro.setRotation(180);
        }
    }

    private void pararAtirar() {
        this.atirando = false;
    }

    private void gerenciamentoDoPulo() {

        capturaInicoDoPulo();
        executaSubidaDoPulo();
        executaDescidaDoPulo();
        executaApiceDoPulo();
        executaPousoDoPulo();

    }

    private void capturaInicoDoPulo() {

        if (alturaAtual() != 0 || timer()) {
            if (Greenfoot.isKeyDown(Pular)) {

                estaEmTerraFirme = false;
                estaEmPulo = true;

            }
        }
    }

    private void movimentacao() {
        if (!morte1) {

            gerenciamentoDaCaminhada();
            gerenciamentoDoPulo();
            if (Greenfoot.isKeyDown(Direita)) {
                move(3);
                setRotation(0);

            }
            if (Greenfoot.isKeyDown(Esquerda)) {
                move(-3);
                setRotation(0);
                getImage().mirrorHorizontally();
            }
        }

    }

    private void gerenciamentoDaCaminhada() {

        setImage(new GreenfootImage(
                NOME_ARQUIVO_IMAGEM + identificadorPlayer + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM));

        if (possoAtualizar()) {
            proximoPasso++;
        }
        if (proximoPasso > 6) {

            proximoPasso = 1;
        }

    }

    private void executaSubidaDoPulo() {
        if (alturaAtualDoPulo < ALTURA_MAXIMA_PULO && estaEmPulo) {
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - Mundo1.FORCA_DE_GRAVIDADE * 2);

        }
        return;
    }

    private void executaApiceDoPulo() {
        if (alturaAtualDoPulo == ALTURA_MAXIMA_PULO) {
            estaEmPulo = false;

        }
        return;
    }

    private void executaDescidaDoPulo() {
        if (alturaAtualDoPulo > 0 && !estaEmPulo) {
            alturaAtualDoPulo--;

        }
        return;
    }

    private void executaPousoDoPulo() {
        if (alturaAtualDoPulo == 0 && !estaEmPulo) {
            estaEmTerraFirme = true;

        }
        return;
    }

    public int alturaDosPes() {
        return getY() + getImage().getHeight() / 2;

    }

    public int alturaAtual() {

        if (getWorld() instanceof Mundo1) {
            return ((alturaDosPes() - 20) - Mundo1.NIVEL_DO_SOLO) * -1;
        } else if (getWorld() instanceof Mundo2) {
            return ((alturaDosPes() - 20) - Mundo2.NIVEL_DO_SOLO) * -1;
        } else if (getWorld() instanceof Mundo3) {
            return ((alturaDosPes() - 20) - Mundo3.NIVEL_DO_SOLO) * -1;
        } else if (getWorld() instanceof Mundo4) {
            return ((alturaDosPes() - 20) - Mundo4.NIVEL_DO_SOLO) * -1;
        } else {
            // Lógica de retorno padrão caso o objeto não esteja em Mundo1 ou Mundo2
            return 0;
        }
    }

    private boolean possoAtualizar() {

        return (cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
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

    private boolean timer() {
        World mundo = getWorld();

        if (mundo instanceof Mundo1) {
            Mundo1 mundo1 = (Mundo1) mundo;
            return (mundo1.cicloAtual() % 106) == 0;

        } else if (mundo instanceof Mundo2) {
            Mundo2 mundo2 = (Mundo2) mundo;
            return (mundo2.cicloAtual() % 106) == 0;

        } else if (mundo instanceof Mundo3) {
            Mundo3 mundo3 = (Mundo3) mundo;
            return (mundo3.cicloAtual() % 106) == 0;

        } else if (mundo instanceof Mundo4) {
            Mundo4 Mundo4 = (Mundo4) mundo;
            return (Mundo4.cicloAtual() % 106) == 0;
        }

        return false;
    }

    public boolean existemObjetosDaClasse(Class classeDesejada) {
        World mundo = getWorld(); // Obtém o mundo atual

        // Percorre todos os objetos no mundo
        for (Object objeto : mundo.getObjects(null)) {
            if (objeto.getClass() == classeDesejada) {
                return true; // Encontrou pelo menos um objeto da classe
            }
        }

        return false; // Não encontrou objetos da classe
    }

}
