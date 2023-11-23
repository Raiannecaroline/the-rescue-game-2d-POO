import greenfoot.*;

public class MundoGameOver extends MundoBase {
    public MundoGameOver() {
        super("game_over_0.png");
    }

    @Override
    public void proximoMundo() {
        String tecla = Greenfoot.getKey();

        if ("escape".equals(tecla)) {
            Greenfoot.setWorld(new Menu());
        }

    }
}
