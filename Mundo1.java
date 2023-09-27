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
    public static final int QUANTIDADE_DE_QUADROS = 350;
    public static final int TAMANHO_DO_QUADRO = 4;
    public static final String NOME_ARQUIVO_IMAGEM = "cenarios/mundo1/m1f1_";
    public static final String EXTENSAO_ARQUIVO_IMAGEM = ".png";

    private int quadroAtual = 1;

    private int cicloAtual = 0;
  



    public Mundo1()
    {

        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
        GreenfootImage cenarioInicial = new GreenfootImage("mundo1.png");
        setBackground(cenarioInicial);

        Actor player1 = new Player(1);
        addObject(player1, 65, 318);
       


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
