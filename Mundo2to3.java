import greenfoot.*;

public class Mundo2to3 extends MundoEstatico {
    public Mundo2to3() {
        super("cutscene-game_0.png");
    }

    @Override
    public void proximoMundo() {
        String tecla = Greenfoot.getKey();

        if (tecla == "escape" || getTimer() == getTimerObjetivo()) {
            Greenfoot.setWorld(new Mundo3());
        }
    }
}