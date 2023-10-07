import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Personagem {
<<<<<<< HEAD
=======
    public String NOME_ARQUIVO_IMAGEM = "player/player-";
    public String EXTENSAO_ARQUIVO_IMAGEM = ".png";
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78

    public int proximoPasso = 1;
    public String Direita = "null";
    public String Esquerda = "null";
    public String Pular = "null";
    public String Atirar = "null";
    public String Cima = "null";
    private int vidas = 3;

    public static int TAXA_DE_ATUALIZACAO = 2;
    public static final int ALTURA_MAXIMA_PULO = 6;

    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;

<<<<<<< HEAD
    private int identificadorPlayer = 0;
    
    public Personagem animacao;
    
   
    
=======
    private int identificadorPlayer;
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78

    public Player() {

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
   public Player(){
     super("player/player-", ".png",2,1,6,1);
        
    }

<<<<<<< HEAD
    public void act()
    {
        super.act();
        animacao.Animacao();
=======
    public void act() {
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78
        movimentacao();
        disparo();

    }

    private void morte() {
        java.util.List<AtaqueInimigo> ataques = getIntersectingObjects(AtaqueInimigo.class);

        for (AtaqueInimigo ataque : ataques) {
            // Verifica se o objeto é uma instância da classe Player
            if (ataque.getClass() == AtaqueInimigo.class) {
                vidas--;

                if (vidas == 0) {
                    getWorld().removeObject(this);

                }
            }
        }

    }

    private void disparo() {
        Tiro tiro = new Tiro();
<<<<<<< HEAD
        if(Greenfoot.isKeyDown(Atirar)){
            if(tiro.latencia == 1){
            getWorld().addObject(tiro,getX()+5,getY());
            if(Greenfoot.isKeyDown(Cima) && Greenfoot.isKeyDown(Direita)){
            tiro.setRotation(-45);
           
        
        }   
        if(Greenfoot.isKeyDown(Cima)&& !Greenfoot.isKeyDown(Direita)){
            tiro.setRotation(-90);
        
        }  
=======
        if (Greenfoot.isKeyDown(Atirar)) {
            if (tiro.latencia == 1) {
                getWorld().addObject(tiro, getX() + 5, getY());
                if (Greenfoot.isKeyDown(Cima) && Greenfoot.isKeyDown(Direita)) {
                    tiro.setRotation(-45);

                }
                if (Greenfoot.isKeyDown(Cima) && !Greenfoot.isKeyDown(Direita)) {
                    tiro.setRotation(-90);

                }
            }
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78
        }
    }

    private void gerenciamentoDoPulo() {

        capturaInicoDoPulo();
        executaSubidaDoPulo();
        executaDescidaDoPulo();
        executaApiceDoPulo();
        executaPousoDoPulo();

    }
<<<<<<< HEAD
    private void capturaInicoDoPulo(){
        
       if(alturaAtual()!=0 ){
        if(Greenfoot.isKeyDown(Pular)){
            
            estaEmTerraFirme = false;
            estaEmPulo = true;
            
        
=======

    private void capturaInicoDoPulo() {

        if (alturaAtual() != 0 || timer()) {
            if (Greenfoot.isKeyDown(Pular)) {

                estaEmTerraFirme = false;
                estaEmPulo = true;

            }
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78
        }
    }

<<<<<<< HEAD
    private void movimentacao(){
        
=======
    private void movimentacao() {

        gerenciamentoDaCaminhada();
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78
        gerenciamentoDoPulo();
        if (Greenfoot.isKeyDown(Direita)) {
            move(2);
            setRotation(0);
        }
        if (Greenfoot.isKeyDown(Esquerda)) {
            move(-2);
            setRotation(0);
        }
    }

<<<<<<< HEAD
  
=======
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
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78

    private void executaSubidaDoPulo() {
        if (alturaAtualDoPulo < ALTURA_MAXIMA_PULO && estaEmPulo) {
            alturaAtualDoPulo++;
            setLocation(getX(), getY() - Mundo1.FORCA_DE_GRAVIDADE * 2);

        }

    }

    private void executaApiceDoPulo() {
        if (alturaAtualDoPulo == ALTURA_MAXIMA_PULO) {
            estaEmPulo = false;

        }

    }

    private void executaDescidaDoPulo() {
        if (alturaAtualDoPulo > 0 && !estaEmPulo) {
            alturaAtualDoPulo--;

        }

    }

    private void executaPousoDoPulo() {
        if (alturaAtualDoPulo == 0 && !estaEmPulo) {
            estaEmTerraFirme = true;

        }

    }

    public int alturaDosPes() {
        return getY() + getImage().getHeight() / 2;
    }

    public int alturaAtual() {
        return ((alturaDosPes() - 20) - Mundo1.NIVEL_DO_SOLO) * -1;
    }

<<<<<<< HEAD
  
=======
    private boolean possoAtualizar() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

    private boolean timer() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % 106) == 0;
    }
>>>>>>> 891dec761ff551889055cedce5f3bc7051b69f78

}
