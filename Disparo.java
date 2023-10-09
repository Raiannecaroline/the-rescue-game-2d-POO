import greenfoot.*;

public abstract class Disparo extends Actor {
    private int alcance = Greenfoot.getRandomNumber(10) + 30;
    private int dano = 1;
    public int latencia = Greenfoot.getRandomNumber(3);
    private GreenfootSound somDisparo = new GreenfootSound("NES - Contra - Effects/disparoPlayer.wav");

    public void atirando(java.lang.Class<?> alvo) {
        int direcaoDisparo = 12;

        if (alvo == Player.class) {
            direcaoDisparo = -12;
        }

        alcance--;
        move(direcaoDisparo);
        // Verifica se existem objetos da classe Player no mundo
        if (alcance == 0 || isAtEdge()) {
            getWorld().removeObject(this);

        }
    }

    public boolean Latencia() {
        Mundo1 mundo = (Mundo1) getWorld();
        return (mundo.cicloAtual() % latencia) == 0;
    }

    public void playSomDisparo(){
        if (!somDisparo.isPlaying()) {
            somDisparo.play();
        }
    }
}
