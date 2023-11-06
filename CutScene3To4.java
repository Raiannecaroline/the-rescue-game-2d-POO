import greenfoot.*;

public class CutScene3To4 extends World {
    public static final int LARGURA_CENARIO = 700;
    public static final int ALTURA_CENARIO = 390;

    int cicloAtual = 0;
    int timer = 0;
    int timeFinal = 10;

    public CutScene3To4() {
        super(LARGURA_CENARIO, ALTURA_CENARIO, 1);
        setBackground("cutscene-game-cenario-4.png");
    }

    public void act() {
        contaCiclo();
        nextWorld();
    }

    public int cicloAtual() {
        return cicloAtual;
    }

    private void contaCiclo() {
        cicloAtual++;
        if ((cicloAtual() % 16) == 0) {
            timer++;
        }
        if (cicloAtual > 2000) {
            cicloAtual = 0;
        }
    }

    private void nextWorld() {
        if (timer == timeFinal) {
            Greenfoot.setWorld(new Mundo4());
        }
}
}
