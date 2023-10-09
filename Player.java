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
    public String Direita = "null";
    public String Esquerda = "null";
    public String Pular = "null";
    public String Atirar = "null";
    public String Cima = "null";
    public int vidas =100;

    public static int TAXA_DE_ATUALIZACAO = 2;
    public static final int ALTURA_MAXIMA_PULO = 6;

    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;

    protected int identificadorPlayer;
    private boolean atirando = false;
    public boolean morte = false;
 
 
     private Vida BarraDevida1;
     private Vida BarraDevida2;
     

 

    public Player(int vidas) {
       this.vidas = vidas;
       
         // Valor inicial da vida do personagem
       
       

    }
     
    
    
    public Player(int vidas,int identificadorPlayer) {
        this.vidas = vidas;
        this.identificadorPlayer = identificadorPlayer;

    }
    public int getVidas(){
        return vidas;
    }
    public int getIdentificadorPlayer(){
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
    }

    public void act() {
       
       
            
        
        
        if (getWorld() != null){
         if (this.isTouching(DisparoEnemy.class)) {
                vidas--;
                

                if (vidas == 0) {
                    morte =true;
                   
                    getWorld().removeObject(this);
                    
                    return;
                    

                }
                
            
        }
        movimentacao();
        disparo();
    }

    }

    private void morte() {
       
            // Verifica se o objeto é uma instância da classe Player
           

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
        tiro.playSomDisparo();
        this.atirando = true;
        return tiro;
    }

    private void atirar(DisparoPlayer tiro) {
        getWorld().addObject(tiro, getX() + 5, getY());
    }

    private void ajustarDirecaoDoTiro(DisparoPlayer tiro) {
        if (Greenfoot.isKeyDown(Cima)) {
            if (Greenfoot.isKeyDown(Direita)) {
                tiro.setRotation(-45);
            } else {
                tiro.setRotation(-90);
            }
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

        gerenciamentoDaCaminhada();
        gerenciamentoDoPulo();
        if (Greenfoot.isKeyDown(Direita)) {
            move(2);
            setRotation(0);
        }
        if (Greenfoot.isKeyDown(Esquerda)) {
            move(-2);
            setRotation(0);
        }
        return;
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
        return ((alturaDosPes() - 20) - Mundo1.NIVEL_DO_SOLO) * -1;
    }

    private boolean possoAtualizar() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

    private boolean timer() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % 106) == 0;
    }

}
