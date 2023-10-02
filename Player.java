import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor {
    public static final String NOME_ARQUIVO_IMAGEM = "player/player-";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    public int proximoPasso = 1;
    public String Direita = "null";
    public String Esquerda = "null";
    public String Pular = "null";
    

    public static int TAXA_DE_ATUALIZACAO = 4;
    public static final int ALTURA_MAXIMA_PULO = 8;

    public boolean estaEmTerraFirme = true;
    public boolean estaEmPulo = false;
    public int alturaAtualDoPulo = 0;

    private int identificadorPlayer;

    /**
     * Act - do whatever the Gato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Player(int identificadorPlayer,String Direita,String Esquerda,String Pular) {
        super();
        this.identificadorPlayer = identificadorPlayer;
        this.Direita = Direita;
        this.Esquerda = Esquerda;
        this.Pular = Pular;
    }

    public void act()
    {
        movimentacao();
      
      
      
        
       



    }

    private void gerenciamentoDoPulo(){
        
        capturaInicoDoPulo();
        executaSubidaDoPulo();
        executaDescidaDoPulo();
        executaApiceDoPulo(); 
        executaPousoDoPulo();



    }
    private void capturaInicoDoPulo(){
        if(Greenfoot.isKeyDown(Pular)){
            
            estaEmTerraFirme = false;
            estaEmPulo = true;
            
        
        }

    }

    private void movimentacao(){
        
        gerenciamentoDaCaminhada();
        gerenciamentoDoPulo();
        if(Greenfoot.isKeyDown(Direita))
        {
            move(2);
            setRotation(0);
        }
        if(Greenfoot.isKeyDown(Esquerda))
        {
            move(-2);
            setRotation(0);
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
        return (alturaDosPes() - Mundo1.NIVEL_DO_SOLO) * -1;
    }

    private boolean possoAtualizar() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

}
