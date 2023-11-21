import greenfoot.*;

public class Menu extends MundoBase {
    private static final int NUMERO_DE_TECLAS = 3;
    private int tela = 1;

    Menu menu;
    MundoBase fase1 = new MundoDinamico("mundo1", 336, "cenarios/CenariomovimentIlha/cenario_", ".png", null);
    MundoEstatico intro = new MundoEstatico("intro_1.png", fase1);
    MundoBase creditos = new MundoEstatico("autores.png", menu);

    public Menu() {
        super("menu_0" + "1" + ".png");
        this.menu = this;
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
                    executarOpcao();
                    break;
            }
        }
    }

    private void mudarTela(int incremento) {
        tela = (tela + incremento - 1 + NUMERO_DE_TECLAS) % NUMERO_DE_TECLAS + 1;
        atualizarTela();
    }

    private void atualizarTela() {
        setBackground("menu_0" + tela + ".png");
    }

    private void executarOpcao() {
        switch (tela) {
            case 1:
                Greenfoot.setWorld(intro);
                break;
            case 2:
                Greenfoot.setWorld(creditos);
                break;
            case 3:
                Greenfoot.stop();
                break;
        }
    }
}
