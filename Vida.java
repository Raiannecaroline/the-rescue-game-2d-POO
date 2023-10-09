import greenfoot.*;

public class Vida extends Actor {
    private int vidaDoPersonagem;

    public Vida(int vidaDoPersonagem) {
        this.vidaDoPersonagem = vidaDoPersonagem;
        atualizarTextoVida();
    }

    public void atualizarTextoVida() {
        GreenfootImage imagem = new GreenfootImage("Vida: " + vidaDoPersonagem, 20, Color.BLACK, null);
        setImage(imagem);
    }

    public void setVidaDoPersonagem(int novaVida) {
        vidaDoPersonagem = novaVida;
        atualizarTextoVida();
    }

    public int getVidaDoPersonagem() {
        return vidaDoPersonagem;
    }

    public void act() {
        // Código de atualização da classe Vida, se necessário
    }
}
