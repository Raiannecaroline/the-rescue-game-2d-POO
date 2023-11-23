import greenfoot.*;

public abstract class MundoEstatico extends MundoBase {
    private int timer = 0;
    private static final int TIMER_OBJETIVO = 50;
    private int cicloAtual = 1;

    public MundoEstatico(String imagemFundo) {
        super(imagemFundo);
    }

    public void act() {
        setCicloAtual();
        super.act();
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        if ((getCicloAtual() % 16) == 0) {
            timer++;
        }
    }

    public int getCicloAtual() {
        return cicloAtual;
    }

    public void setCicloAtual() {
        cicloAtual++;

        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    public int getTimerObjetivo() {
        return TIMER_OBJETIVO;
    }
}
