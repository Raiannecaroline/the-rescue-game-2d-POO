import greenfoot.*;

public class MundoCredito extends MundoEstatico {

    public MundoCredito() {
        super("autores.png");
    }

    @Override
    public void proximoMundo() {
        String tecla = Greenfoot.getKey();

        if ("escape".equals(tecla)) {
            Greenfoot.setWorld(new Menu());
        }
    }
}
