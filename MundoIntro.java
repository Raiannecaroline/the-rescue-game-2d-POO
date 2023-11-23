import greenfoot.*;

public class MundoIntro extends MundoEstatico {

    public MundoIntro() {
        super("intro_1.png");
    }



    @Override
    public void proximoMundo() {
        String tecla = Greenfoot.getKey();

        if (tecla == "escape" || getTimer() == getTimerObjetivo()) {
            Greenfoot.setWorld(new Mundo1());
        }
    }
}
