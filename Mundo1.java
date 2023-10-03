import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mundo1 extends World
{
    public static final int LARGURA_CENARIO = 700;
    public static final int ALTURA_CENARIO = 390;
    public static final int QUANTIDADE_DE_QUADROS = 100;
    public static final int NIVEL_DO_SOLO = 336; 
    public static final int FORCA_DE_GRAVIDADE = 7; 
    public static final int TAMANHO_DO_QUADRO = 5;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/CenariomovimentIlha/cenario_";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int quadroAtual = 1;
    private int cicloAtual = 0;
    private Player heroi;
    private Player heroi2;
  

    public Mundo1()
    {

        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
        GreenfootImage cenarioInicial = new GreenfootImage("mundo1.png");
        setBackground(cenarioInicial);
        heroi = new Player(1,"right","left","up","enter");
        heroi2 = new Player(2,"d","a","w","t");
        addObject(heroi, 60, 336);
        addObject(heroi2, 80, 336);
       
        prepare();
        
       


    }
    public void prepare()
{
    Sound backgroundMusic = new Sound();
    addObject(backgroundMusic, 0, 0);
     backgroundMusic.play();
}


    public  void aplicarForcaDaGravidade(){
        if(heroi.alturaAtual() > 0){
            heroi.setLocation(heroi.getX(), heroi.getY()+FORCA_DE_GRAVIDADE);

        }
         if(heroi2.alturaAtual() > 0){
            heroi2.setLocation(heroi2.getX(), heroi2.getY()+FORCA_DE_GRAVIDADE);

        }
    }
    

     public int cicloAtual(){
        return cicloAtual;
     }

     private void contaCiclo(){
        cicloAtual++;
        if(cicloAtual >2000){
            cicloAtual=0;
        }
     }

    public void act(){

        projetor(proximaCena());
        aplicarForcaDaGravidade();
        contaCiclo();
        
    }


    private void projetor(GreenfootImage novaCena){
        setBackground(novaCena);
    }


    private GreenfootImage proximaCena(){
        GreenfootImage novaCena = filme();

        quadroAtual++;
        if(quadroAtual > QUANTIDADE_DE_QUADROS){
            quadroAtual = 1;
        }
        return novaCena;
    }


    private GreenfootImage filme(){

        GreenfootImage novaCena  =  new GreenfootImage(LARGURA_CENARIO,ALTURA_CENARIO);
        int posicaoDoQuadro = 0;
        int quadro = quadroAtual;
        while(posicaoDoQuadro < LARGURA_CENARIO ){
            if(quadro > QUANTIDADE_DE_QUADROS){
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
    private GreenfootImage imagemDoNovoQuadro(int proximoQuadro){
        String nomeDoArquivo = NOME_ARQUIVO_IMAGEM + proximoQuadro + EXTENSAO_ARQUIVO_IMAGEM;
        GreenfootImage novoQuadro = new GreenfootImage(nomeDoArquivo );
        return novoQuadro;

    }

}
