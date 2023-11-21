import greenfoot.*;

public class MundoEstatico extends MundoBase {
    private int timer = 0;
    private int cicloAtual = 1;
    MundoBase proximoMundo;

    public MundoEstatico(String imagemFundo, MundoBase proximoMundo) {
        super(imagemFundo);
        this.proximoMundo = proximoMundo;
    }

    public void act() {
        setCicloAtual();
        proximoMundo(proximoMundo);
    }

    public void proximoMundo(MundoBase proximoMundo) {
        String tecla = Greenfoot.getKey();

        if (tecla == "esc") {
            Greenfoot.setWorld(proximoMundo);
        }
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
}
