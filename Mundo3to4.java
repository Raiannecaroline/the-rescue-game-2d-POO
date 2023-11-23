import greenfoot.*;

public class Mundo3to4 extends MundoEstatico {
    public Mundo3to4() {
        super("cutscene-game-cenario-4.png");
    }

    @Override
    public void proximoMundo() {
        String tecla = Greenfoot.getKey();
        if (tecla == "escape" || getTimer() == getTimerObjetivo()) {
            Greenfoot.setWorld(new Mundo4());
        }
    }
}
