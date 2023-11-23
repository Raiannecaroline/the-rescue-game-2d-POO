import greenfoot.*;

public class Menu extends MundoBase {
    private static final int NUMERO_DE_TECLAS = 3;
    private int tela = 1;

    public Menu() {
        super("menu_01.png");
    }

    public void act() {
        processarTeclado();
    }

    private void processarTeclado() {
        String key = Greenfoot.getKey();
        if (key != null) {
            switch (key) {
                case "s":
                case "down":
                    mudarTela(1);
                    break;
                case "w":
                case "up":
                    mudarTela(-1);
                    break;
                case "enter":
                    proximoMundo();
                    break;
            }
        }
    }

    @Override
    public void proximoMundo() {
        switch (tela) {
            case 1:
                Greenfoot.setWorld(new MundoIntro());
                break;
            case 2:
                Greenfoot.setWorld(new MundoCredito());
                break;
            case 3:
                Greenfoot.stop();
                break;
        }

    }

    private void mudarTela(int incremento) {
        tela = (tela + incremento - 1 + NUMERO_DE_TECLAS) % NUMERO_DE_TECLAS + 1;
        atualizarTela();
    }

    private void atualizarTela() {
        setBackground("menu_0" + tela + ".png");
    }
}
