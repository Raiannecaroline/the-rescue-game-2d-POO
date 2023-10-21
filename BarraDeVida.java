import greenfoot.*;

public class BarraDeVida extends Actor {
    private int larguraMaxima;
    private int vidaAtual;
    
    public BarraDeVida(int larguraMaxima) {
        this.larguraMaxima = larguraMaxima;
        this.vidaAtual = larguraMaxima; // Define a vida inicial igual à vida máxima
        atualizarImagem();
    }

    public void diminuirVida(int quantidade) {
        vidaAtual -= quantidade;
        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
        atualizarImagem();
    }

    public void aumentarVida(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > larguraMaxima) {
            vidaAtual = larguraMaxima;
        }
        atualizarImagem();
    }

    private void atualizarImagem() {
        GreenfootImage imagem = new GreenfootImage(larguraMaxima, 10);
        imagem.setColor(Color.RED);
        imagem.fillRect(0, 0, larguraMaxima, 10);
        imagem.setColor(Color.GREEN);
        int larguraVida = (int) (((double) vidaAtual / larguraMaxima) * larguraMaxima);
        imagem.fillRect(0, 0, larguraVida, 10);
        setImage(imagem);
    }

    public void act() {
        atualizarImagem();
        // Atualize aqui, se necessário
    }
}
