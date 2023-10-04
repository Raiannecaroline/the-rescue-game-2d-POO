import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {
    
    public int vida =5;
    public int proximoPasso = 0;
    private int raioDeteccao = 700;
    private int raioAtaque = 200;
    public static final String NOME_ARQUIVO_IMAGEM = "enemys/enemys-1";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";
    public static int TAXA_DE_ATUALIZACAO = 2;
    private int DropInimigo = Greenfoot.getRandomNumber(10);
    

   Animacao animacao = new Animacao(0,2,"enemys/enemys-1",".png",3);

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   

     public void gerenciamentoDaAnimacao() {
         
       setImage(new GreenfootImage(
                NOME_ARQUIVO_IMAGEM + "-" + proximoPasso + EXTENSAO_ARQUIVO_IMAGEM));
               

        if (possoAtualizar()) {
            proximoPasso++;
        }
        if (proximoPasso > 3) {

            proximoPasso = 0;
        }
   
    
}
   

    public void act() {
       
        movimentacao();
        disparoInimigo();
        morte();
        
       
            
            
            
           
}

private void morte(){
     java.util.List<Tiro> tiros = getIntersectingObjects(Tiro.class);
        
        for (Tiro tiro : tiros) {
            // Verifica se o objeto é uma instância da classe Player
            if (tiro.getClass() == Tiro.class) {
                vida--;
                 if(vida ==0){
             getWorld().removeObject(this);
            
             
            }
}
}
    
}
    
    private void disparoInimigo(){
        
        AtaqueInimigo ataque = new AtaqueInimigo();
        if(ataque.latencia == 1){
            getWorld().addObject(ataque,getX(),getY());
        }
    }
        
    

    private void movimentacao(){
        gerenciamentoDaAnimacao();
       
        if (isInRange()) {
            move(direcaoMovimento());

            // ataca();
        }

    }

    public int direcaoMovimento(){
        int xEnemy = getX();
        int xHeroiMaisProximo = getPlayerMaisProximo().getX();

        if (xEnemy < xHeroiMaisProximo){
            return 4;
        } else {
            return -4;
        }

    }

    public Player getPlayerMaisProximo(){
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() == 1){
            return  listaDePlayers.get(0);
        }

        int xEnemy = getX();
        int xHeroi1 = listaDePlayers.get(0).getX();
        int xHeroi2 = listaDePlayers.get(1).getX();

        if (xEnemy - xHeroi1 < xEnemy - xHeroi2){
            return  listaDePlayers.get(0);
        } else {
            return  listaDePlayers.get(1);
        }
    }

    public boolean isInRange(){
        List<Player> listaDePlayers = getListaDePlayers();

        if (listaDePlayers.size() != 0){
            return true;
        } else {
            return false;
        }
    }

    public List<Player> getListaDePlayers(){
        return getObjectsInRange(raioDeteccao, Player.class);
    }
     private boolean possoAtualizar() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

}
