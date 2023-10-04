import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class animacao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animacao extends Actor
{
    public int ValorDaImagemInicial;
    public static int TAXA_DE_ATUALIZACAO;
    public static  String NOME_ARQUIVO_IMAGEM;
    public static  String EXTENSAO_ARQUIVO_IMAGEM;
    public static int QuantidadeDeImagens;
    
    

    
    public Animacao(int ValorDaImagemInicial,int TAXA_DE_ATUALIZACAO,String NOME_ARQUIVO_IMAGEM,String EXTENSAO_ARQUIVO_IMAGEM,int QuantidadeDeImagens){
        this.ValorDaImagemInicial = ValorDaImagemInicial;
        this.TAXA_DE_ATUALIZACAO=TAXA_DE_ATUALIZACAO;
        this.NOME_ARQUIVO_IMAGEM=NOME_ARQUIVO_IMAGEM;
        this.EXTENSAO_ARQUIVO_IMAGEM = EXTENSAO_ARQUIVO_IMAGEM;
        this.QuantidadeDeImagens = QuantidadeDeImagens;
       
    }
    
    
    public void act( )
    {
        
        // Add your action code here.
    }
     private boolean possoAtualizar() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO) == 0;
    }

     public void gerenciamentoDaAnimacao() {
         
        setImage(new GreenfootImage(
                NOME_ARQUIVO_IMAGEM +"-"+ ValorDaImagemInicial + EXTENSAO_ARQUIVO_IMAGEM));
               

        if (possoAtualizar()) {
            ValorDaImagemInicial++;
        
        if (ValorDaImagemInicial >QuantidadeDeImagens) {

            ValorDaImagemInicial = 1;
        }
        
    }
}
}
